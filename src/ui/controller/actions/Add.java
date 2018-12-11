package ui.controller.actions;

import domain.model.DomainException;
import domain.model.Product;
import ui.controller.RequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class Add extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Product product = new Product();
        ArrayList<String> errors = new ArrayList<>();
        try{
            maakName(request, product, errors);
            maakDescription(request, product, errors);
            maakprice(request, product, errors);
            maakId(request, product, errors);
        }catch (Exception e){
            errors.add(e.getMessage());
        }
        if(errors.size() == 0){
            getService().addProduct(product);
            request.setAttribute("products", getService().getAll());
            return "products.jsp";
        }else{
            request.setAttribute("errors", errors);
            return "addProduct.jsp";
        }
    }

    private void maakId(HttpServletRequest request, Product product, ArrayList<String> errors){
        String id = request.getParameter("id");
        try{
            product.setProductId(Integer.parseInt(id));
        }catch (DomainException e){
            errors.add(e.getMessage());
        }catch (Exception e){
            errors.add(e.getMessage());
        }
    }

    private void maakprice(HttpServletRequest request, Product product, ArrayList<String> errors) {
        String price = request.getParameter("price");
        try{
            product.setPrice(price);
        }catch (DomainException e){
            errors.add(e.getMessage());
        }
    }

    private void maakDescription(HttpServletRequest request, Product product, ArrayList<String> errors) {
        String description = request.getParameter("description");
        try{
            product.setDescription(description);
        }catch (DomainException e){
            errors.add(e.getMessage());
        }
    }

    private void maakName(HttpServletRequest request, Product product, ArrayList<String> errors) {
        String name = request.getParameter("name");
        try{
            product.setName(name);
        }catch (DomainException e){
            errors.add(e.getMessage());
        }
    }
}
