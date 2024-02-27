//package com.example.demo.squaregames.DAO;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//
//public class MySQLUserDAOJDBC implements UserDAO {
//
//    private static MySQLUserDAOJDBC instance;
//    private Connection connection;
//
//    public static MySQLUserDAOJDBC getInstance(){
//        if (instance == null) instance = new MySQLUserDAOJDBC();
//        return instance;
//    }
//
//    private DBAccess dbAccess = DBAccess.getInstance();
//
//    private MySQLUserDAOJDBC(){
//        connection = dbAccess.getConnection();
//    }
//    // TODO getAllUsers, getUserByID, addUser, updateUser, deleteUser
//
//    @Override
//    public List<User> getAllUsers(){
//        Connection connection1 = dbAccess.getConnection();
//        List myList = new ArrayList();
//
//        try {
//            Statement statement = connection1.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM User");
//
//            while (resultSet.next()){
//                User user = new User();
//                user
//
//
//
//            }
//        } catch (Exception e){
//            System.out.println(e);
//        }
//        return myList;
//
//    }
//
//    public List<User> getAllUsers();
//    public User getUserById(UUID id);
//    public User addUser(UserCreationParam param);
//    public User updateUser(UUID id, UserCreationParam param);
//    public User deleteUser(UUID id);
//
//
//}