package ui.controller;

import domain.db.ShopService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class RequestHandler {

    private ShopService service;
    public abstract String handleRequest (HttpServletRequest request, HttpServletResponse response) throws CloneNotSupportedException;
    public void setService(ShopService service){
        this.service = service;
    }

    public ShopService getService(){
        return service;
    }

}
