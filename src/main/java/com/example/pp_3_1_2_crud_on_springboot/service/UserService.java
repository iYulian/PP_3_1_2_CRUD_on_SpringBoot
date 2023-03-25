package com.example.pp_3_1_2_crud_on_springboot.service;


import com.example.pp_3_1_2_crud_on_springboot.model.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    void removeUserById(long id);

    List<User> getAllUsers();

    public User getUserById(long id);

}
