package org.example.datasource;


import org.example.model.Blog;
import org.example.model.User;
import org.hibernate.MappingException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

/**
 * class contains the datasource configuration
 */
public class ConnectionUtil extends Configuration {



    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        if(sessionFactory==null) {


            Configuration configuration = new Configuration();

            /**
             * loading all the properties
             *
             */
            Properties settings = new Properties();
            settings.put(Environment.DRIVER, "oracle.jdbc.OracleDriver");
            settings.put(Environment.URL, "jdbc:oracle:thin:@localhost:1521/xe");
            settings.put(Environment.USER, "CXPSADM_deepakkumar_47z3");
            settings.put(Environment.PASS, "c_xps123");
            settings.put(Environment.DIALECT, "org.hibernate.dialect.Oracle8iDialect");
            settings.put(Environment.SHOW_SQL, "true");

            settings.put(Environment.HBM2DDL_AUTO, "update");
           settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

           configuration.setProperties(settings);
            try {
               configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Blog.class);
            }catch (MappingException exec){
                exec.printStackTrace();
                System.out.println("Exception in add Entity class Configuration");
            }

            System.out.println("begin database schema creation =========================");

       //     configuration.addAnnotatedClass(BlogModel.class);
            // Since version 4.x, service registry is being used
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
                    applySettings(configuration.getProperties()).build();
            // Create session factory instance
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        }else {
            System.out.println("sessionFactory is not null");
        }
        return sessionFactory;
    }
}
