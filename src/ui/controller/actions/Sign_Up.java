package ui.controller.actions;

import domain.db.DbException;
import domain.model.Person;
import ui.controller.RequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class Sign_Up extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Person person = new Person();
        ArrayList<String> errors = new ArrayList<>();
        try{
            maakEmail(request, person, errors);
            maakVoorNaam(request, person, errors);
            maakAchterNaam(request, person, errors);
            maakPassword(request, person, errors);
            maakUserId(request, person, errors);
        }catch (IllegalArgumentException e){
            errors.add(e.getMessage());
        }
        if (errors.size() == 0 ){
            try{
                getService().addPerson(person);
            }catch (Exception e){
                throw new DbException(e);
            }
            request.setAttribute("persons", getService().getPersons());
            return "index.jsp";
        }else{
            request.setAttribute("errors", errors);
            return "signUp.jsp";
        }
    }

    private void maakUserId(HttpServletRequest request, Person person, ArrayList<String> errors){
        String userId = request.getParameter("userid");
        try{
            person.setUserid(userId);
        }catch (Exception e){
            errors.add(e.getMessage());
        }
    }

    private void maakPassword(HttpServletRequest request, Person person, ArrayList<String> errors) {
        String password = request.getParameter("password");
        try{
            person.setPassword(password);
        }catch (Exception e){
            errors.add(e.getMessage());
        }
    }

    private void maakAchterNaam(HttpServletRequest request, Person person, ArrayList<String> errors) {
        String lastName = request.getParameter("lastName");
        try{
            person.setLastName(lastName);
        }catch (Exception e){
            errors.add(e.getMessage());
        }
    }

    private void maakVoorNaam(HttpServletRequest request, Person person, ArrayList<String> errors) {
        String firstName = request.getParameter("firstName");
        try{
            person.setFirstName(firstName);
        }catch (Exception e){
            errors.add(e.getMessage());
        }
    }

    private void maakEmail(HttpServletRequest request, Person person, ArrayList<String> errors) {
        String email = request.getParameter("email");
        try{
            person.setEmail(email);
        }catch (Exception e){
            errors.add(e.getMessage());
        }
    }
}
