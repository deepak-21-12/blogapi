package org.example.dao;

import org.example.model.User;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public interface UserDAO {
    // get all users
    // get user by name
    // get user by id
     List<User> getAllUsers(Session crsession);
     void getUserByname();
     void getId();
    void save(User user);

}
