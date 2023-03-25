package com.example.pp_3_1_2_crud_on_springboot.service;

import com.example.pp_3_1_2_crud_on_springboot.dao.UserDaoHibernate;
import com.example.pp_3_1_2_crud_on_springboot.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceIml implements UserService{

    private final UserDaoHibernate userDao;

    public UserServiceIml(UserDaoHibernate userDao) {
        this.userDao = userDao;
    }


    @Override
    @Transactional
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    @Transactional
    public void removeUserById(long id) {
        userDao.removeUserById(id);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }
}
