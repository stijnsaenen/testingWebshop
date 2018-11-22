package ui.controller.actions;

import ui.controller.RequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Products extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("products", getService().getAll());
        return "products.jsp";
    }
}
