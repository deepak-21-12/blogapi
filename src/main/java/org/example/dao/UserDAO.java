package org.example.dao;

import org.example.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
/*
This interface is used to create list of list of interfaces
of users and it will return a list of interfaces of User class

 */
public interface UserDAO {
    // get all users
    // get user by name
    // get user by id
     List<User> getAllUsers();
     String getUserByname();
     User getId();
    void save(User user);

}
