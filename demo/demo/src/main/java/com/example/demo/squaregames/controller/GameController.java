package com.example.demo.squaregames.controller;

import com.example.demo.squaregames.DAO.User;
import com.example.demo.squaregames.DAO.UserCreationParam;
import com.example.demo.squaregames.DAO.UserDAO;
import com.example.demo.squaregames.DAO.UserDTO;
import com.example.demo.squaregames.service.GameService;
import com.example.demo.squaregames.controller.dto.GameDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class GameController {

    // TODO Make POST GET PUT DELETE
    // Game creation
    @Autowired
    private GameService gameService;

    @PostMapping("/games")
    public GameDTO createGame(@RequestBody GameCreationParams params) {
        return gameService.createGame(params);
    }

    @GetMapping("/games")
    public List<String> getAllGames() {
        return gameService.getAllGames();
    }

    @GetMapping("/games/{gameId}")
    public GameDTO getGame(@PathVariable String gameId) {
        return gameService.getGame(gameId);
    }

    // TODO Make POST GET PUT DELETE
    // DAO Creation
    @Autowired
    private UserDAO userDAO;

    private UserDTO userToDTO(User user){
        return new UserDTO(user.getId(), user.getFirstName(), user.getLastName(), user.getAge());

    }

    private Collection<UserDTO> toDTOList(Collection<User> users){
        return users.stream()
                .map(this::userToDTO)
                .toList();
    }

    @PostMapping("/users")
    public UserDTO add(@RequestBody UserCreationParam param){
        User addedUser = userDAO.addUser(param);
        return userToDTO(addedUser);
    }

    @GetMapping("/users")
    public Collection<UserDTO> getAll(){
        return toDTOList(userDAO.getAllUsers());
    }

    @GetMapping("/users/{id}")
    public UserDTO get(@PathVariable UUID id){
        User user = userDAO.getUserById(id);
        return userToDTO(user);
    }

    @PutMapping("/users/{id}")
    public UserDTO update(@RequestBody UserCreationParam param, @PathVariable UUID id){
        User updatedUser = userDAO.updateUser(id, param);
        return userToDTO(updatedUser);
    }

    @DeleteMapping("/users/{id}")
    public UserDTO delete(@PathVariable UUID id){
        User deleteUser = userDAO.deleteUser(id);
        return userToDTO(deleteUser);
    }

}
