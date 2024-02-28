package com.example.demo.squaregames.DAO;

import java.util.List;
import java.util.UUID;

public interface UserDAO{
    public List<User> getAllUsers();
    public User getUserById(int id);
    public User addUser(UserCreationParam param);
    public User updateUser(int id, UserCreationParam param);
    public User deleteUser(int id);

}