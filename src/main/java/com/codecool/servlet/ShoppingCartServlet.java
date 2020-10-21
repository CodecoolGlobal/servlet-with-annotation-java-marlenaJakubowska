package com.codecool.servlet;

import com.codecool.model.Cart;
import com.codecool.model.Item;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(urlPatterns = {"/cart", "/add/"}, loadOnStartup = 0)
public class ShoppingCartServlet extends HttpServlet {

    static Cart cart;

    public ShoppingCartServlet() {
        cart = new Cart();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        JtwigTemplate template = JtwigTemplate.classpathTemplate("/cart.twig");
        JtwigModel model = JtwigModel.newModel();
        double totalPrice = cart.getItems().stream().mapToDouble(Item::getPrice).sum();
        model.with("totalPrice", totalPrice);
        model.with("cart", cart.getItems());
        String message = template.render(model);
        out.println(message);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int itemId = Integer.parseInt(req.getParameterMap().get("id")[0].replace("/", ""));
        System.out.println(itemId);
        cart.removeItem(WebShopServlet.stock.getItem(itemId));
        doGet(req, resp);
    }
}
