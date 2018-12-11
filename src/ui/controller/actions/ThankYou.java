package ui.controller.actions;

import domain.db.DbException;
import domain.model.Order;
import domain.model.Product;
import ui.controller.RequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class ThankYou extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws CloneNotSupportedException{
        HttpSession session = request.getSession();
        Order order = new Order();
        ArrayList<String> errors = new ArrayList<>();
        try{
            maakAddress(request, order, errors);
            maakPlace(request, order, errors);
            maakPostcode(request, order, errors);
            maakInvoice(request, order, errors);
            maakProductlist(request, order, errors);
        }catch (IllegalArgumentException e){
            errors.add(e.getMessage());
        }
        if (errors.size() == 0 ){
            try{
                ArrayList<Order> orders;
                if (session.getAttribute("orders") != null){

                    orders = (ArrayList<Order>) session.getAttribute("orders");
                }else{
                    orders = new ArrayList<>();
                }
                orders.add(order);
                session.setAttribute("orders",orders);
            }catch (Exception e){
                throw new DbException(e);
            }
            ArrayList<Product> producten = (ArrayList<Product>) session.getAttribute("cartproducten");
            producten.clear();
            session.setAttribute("cartproducten", producten);
            return "thankyou.jsp";
        }else{
            request.setAttribute("errors", errors);
            return "payment.jsp";
        }
    }

    private void maakProductlist(HttpServletRequest request, Order order, ArrayList<String> errors) throws CloneNotSupportedException {
        HttpSession session = request.getSession();
        ArrayList<Product> productensession = (ArrayList<Product>) session.getAttribute("cartproducten");
        ArrayList<Product> producten;
        producten = clone(productensession);
        try{
            order.setProductlist(producten);
        }catch (Exception e){
            errors.add(e.getMessage());
        }
    }
    private ArrayList<Product> clone(ArrayList<Product> old) throws CloneNotSupportedException{
        ArrayList<Product> res = new ArrayList<>();
        for(Product p : old) {
            res.add(p.clone());
        }
        return res;
    }
    private void maakInvoice(HttpServletRequest request, Order order, ArrayList<String> errors) {
        String invoice = request.getParameter("invoice");
        Boolean bool = Boolean.parseBoolean(invoice);
        try{
            order.setInvoice(bool);
        }catch (Exception e){
            errors.add(e.getMessage());
        }
    }

    private void maakPostcode(HttpServletRequest request, Order order, ArrayList<String> errors) {
        String postcode = request.getParameter("postcode");
        try{
            order.setZip(postcode);
        }catch (Exception e){
            errors.add(e.getMessage());
        }
    }

    private void maakPlace(HttpServletRequest request, Order order, ArrayList<String> errors) {
        String place = request.getParameter("place");
        try{
            order.setPlace(place);
        }catch (Exception e){
            errors.add(e.getMessage());
        }
    }


    private void maakAddress(HttpServletRequest request, Order order, ArrayList<String> errors) {
        String address = request.getParameter("adres");
        try{
            order.setAddress(address);
        }catch (Exception e){
            errors.add(e.getMessage());
        }
    }

}
