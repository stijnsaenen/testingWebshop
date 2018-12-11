package ui.controller.actions;

import domain.db.DbException;
import domain.model.DomainException;
import domain.model.Product;
import ui.controller.RequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class AddCart extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        ArrayList<Product> products;
        if (session.getAttribute("cartproducten") != null){
            products = (ArrayList<Product>) session.getAttribute("cartproducten");
        }else{
            products = new ArrayList<>();
        }
        //String sessionId = session.getId();
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = getService().getProduct(id);
        products.add(product);
        session.setAttribute("cartproducten", products);
        request.setAttribute("products", getService().getAll());
        return "products.jsp";
    }
}

