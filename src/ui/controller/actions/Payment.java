package ui.controller.actions;

import domain.model.Product;
import ui.controller.RequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class Payment extends RequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        ArrayList<Product> products = (ArrayList<Product>) session.getAttribute("cartproducten");
        if(products == null){
            ArrayList<Product> producten;
            producten = (ArrayList<Product>) session.getAttribute("cartproducten");
            request.setAttribute("cartproducten", producten);
            String error = "Add items to your cart to proceed with the payment!";
            request.setAttribute("error",error);
            return "cart.jsp";
        }else{
            return "payment.jsp";
        }
    }
}
