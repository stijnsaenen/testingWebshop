package ui.controller;

import domain.db.ShopService;

public class HandlerFactory {

    public RequestHandler getController(String key, ShopService model){
        return createHandler(key, model);
    }

    private RequestHandler createHandler(String handlerName, ShopService model){
        RequestHandler handler;
        try{
            Class<?> handlerClass = Class.forName("ui.controller.actions." + handlerName);
            Object handlerObject = handlerClass.newInstance();
            handler = (RequestHandler) handlerObject;
            handler.setService(model);
        }catch (ClassNotFoundException e){
            throw new RuntimeException("The requested page does not exist");
        }catch (InstantiationException e){
            throw new RuntimeException(e);
        }catch (IllegalAccessException e){
            throw new RuntimeException("The requested page does not exist");
        }
        return handler;
    }
}
