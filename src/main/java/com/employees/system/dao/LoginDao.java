package com.employees.system.dao;

import com.employees.system.model.User;
import com.employees.system.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class LoginDao {

    public User getUser(String username, String password) {
        Transaction transaction = null;
        User user = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Construct the query to fetch the user based on username and password
            Query<User> query = session.createQuery("FROM User WHERE email = :username AND password = :password", User.class);
            query.setParameter("username", username);
            query.setParameter("password", password);

            // Get the user (if exists) based on the provided credentials
            user = query.uniqueResult();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return user;
    }

}
