package ui.controller.actions;

import domain.model.Product;
import ui.controller.RequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class History extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        ArrayList<Product> orders;
        orders = (ArrayList<Product>) session.getAttribute("orders");
        request.setAttribute("orders", orders);
        session.setAttribute("totprice", getService().getTotalOrderPrice());
        return "history.jsp";
    }
}
