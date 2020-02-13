package org.example.dao;

import org.example.datasource.ConnectionUtil;
import org.example.model.Blog;
import org.example.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.sql.SQLOutput;
import java.util.List;

public class BlogDAOImpl implements BlogDAO {


   @Override
    public List<Blog> getAllBlogsByName() {
       Session blogsession=null;
       try {
          blogsession = ConnectionUtil.getSessionFactory().openSession();
          CriteriaQuery<Blog> criteriaQuery = blogsession.getCriteriaBuilder().createQuery(Blog.class);
          System.out.println("Get blogger by name successfully");
          criteriaQuery.from(Blog.class);
          List<Blog> allblog = blogsession.createQuery(criteriaQuery).getResultList();
          for (Blog getallblogs : allblog) {
              System.out.println("all user is " + getallblogs);
          }
          return getAllBlogsByName();
      }catch (Exception exec){
          exec.printStackTrace();
      }
      finally {
          if(blogsession!=null){
              blogsession.close();
          }
      }

return null;
    }



    @Override
    public Blog getId() {
        return getId();
    }

    @Override
    public void save(Blog blog) {
        Transaction blogtransaction=null;
        try (Session blogsession=ConnectionUtil.getSessionFactory().getCurrentSession()){
            System.out.println("Connection is created successfully for blog");
             blogtransaction=blogsession.beginTransaction();
            blogsession.save(blog);
            blogtransaction.commit();
        }catch (Exception exec){
            blogtransaction.rollback();
            System.out.println("Exception in Blog transaction");
        }
    }
}
