package domain.db;/*
package domain.db;

import domain.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CartDbPostgres implements ProductDb {
    private Properties properties;
    private String url; // = "jdbc:postgresql://databanken.ucll.be:61819/2TX38";

    public CartDbPostgres(Properties properties) {
        this.properties = properties;
        this.url = properties.getProperty("url");
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new DbException(e.getMessage(), e);
        }
    }

    @Override
    public Product get(int id) {
        System.out.println(id);
        String sql = "SELECT * from r0705829_schema.cart where productId=" + id;
        try(Connection connection = DriverManager.getConnection(url, properties);
            Statement statement = connection.createStatement()){
            ResultSet result = statement.executeQuery(sql);
            Product product = new Product();
            while (result.next()){
                product.setPrice(result.getDouble("price"));
                product.setProductId(result.getInt("productid"));
                product.setName(result.getString("name"));
                product.setDescription(result.getString("description"));
            }
            return product;
        }catch (SQLException e) {
            throw new DbException(e);
        }
    }

    @Override
    public List<Product> getAll() {
        List<Product> producten = new ArrayList<Product>();
        try(Connection connection = DriverManager.getConnection(url,properties);
            Statement statement = connection.createStatement()){
            ResultSet result = statement.executeQuery("SELECT * FROM r0705829_schema.cart");
            while (result.next()){
                int productid = result.getInt("productid");
                String name = result.getString("name");
                String descripton = result.getString("description");
                double price = result.getDouble("price");
                Product product = new Product(productid, name, descripton, price);
                producten.add(product);
            }
        }catch (SQLException e){
            throw new DbException(e);
        }
        return producten;
    }

    @Override
    public void add(Product product){
        if(product == null){
            throw new DbException("Nothing to add");
        }
        String sql = "INSERT INTO r0705829_schema.cart VALUES(?,?,?,?);";
        //String sql = "INSERT INTO r0705829.cart VALUES(" + product.getProductId() + ",'" + product.getName() + "','" + product.getDescription() +"'," + product.getPrice() +")";
        try(Connection connection = DriverManager.getConnection(url, properties);
            //Statement statement = connection.createStatement()){
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, product.getProductId());
            statement.setString(2, product.getName());
            statement.setString(3, product.getDescription());
            statement.setDouble(4, product.getPrice());
            statement.execute();
        }catch (SQLException e){
            throw new DbException(e);
        }
    }

    @Override
    public void update(Product product) {
        if (product == null){
            throw new DbException("No product to update");
        }
        int productid = product.getProductId();
        //String sql = "UPDATE r0712411.products SET name= '" + product.getName() + ", description = \"" +product.getDescription() +"\", price= " + product.getPrice() + " WHERE productid=" + productid;
        String sql = "UPDATE r0705829_schema.cart SET name= ?, description = ?, price= ? WHERE productid=?;";
        try(Connection connection = DriverManager.getConnection(url, properties);
            //Statement statement = connection.createStatement()) {
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, product.getName());
            statement.setString(2, product.getDescription());
            statement.setDouble(3, product.getPrice());
            statement.setInt(4, product.getProductId());
            statement.execute(sql);
        }catch (SQLException e){
            throw new DbException(e);
        }
    }

    @Override
    public void delete(String id) {
        try(Connection connection = DriverManager.getConnection(url, properties);
            Statement statement = connection.createStatement()) {
            statement.execute("DELETE FROM r0705829_schema.cart where productid='" + id+"'");
        }catch (SQLException e){
            throw new DbException(e);
        }
    }

    @Override
    public int getNumbeOfProducts() {
        return getAll().size();
    }

    @Override
    public void empty() {
        try(Connection connection = DriverManager.getConnection(url, properties);
            Statement statement = connection.createStatement()) {
            statement.execute("DELETE from r0705829_schema.cart");
        }catch (SQLException e){
            throw new DbException(e);
        }
    }
}
*/
