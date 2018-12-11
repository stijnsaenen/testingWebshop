package domain.db;

import domain.model.DomainException;
import domain.model.Order;
import domain.model.Person;
import domain.model.Product;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class OrderDBInMemory implements OrderDB {
    private ArrayList<Order> orders = new ArrayList<>();

    public OrderDBInMemory() {
    }
    @Override
    public Order get(int id){
        if (id <= 0) {
            throw new DomainException("No id given");
        }
        Order res = null;
        for(Order x : orders) {
            if (x.getOrderId() == id) {
                res = x;
            }
        }
        return res;
    }

    @Override
    public List<Order> getAll(){
        return orders;
    }

    @Override
    public void add(Order order){
        if(order == null){
            throw new DbException("No order given");
        }
        if (orders.contains(order)) {
            throw new DbException("Order already exists");
        }
        orders.add(order);
    }

    @Override
    public void delete(int id){
        if(id <= 0){
            throw new DbException("No id given");
        }
        Iterator<Order> iter = this.orders.iterator();
        while(iter.hasNext()){
            Order order = iter.next();
            if(order.getOrderId() == id){
                iter.remove();
            }
        }
    }

    @Override
    public int getNumberOfPersons() {
        return orders.size();
    }

    @Override
    public int getTotPrice() {
        int res = 0;
        for (Order x : orders){
            res+=x.getTotalOrderPrice();
        }
        return res;
    }

}
