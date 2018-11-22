package domain.db;

import domain.model.Person;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PersonDBPostgres implements PersonDb {
    private Properties properties;
    private String url;

    public PersonDBPostgres(Properties properties){
        this.properties = properties;
        this.url = this.properties.getProperty("url");
//        properties.setProperty("user", "local_r0705829");
//        properties.setProperty("password", "KSMUBùgwalàUF=ç");
//        properties.setProperty("ssl", "true");
//        properties.setProperty("sslfactory", "org.postgresql.ssl.NonValidatingFactory");
//        properties.setProperty("sslmode","prefer");
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new DbException(e.getMessage(), e);
        }
    }

    public Person get(String id) {
        try(Connection connection = DriverManager.getConnection(url,properties);
            Statement statement = connection.createStatement()){
            ResultSet result = statement.executeQuery("SELECT * FROM r0705829_schema.person");
            while (result.next()){
                if(result.getString("userid").equals(id)){
                    String userid = result.getString("userid");
                    String email = result.getString("email");
                    String pass = result.getString("password");
                    String firstName = result.getString("firstname");
                    String lastName = result.getString("lastname");
                    Person person = new Person(userid, email, pass, firstName, lastName);
                    return person;
                }
            }
        }catch (SQLException e){
            throw new DbException(e);
        }
        return null;
    }


    public List<Person> getAll() {
        List<Person> persons = new ArrayList<Person>();
        try(Connection connection = DriverManager.getConnection(url,properties);
            Statement statement = connection.createStatement()){
            ResultSet result = statement.executeQuery("SELECT * FROM r0705829_schema.person");
            while (result.next()){
                String userid = result.getString("userid");
                String email = result.getString("email");
                String pass = result.getString("password");
                String firstName = result.getString("firstname");
                String lastName = result.getString("lastname");
                Person person = new Person(userid, email, pass, firstName, lastName);
                persons.add(person);
            }
        }catch (SQLException e){
            throw new DbException(e);
        }
        return persons;
    }

    private String hash(String plain) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest crypt = MessageDigest.getInstance("SHA-512");
        byte[] passwordbytes = plain.getBytes("UTF-8");
        crypt.update(passwordbytes);
        byte[] digest = crypt.digest();
        return new BigInteger(1, digest).toString(16);
    }

    public void add(Person person) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        if(person == null){
            throw new DbException("Nothing to add");
        }
        //String sql = "INSERT INTO r0705829_schema.persons VALUES('" + person.getUserid() + "','" + person.getEmail() + "','" + person.getPassword() +"','" + person.getFirstName() +"','" + person.getLastName() + "')";
        String sql = "INSERT INTO r0705829_schema.person VALUES(?,?,?,?,?)";
        try(Connection connection = DriverManager.getConnection(url, properties)){
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, person.getUserid());
            statement.setString(2, person.getEmail());
            statement.setString(3, person.getPassword());
            statement.setString(4, person.getFirstName());
            statement.setString(5, person.getLastName());
            //Statement statement = connection.createStatement()){
            statement.execute();
        }catch (SQLException e){
            throw new DbException(e);
        }
    }

    @Override
    public void update(Person person) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        if(person == null) {
            throw new DbException("Nothing to change");
        }
        String id = person.getUserid();
        String sql = "UPDATE r0705829_schema.person SET userid=?, email=?, pass=?, firstname=?, lastname=?";
        try(Connection connection = DriverManager.getConnection(url, properties);
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, id);
            statement.setString(2,person.getEmail());
            statement.setString(3, hash(person.getPassword()));
            statement.setString(4, person.getFirstName());
            statement.setString(5, person.getLastName());
        }catch (SQLException e){
            throw new DbException(e);
        }

    }

    public boolean check(String id, String pass) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        Person person = get(id);
        String hashed = hash(pass);
        if(person.getPassword().equals(hashed)){
            return true;
        }else{
            return false;
        }
    }

    public void delete(String id) {
        try(Connection connection = DriverManager.getConnection(url,properties);
            Statement statement = connection.createStatement()){
            statement.execute("DELETE FROM r0705829_schema.person where userid='" + id+"'");
        }
        catch(SQLException e){
            throw new DbException(e);
        }
    }

    @Override
    public int getNumberOfPersons() {
        return 0;
    }
}
