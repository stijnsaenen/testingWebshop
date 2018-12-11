package domain.db;

import domain.model.Order;

public class test {
    public static void main(String[] args) {
        Order x = new Order("a","a","1",false);
        System.out.println(x.orderId);
    }
}
