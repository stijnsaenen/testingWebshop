package ui.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import domain.db.DbException;
import domain.model.*;

import javax.swing.*;

public class PersonOverview {
    public static void main(String[] args) throws SQLException {
        Properties properties = new Properties();
        String url = "jdbc:postgresql://databanken.ucll.be:61819/2TX38"; //
        properties.setProperty("user", "local_r0705829"); //
        properties.setProperty("password", "jjMReyv,Tqn0\"h&"); //
        properties.setProperty("ssl", "true");
        properties.setProperty("sslfactory", "org.postgresql.ssl.NonValidatingFactory");
        properties.setProperty("sslmode","prefer");

        String id = JOptionPane.showInputDialog(null, "what is the id of the person?");
        String mail = JOptionPane.showInputDialog(null, "what is the email of the person?");
        String passw = JOptionPane.showInputDialog(null, "what is the password  of the person?");
        String first = JOptionPane.showInputDialog(null, "what is the first name of the person?");
        String last = JOptionPane.showInputDialog(null, "what is the last name of the person?");

        Connection connection = DriverManager.getConnection(url,properties);
        Statement statement = connection.createStatement();
        statement.execute("INSERT INTO r0705829_schema.person (userid, email, password, firstname, lastname) VALUES ('"+id+"','"+mail+"','"+passw+"','"+first+"','"+last+"');"); //
        ResultSet result = statement.executeQuery( "SELECT * FROM r0705829_schema.person" ); //current schema slides labo 2
        while(result.next()){
            String userid = result.getString("userid");
            String email = result.getString("email");
            String password = result.getString("password");
            String firstName = result.getString("firstname");
            String lastName = result.getString("lastname");
            try {	// validation of data stored in database
                Person person= new Person();
                person.setUserid(userid);
                person.setEmail(email);
                person.setPassword(password);
                person.setFirstName(firstName);
                person.setLastName(lastName);
                System.out.println(person.toString());
            }
            catch (DbException e) {
                System.out.println(e.getMessage());
            }
        }
        statement.close();
        connection.close();

    }

}