package domain.db;

import domain.model.Person;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface PersonDb {
    Person get(String personId);

    List<Person> getAll();

    void add(Person person) throws UnsupportedEncodingException, NoSuchAlgorithmException;

    void update(Person person) throws UnsupportedEncodingException, NoSuchAlgorithmException;

    boolean check(String id, String password) throws UnsupportedEncodingException, NoSuchAlgorithmException;

    void delete(String personId);

    int getNumberOfPersons();
}
