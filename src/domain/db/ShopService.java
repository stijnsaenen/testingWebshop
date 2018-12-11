package domain.db;

import domain.model.Order;
import domain.model.Person;
import domain.model.Product;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Properties;

public class ShopService {
    private Properties properties;
    PersonDb personDb;
    ProductDb productDb;
    OrderDB orderDB;

    public ShopService(Properties properties){
        this.properties = properties;
        personDb = new PersonDBPostgres(properties);
        productDb = new ProductDBPostgres(properties);
        orderDB = new OrderDBInMemory();
    }


    public List<Person> getPersons(){
        return personDb.getAll();
    }

    public Person getPerson(String id){
        return personDb.get(id);
    }

    public void deletePerson(String id){
        personDb.delete(id);
    }

    public int getNumberOfPersons(){
        return personDb.getNumberOfPersons();
    }

    public Product getProduct(int id){
        return productDb.get(id);
    }

    public List<Product>getAll(){
        return productDb.getAll();
    }

    public void updateProduct(Product product){
        productDb.update(product);
    }

    public void addProduct(Product product){
        productDb.add(product);
    }

    public void deleteProduct(String id) {
        productDb.delete(id);
    }

    public int getNumberOfProducts(){
        return productDb.getNumbeOfProducts();
    }

    public void addPerson(Person person) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        personDb.add(person);
    }

    public void updatePerson(Person person) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        personDb.update(person);
    }

    public boolean check(String id, String password) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        return personDb.check(id, password);
    }


    public Order getOrder(int id){ return orderDB.get(id); }

    public List<Order> getAllOrders(){ return orderDB.getAll(); }

    public void addOrder(Order order){ orderDB.add(order); }

    public void deleteOrder(int id){ orderDB.delete(id); }

    public int getNumberOfOrders(){ return orderDB.getNumberOfPersons(); }

    public int getTotalOrderPrice(){ return orderDB.getTotPrice(); }



}
