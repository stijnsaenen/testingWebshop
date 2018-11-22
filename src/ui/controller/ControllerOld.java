//package ui.controller;
//
//import domain.db.DbException;
//import domain.db.ShopService;
//import domain.model.DomainException;
//import domain.model.Person;
//import domain.model.Product;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Properties;
//
//@WebServlet("/ControllerOld")
//public class ControllerOld extends HttpServlet {
//
//    //private PersonDb personDB;// = new PersonDBPostgres();
//    //private PersonDbInMemory personDB = new PersonDbInMemory();
//    //private ProductDbInMemory productDB = new ProductDbInMemory();
//    //private ProductDb productDB; // = new ProductDBPostgres();
//    private ShopService service;
//
//    @Override
//    public void init() throws ServletException{
//        super.init();
//        ServletContext context = getServletContext();
//
//        Properties properties = new Properties();
//        properties.setProperty("user", context.getInitParameter("user"));
//        properties.setProperty("password", context.getInitParameter("password"));
//        properties.setProperty("ssl", context.getInitParameter("ssl"));
//        properties.setProperty("sslfactory", context.getInitParameter("sslfactory"));
//        //properties.setProperty("sslmode", context.getInitParameter("sslmode"));
//        properties.setProperty("url", context.getInitParameter("url"));
//        service = new ShopService(properties);
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        requestHandler(request,response);
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        requestHandler(request, response);
//    }
//
//    private void requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String action = request.getParameter("action");
//        String destination = "";
//        if(action != null) {
//            switch (action) {
//                case "overview":
//                    destination = overview(request, response);
//                    break;
//                case "signUp":
//                    destination = "signUp.jsp";
//                    break;
//                case "sign_Up":
//                    destination = sign_Up(request, response);
//                    break;
//                case "products":
//                    destination = products(request, response);
//                    break;
//                case "addProduct":
//                    destination = "addProduct.jsp";
//                    break;
//                case "add":
//                    destination = add(request, response);
//                    break;
//                case "change":
//                    destination = change(request, response);
//                    break;
//                case "update":
//                    destination = update(request, response);
//                    break;
//                case "delete":
//                    destination = delete(request, response);
//                    break;
//                case "deleteConfirmation":
//                    destination = deleteConfirmation(request, response);
//                    break;
//                case "deletePerson":
//                    destination = deletePerson(request, response);
//                    break;
//                case "deletePersonConfirmation":
//                    destination = deletePersonConfirmation(request, response);
//                    break;
//                case "checkpass":
//                    destination = checkPass(request, response);
//                    break;
//                case "check":
//                    destination = check(request, response);
//                    break;
//                default:
//                    destination = "index.jsp";
//            }
//        }else{
//            destination = "index.jsp";
//        }
//        RequestDispatcher view = request.getRequestDispatcher(destination);
//        view.forward(request, response);
//    }
//
//    private String checkPass(HttpServletRequest request, HttpServletResponse response){
//        String id = request.getParameter("id");
//        request.setAttribute("id", id);
//        return "check.jsp";
//    }
//
//    private String check(HttpServletRequest request, HttpServletResponse response) {
//        String id = request.getParameter("id");
//        String password = request.getParameter("password");
//        String text = "";
//        try{
//            if(password == null || password.trim().isEmpty() || !service.check(id, password)){
//                text = "Password of " + service.getPerson(id).getEmail() + " is incorrect";
//                request.setAttribute("text", text);
//                request.setAttribute("id", id);
//                return "check.jsp";
//            }else{
//                text = "Password of " + service.getPerson(id).getEmail() + " is correct";
//                request.setAttribute("text", text);
//                request.setAttribute("id", id);
//                return "check.jsp";
//            }
//        }catch (Exception e){
//            throw new DbException(e);
//        }
//
//    }
//
//    private String deletePersonConfirmation(HttpServletRequest request, HttpServletResponse response){
//        String id = request.getParameter("id");
//        String delete = request.getParameter("delete");
//        if(delete.toUpperCase().equals("JA")){
//            service.deletePerson(id);
//            return "personoverview.jsp";
//        }else{
//            return "index.jsp";
//        }
//    }
//
//    private String deletePerson(HttpServletRequest request, HttpServletResponse response){
//        String id = request.getParameter("id");
//        request.setAttribute("id", id);
//        request.setAttribute("person", service.getPerson(id));
//        return "deletePerson.jsp";
//    }
//
//    private String deleteConfirmation(HttpServletRequest request, HttpServletResponse response){
//        String delete = request.getParameter("delete");
//        String id = request.getParameter("id");
//        if(delete.toUpperCase().equals("JA")){
//            service.deleteProduct(id);
//            return "products.jsp";
//        }else{
//            return "index.jsp";
//        }
//    }
//
//    private String delete(HttpServletRequest request, HttpServletResponse response){
//        String id = request.getParameter("id");
//        request.setAttribute("id", id);
//        request.setAttribute("product", service.getProduct(Integer.parseInt(id)));
//        return "delete.jsp";
//    }
//
//    private String update(HttpServletRequest request, HttpServletResponse response){
//        ArrayList<String> errors = new ArrayList<>();
//        String id = request.getParameter("id");
//        Product product = new Product();
//        try{
//            product.setProductId(Integer.parseInt(id));
//            maakName(request, product, errors);
//            maakprice(request, product, errors);
//            maakDescription(request, product, errors);
//        }catch (Exception e){
//            errors.add(e.getMessage());
//        }
//        if(errors.size() == 0){
//            service.updateProduct(product);
//            request.setAttribute("products", service.getAll());
//            return "products.jsp";
//        }else{
//            return "update.jsp";
//        }
//
//    }
//
//    private String change(HttpServletRequest request, HttpServletResponse response){
//        String id = request.getParameter("product");
//        Product product = service.getProduct(Integer.parseInt(id));
//        request.setAttribute("product", product);
//        return "update.jsp";
//    }
//
//    private String add(HttpServletRequest request, HttpServletResponse response){
//        Product product = new Product();
//        ArrayList<String>errors = new ArrayList<>();
//        try{
//            maakName(request, product, errors);
//            maakDescription(request, product, errors);
//            maakprice(request, product, errors);
//            maakId(request, product, errors);
//        }catch (Exception e){
//            errors.add(e.getMessage());
//        }
//        if(errors.size() == 0){
//            service.addProduct(product);
//            request.setAttribute("products", service.getAll());
//            return "products.jsp";
//        }else{
//            request.setAttribute("errors", errors);
//            return "addProduct.jsp";
//        }
//    }
//
//    private void maakId(HttpServletRequest request, Product product, ArrayList<String> errors){
//        String id = request.getParameter("id");
//        try{
//            product.setProductId(Integer.parseInt(id));
//        }catch (DomainException e){
//            errors.add(e.getMessage());
//        }catch (Exception e){
//            errors.add(e.getMessage());
//        }
//    }
//
//    private void maakName(HttpServletRequest request, Product product, ArrayList<String> errors){
//        String name = request.getParameter("name");
//        try{
//            product.setName(name);
//        }catch (DomainException e){
//            errors.add(e.getMessage());
//        }
//    }
//
//    private void maakDescription(HttpServletRequest request, Product product, ArrayList<String> errors){
//        String description = request.getParameter("description");
//        try{
//            product.setDescription(description);
//        }catch (DomainException e){
//            errors.add(e.getMessage());
//        }
//    }
//
//    private void maakprice(HttpServletRequest request, Product product, ArrayList<String> errors){
//        String price = request.getParameter("price");
//        try{
//            product.setPrice(price);
//        }catch (DomainException e){
//            errors.add(e.getMessage());
//        }
//    }
//
//    private String products(HttpServletRequest request, HttpServletResponse response){
//        request.setAttribute("products", service.getAll());
//        return "products.jsp";
//    }
//
//    private String overview(HttpServletRequest request, HttpServletResponse response){
//            request.setAttribute("personen", service.getPersons());
//            return "personoverview.jsp";
//    }
//
//    private String sign_Up(HttpServletRequest request, HttpServletResponse response){
//        Person person = new Person();
//        ArrayList<String>errors = new ArrayList<>();
//        try{
//            maakEmail(request, person, errors);
//            maakVoorNaam(request, person, errors);
//            maakAchterNaam(request, person, errors);
//            maakPassword(request, person, errors);
//            maakUserId(request, person, errors);
//        }catch (IllegalArgumentException e){
//            errors.add(e.getMessage());
//        }
//        if (errors.size() == 0 ){
//            try{
//                service.addPerson(person);
//            }catch (Exception e){
//                throw new DbException(e);
//            }
//            request.setAttribute("persons", service.getPersons());
//            return "index.jsp";
//        }else{
//            request.setAttribute("errors", errors);
//            return "signUp.jsp";
//        }
//    }
//
//    private void maakEmail(HttpServletRequest request, Person person, ArrayList<String> errors){
//        String email = request.getParameter("email");
//        try{
//            person.setEmail(email);
//        }catch (Exception e){
//            errors.add(e.getMessage());
//        }
//    }
//
//    private void maakVoorNaam(HttpServletRequest request, Person person, ArrayList<String> errors){
//        String firstName = request.getParameter("firstName");
//        try{
//            person.setFirstName(firstName);
//        }catch (Exception e){
//            errors.add(e.getMessage());
//        }
//    }
//
//    private void maakAchterNaam(HttpServletRequest request, Person person, ArrayList<String> errors){
//        String lastName = request.getParameter("lastName");
//        try{
//            person.setLastName(lastName);
//        }catch (Exception e){
//            errors.add(e.getMessage());
//        }
//    }
//
//    private void maakPassword(HttpServletRequest request, Person person, ArrayList<String> errors){
//        String password = request.getParameter("password");
//        try{
//            person.setPassword(password);
//        }catch (Exception e){
//            errors.add(e.getMessage());
//        }
//    }
//
//    private void maakUserId(HttpServletRequest request, Person person, ArrayList<String> errors){
//        String userId = request.getParameter("userid");
//        try{
//            person.setUserid(userId);
//        }catch (Exception e){
//            errors.add(e.getMessage());
//        }
//    }
//}
