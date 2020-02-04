package org.example;

import org.example.dao.UserDAO;
import org.example.dao.UserDAOImpl;
import org.example.model.Address;
import org.example.model.User;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "Hello World!" );
        User user=new User();
        Address addressobj=new Address();
        addressobj.setState("Bihar");
        user.setId("deepa");
        user.setUsername("Deepak");
        user.setPassword("Deepak");
        user.setConfirmPassword("abc");
        user.setEmailId("abc@gmail.com");
        user.setAddress(addressobj);

        UserDAO userDAO=new UserDAOImpl();
        userDAO.save(user);
    }
}
