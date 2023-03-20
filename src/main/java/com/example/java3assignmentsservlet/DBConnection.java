package com.example.java3assignmentsservlet;

import java.sql.*;

public class DBConnection {
    /**
     * Registers driver then sets up database connection
     * @return Connection object
     */
    public static Connection initDatabase() throws SQLException {

        try {
            Class.forName(DBConfig.JDBC_DRIVER).newInstance();
            System.out.println("Option 1: Find the class worked!");
        } catch (ClassNotFoundException ex) {
            System.err.println("Error: unable to load driver class!");
        } catch(IllegalAccessException ex) {
            System.err.println("Error: access problem while loading!");
        } catch(InstantiationException ex){
            System.err.println("Error: unable to instantiate driver!");
        }

        Connection connection = null;

        try{
            connection = DriverManager.getConnection(
                    DBConfig.DB_URL + DBConfig.DB_BOOKS,
                    DBConfig.DB_USER,
                    DBConfig.DB_PASSWORD);
        } catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return connection;
    }
}