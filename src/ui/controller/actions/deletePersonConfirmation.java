package ui.controller.actions;

import ui.controller.RequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class deletePersonConfirmation extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String delete = request.getParameter("delete");
        if(delete.toUpperCase().equals("JA")){
            getService().deletePerson(id);
            return "personoverview.jsp";
        }else{
            return "index.jsp";
        }
    }
}
