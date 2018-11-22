package ui.controller.actions;

import ui.controller.RequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteConfirmation extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String delete = request.getParameter("delete");
        String id = request.getParameter("id");
        if(delete.toUpperCase().equals("JA")){
            getService().deleteProduct(id);
            return "products.jsp";
        }else{
            return "index.jsp";
        }
    }
}
