package ui.controller;

import domain.db.ShopService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ShopService service;
    private HandlerFactory handlerFactory = new HandlerFactory();

    public Controller(){
        super();
    }

    public void init() throws ServletException{
        super.init();
        ServletContext context = getServletContext();

        Properties properties = new Properties();
        Enumeration<String> parameterNames = context.getInitParameterNames();
        while (parameterNames.hasMoreElements()){
            String property = parameterNames.nextElement();
            properties.setProperty(property, context.getInitParameter(property));
        }
        service = new ShopService(properties);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            requestHandler(request, response);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            requestHandler(request, response);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    private void requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, CloneNotSupportedException {
        String action = request.getParameter("action");
        String destination = "index.jsp";
        if (action != null){
            RequestHandler handler;
            handler = handlerFactory.getController(action, service);
            destination = handler.handleRequest(request, response);
        }
        RequestDispatcher view = request.getRequestDispatcher(destination);
        view.forward(request, response);
    }
}
