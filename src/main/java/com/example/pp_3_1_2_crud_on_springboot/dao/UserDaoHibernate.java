package com.example.pp_3_1_2_crud_on_springboot.dao;



import com.example.pp_3_1_2_crud_on_springboot.model.User;

import java.util.List;

public interface UserDaoHibernate {

    void saveUser(User user);

    void removeUserById(long id);

    List<User> getAllUsers();

    User getUserById(long id);
}
