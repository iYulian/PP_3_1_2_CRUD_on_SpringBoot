package com.example.pp_3_1_2_crud_on_springboot.dao;

import com.example.pp_3_1_2_crud_on_springboot.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDaoHibernateIml implements UserDaoHibernate {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveUser(User user) {
        if (user.getId() == 0) {
            entityManager.persist(user);
        } else {
            entityManager.merge(user);
        }
    }

    @Override
    public void removeUserById(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);

    }

    @Override
    public List<User> getAllUsers() {

        List<User> userList = entityManager.createQuery("from User", User.class).getResultList();
        return userList;

    }

    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }
}
