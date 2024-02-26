package com.example.demo.squaregames.DAO;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class MySQLUserDAO implements UserDAO {

    private List<User> users = new ArrayList<User>();

    @Override
    public List<User> getAllUsers(){
        return this.users;
    }

    @Override
    public User getUserById(UUID id){
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public User addUser(UserCreationParam param){
        User user = new User(param.firstName(), param.lastName(), param.age());
        users.add(user);
        return user;
    }

    @Override
    public User updateUser(UUID id, UserCreationParam param){
        User userToUpdate = this.users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (userToUpdate != null) {
            userToUpdate.setFirstName(param.firstName());
            userToUpdate.setLastName(param.lastName());
            userToUpdate.setAge(param.age());
        }
        return userToUpdate;
    }

    @Override
    public User deleteUser(UUID id){
        User userToRemove = this.users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (userToRemove != null){
            this.users.remove(userToRemove);
        }
        return userToRemove;
    }

}