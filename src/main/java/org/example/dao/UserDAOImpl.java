package org.example.dao;

import org.example.datasource.ConnectionUtil;
import org.example.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class UserDAOImpl implements  UserDAO{
    Transaction transaction=null;
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
