package com.codecool.servlet;

import com.codecool.model.Stock;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "WebShopServlet", urlPatterns = {"/shop"}, loadOnStartup = 1)
public class WebShopServlet extends HttpServlet {

    static Stock stock;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        JtwigTemplate template = JtwigTemplate.classpathTemplate("/shop.twig");
        JtwigModel model = JtwigModel.newModel();
        model.with("stock", stock.getItems());
        String message = template.render(model);
        out.println(message);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int itemId = Integer.parseInt(req.getParameterMap().get("id")[0].replace("/", ""));
        System.out.println("item id: "+itemId);
        ShoppingCartServlet.cart.addItem(stock.getItem(itemId));
        doGet(req, resp);
    }

    @Override
    public void init() throws ServletException {
        stock = new Stock();
    }
}
