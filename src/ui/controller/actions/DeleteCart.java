package ui.controller.actions;

import domain.model.Person;
import domain.model.Product;
import ui.controller.RequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Iterator;

public class DeleteCart extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        ArrayList<Product> producten = (ArrayList<Product>) session.getAttribute("cartproducten");
        int id = Integer.parseInt(request.getParameter("id"));

        Iterator<Product> iter = producten.iterator();
        while(iter.hasNext()){
            Product p = iter.next();
            if(p.getProductId() == id){
                iter.remove();
            }
        }

        session.setAttribute("cartproducten", producten);
        return "cart.jsp";
    }

}
