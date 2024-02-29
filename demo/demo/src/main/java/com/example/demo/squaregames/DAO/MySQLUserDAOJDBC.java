package com.example.demo.squaregames.DAO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MySQLUserDAOJDBC implements UserDAO {

    private static Logger LOGGER = LoggerFactory.getLogger(MySQLUserDAOJDBC.class);

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
        LOGGER.info("ಠ‿↼ : Attempting to retrieve all users");
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
            LOGGER.info("ಠ‿↼ : Successfully retrieved all users");
        } catch (Exception e){
            //System.err.println(e.getMessage());
            LOGGER.error("(ಥ﹏ಥ) : Error retrieving all users", e);
        } return allUsers;
    }

    public User getUserById(int id){
        User user = null;
        Connection connection1 = this.dbAccess.getConnection();
        String sql = "SELECT * FROM User WHERE id = ?";
        try(PreparedStatement preparedStatement = connection1.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            LOGGER.info("ಠ‿↼ : Executing query to find user with ID: {}", id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                user = new User();
                user.setFirstName(resultSet.getString("firstName"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getInt("age"));
                user.setId(resultSet.getInt("id"));
                LOGGER.info("ಠ‿↼ : User found with ID: {}", id);
            } else {
                LOGGER.warn("ರ_ರ : No user found with ID: {}", id);
            }
        } catch (SQLException e){
            LOGGER.error("(ಥ﹏ಥ) : Error occurred while finding user with ID: {}. Error: {}", id, e.getMessage(), e);
        } return user;
    }

    public User addUser(UserCreationParam param){
        LOGGER.info("ಠ‿↼ : Attempting to add new user: {} {} {}", param.firstName(), param.lastName(), param.age());
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
                        LOGGER.info("ಠ‿↼ : User added successfully with ID: {}", newUser.getId());
                    }
                }
            } else {
                LOGGER.warn("ರ_ರ : No user was added, affected rows: {}", affectedRows);
            }
        } catch (SQLException e){
            //System.out.println(e.getMessage());
            LOGGER.error("(ಥ﹏ಥ) : Error adding new user: {} {}", param.firstName(), param.lastName(), e);
        } return newUser;
    }

    public User updateUser(int id, UserCreationParam param) {
        LOGGER.info("ಠ‿↼ : Attempting to update user with ID: {}", id);
        String sql = "UPDATE User SET firstName = ?, lastName = ?, age = ? WHERE id = ?";

        try (Connection connection = this.dbAccess.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, param.firstName());
                preparedStatement.setString(2, param.lastName());
                preparedStatement.setInt(3, param.age());
                preparedStatement.setInt(4, id);

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                User updatedUser = getUserById(id);
                LOGGER.info("ಠ‿↼ : User with ID: {} updated successfully", id);
                return updatedUser;
            } else {
                LOGGER.warn("ರ_ರ : No update performed for user with ID: {}", id);
            }
        } catch (SQLException e) {
            //System.out.println(e.getMessage());
            LOGGER.error("(ಥ﹏ಥ) : Error updating user with ID: {}", id, e);
        }
        return null;
    }

    public User deleteUser(int id) {
        LOGGER.info("ಠ‿↼ : Attempting to delete user with ID: {}", id);
        User userToDelete = getUserById(id);
        if (userToDelete == null) {
            LOGGER.warn("ರ_ರ : Attempted to delete a non-existing user with ID: {}", id);
            return null;
        }

        String sql = "DELETE FROM User WHERE id = ?";

        try (Connection connection = this.dbAccess.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                LOGGER.info("ಠ‿↼ : User with ID: {} deleted successfully", id);
                return userToDelete;
            } else {
                LOGGER.warn("ರ_ರ : No user was deleted for ID: {}", id);
            }
        } catch (SQLException e) {
            //System.out.println(e.getMessage());
            LOGGER.error("(ಥ﹏ಥ) : Error deleting user with ID: {}", id, e);
        } return null;
    }

}