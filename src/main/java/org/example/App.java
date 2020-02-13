package org.example;

import org.example.dao.BlogDAO;
import org.example.dao.BlogDAOImpl;
import org.example.dao.UserDAO;
import org.example.dao.UserDAOImpl;
import org.example.model.Address;
import org.example.model.Blog;
import org.example.model.User;
import org.hibernate.Session;

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
       /* Address addressobj=new Address();
        addressobj.setState("Bihar");
        user.setId("Aryaman1");
        user.setUsername("admin");
        user.setPassword("Admin123");
        user.setConfirmPassword("abc");
        user.setEmailId("abc@gmail.com");
        user.setAddress(addressobj);

       UserDAO userDAO=new UserDAOImpl();
*/
        Blog blogobj=new Blog();
        blogobj.setBlogId(111);
        blogobj.setBlogId(123);
        blogobj.setBlogId(123);
        BlogDAO blogDAO=new BlogDAOImpl();
        blogDAO.save(blogobj);
        blogDAO.getAllBlogsByName();
            //  userDAO.save(user);

      //  userDAO.getAllUsers();
      //  userDAO.getUserByname();
    }
}
