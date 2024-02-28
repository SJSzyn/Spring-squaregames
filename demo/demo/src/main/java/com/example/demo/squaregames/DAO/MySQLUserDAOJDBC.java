package com.example.demo.squaregames.DAO;

import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MySQLUserDAOJDBC implements UserDAO {

    private static MySQLUserDAOJDBC instance;
    private Connection connection;

    public static MySQLUserDAOJDBC getInstance(){
        if (instance == null) instance = new MySQLUserDAOJDBC();
        return instance;
    }

    private final DBAccess dbAccess = DBAccess.getInstance();

    private MySQLUserDAOJDBC(){
        connection = dbAccess.getConnection();
    }
    // TODO getAllUsers, getUserByID, addUser, updateUser, deleteUser

    public List<User> getAllUsers(){
        List<User> allUsers = new ArrayList<>();
        Connection connection1 = this.dbAccess.getConnection();
        try {
            Statement statement = connection1.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM User");
            while (resultSet.next()){
                User user = new User();
                user.setFirstName(resultSet.getString("firstName"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getInt("age"));
                user.setId(resultSet.getInt("id"));
                allUsers.add(user);
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
        } return allUsers;
    }

    public User getUserById(int id){
        User user = null;
        Connection connection1 = this.dbAccess.getConnection();
        String sql = "SELECT * FROM User WHERE id = ?";
        try(PreparedStatement preparedStatement = connection1.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                user = new User();
                user.setFirstName(resultSet.getString("firstName"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getInt("age"));
                user.setId(resultSet.getInt("id"));
            }
        } catch (SQLException e){
            System.err.println(e.getMessage());
        } return user;
    }

    public User addUser(UserCreationParam param){
        String sql = "INSERT INTO User (firstName, lastName, age) VALUES (?, ?, ?)";
        User newUser = null;

        try(Connection connection1 = this.dbAccess.getConnection();
        PreparedStatement preparedStatement = connection1.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, param.firstName());
            preparedStatement.setString(2, param.lastName());
            preparedStatement.setInt(3, param.age());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0){
                try(ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()){
                        newUser = new User();
                        newUser.setFirstName(param.firstName());
                        newUser.setLastName(param.lastName());
                        newUser.setAge(param.age());
                        newUser.setId(generatedKeys.getInt(1));
                    }
                }
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        } return newUser;
    }

    public User updateUser(int id, UserCreationParam param) {
        String sql = "UPDATE User SET firstName = ?, lastName = ?, age = ? WHERE id = ?";

        try (Connection connection = this.dbAccess.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, param.firstName());
                preparedStatement.setString(2, param.lastName());
                preparedStatement.setInt(3, param.age());
                preparedStatement.setInt(4, id);

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                return getUserById(id);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public User deleteUser(int id) {
        User userToDelete = getUserById(id);
        if (userToDelete == null) {
            return null;
        }

        String sql = "DELETE FROM User WHERE id = ?";

        try (Connection connection = this.dbAccess.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                return userToDelete;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } return null;
    }

}