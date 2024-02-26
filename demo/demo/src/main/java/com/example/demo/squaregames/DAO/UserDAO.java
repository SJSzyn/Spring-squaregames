package com.example.demo.squaregames.DAO;

import java.util.List;
import java.util.UUID;

public interface UserDAO{
    public List<User> getAllUsers();
    public User getUserById(UUID id);
    public User addUser(UserCreationParam param);
    public User updateUser(UUID id, UserCreationParam param);
    public User deleteUser(UUID id);

}