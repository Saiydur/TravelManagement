package com.travelmanagement.dao.user;

import com.travelmanagement.model.user.UsersModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsersDaoImpl implements UsersDao{

    private final SessionFactory sessionFactory;

    public UsersDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(UsersModel user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Override
    public UsersModel getUser(String username) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from UsersModel where username = :username", UsersModel.class)
                .setParameter("username", username)
                .getSingleResult();
    }

    @Override
    public List<UsersModel> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        List<UsersModel> users=session.createQuery("from UsersModel", UsersModel.class).getResultList();
        return users==null?new ArrayList<UsersModel>():users;
    }

    @Override
    public void updateUser(UsersModel user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
    }

    @Override
    public void deleteUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        UsersModel user = session.get(UsersModel.class, id);
        session.delete(user);
    }

    @Override
    public UsersModel getUserById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(UsersModel.class, id);
    }
}
