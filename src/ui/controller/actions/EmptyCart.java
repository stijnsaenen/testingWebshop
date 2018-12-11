package ui.controller.actions;

import domain.model.Product;
import ui.controller.RequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class EmptyCart extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        ArrayList<Product> producten = (ArrayList<Product>) session.getAttribute("cartproducten");
        producten.clear();
        session.setAttribute("cartproducten", producten);
        return "cart.jsp";
    }
}
