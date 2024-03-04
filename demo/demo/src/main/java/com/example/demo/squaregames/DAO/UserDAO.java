package com.example.demo.squaregames.dao;

import com.example.demo.squaregames.dto.UserCreationParam;
import com.example.demo.squaregames.entity.User;

import java.util.List;

public interface UserDAO{
    public List<User> getAllUsers();
    public User getUserById(int id);
    public User addUser(UserCreationParam param);
    public User updateUser(int id, UserCreationParam param);
    public User deleteUser(int id);

}