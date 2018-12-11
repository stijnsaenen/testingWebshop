package ui.controller.actions;

import domain.db.DbException;
import ui.controller.RequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Check extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String text;
        try{
            if(password == null || password.trim().isEmpty() || !getService().check(id, password)){
                text = "Password of " + getService().getPerson(id).getEmail() + " is incorrect";
                request.setAttribute("text", text);
                request.setAttribute("id", id);
                return "check.jsp";
            }else{
                text = "Password of " + getService().getPerson(id).getEmail() + " is correct";
                request.setAttribute("text", text);
                request.setAttribute("id", id);
                return "check.jsp";
            }
        }catch (Exception e){
            throw new DbException(e);
        }

    }
}
