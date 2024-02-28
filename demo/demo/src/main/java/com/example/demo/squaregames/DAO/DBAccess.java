package com.example.demo.squaregames.DAO;

import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBAccess {

    private static DBAccess instance;
    private Connection connection;

    public static DBAccess getInstance(){
        if (instance == null) instance = new DBAccess();
        return instance;
    }

    private DBAccess(){
        getConnection();
    }

    public Connection getConnection(){
        if (connection == null){
            try {
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:6603/spring",
                        "root",
                        "helloworld");
            } catch(Exception e){
                System.err.println(e.getMessage());
            }
        } return connection;
    }

}
