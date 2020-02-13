package org.example.dao;

import org.example.model.Blog;
import org.example.model.User;

import java.util.List;
/*
This interface is used to create a list of interfaces of blog.
This will return a list of blog
 */
public interface BlogDAO {
    // get all users
    // get user by name
    // get user by id
    List<Blog> getAllBlogsByName();

    Blog getId();
    void save(Blog blog);

}

