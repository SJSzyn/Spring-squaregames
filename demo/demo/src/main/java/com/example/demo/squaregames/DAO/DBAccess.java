package com.example.demo.squaregames.DAO;

import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBAccess {

    private Connection connection;
    private final String DB_URL = "jdbc:mysql://localhost:6603/spring";
    private static String user = "root";
    private static String password = "helloworld";

    private static DBAccess instance;

    public static DBAccess getInstance(){
        if (instance == null) {
            instance = new DBAccess();
        }
        return instance;
    }

    private DBAccess(){
        try {
            connection = DriverManager.getConnection(DB_URL, user, password);
            if (connection != null) {
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        return this.connection;
    }
}
