package domain.db;

import domain.model.Order;

import java.util.List;

public interface OrderDB {
    Order get(int id);

    List<Order> getAll();

    void add(Order order);

    void delete(int id);

    int getNumberOfPersons();

    int getTotPrice();
}
