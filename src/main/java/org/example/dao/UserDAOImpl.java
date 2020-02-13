package org.example.dao;

import org.example.datasource.ConnectionUtil;
import org.example.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;

import java.util.List;


public class UserDAOImpl implements  UserDAO{
    Transaction transaction=null;

/*
This method is used for getting all users from userinfo table based on
 */
    @Override
    public List<User> getAllUsers() {
        //Create session
      Session currentsession=null;
       try {
           currentsession = ConnectionUtil.getSessionFactory().openSession();

           // create Criteria
           CriteriaQuery<User> criteriaQuery = currentsession.getCriteriaBuilder().createQuery(User.class).groupBy();
           System.out.println(criteriaQuery.toString());
           criteriaQuery.from(User.class);
           List<User> alluser = currentsession.createQuery(criteriaQuery).getResultList();
           for (User getallusers : alluser) {
               System.out.println("all user is " + getallusers);
           }
           return alluser;
       }catch (Exception exec){
           exec.printStackTrace();
       }
    finally {
           if(currentsession!=null){
               currentsession.close();
           }
       }
       return null;
    }
/*
This method is used for find username by username
 */
    @Override
    public String getUserByname() {
     Session currentsession=ConnectionUtil.getSessionFactory().openSession();
     Criteria criteriauserbyname=currentsession.createCriteria(User.class);
        List<User> results = criteriauserbyname.list();
        return "";
    }

    @Override
    public User getId() {
return null;
    }

    @Override
    public void save(User user) {
        // get the transaction
        try(Session session=ConnectionUtil.getSessionFactory().getCurrentSession()){
            transaction=session.beginTransaction();
            session.save(user);
            transaction.commit();

        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();

        }


    }
}
