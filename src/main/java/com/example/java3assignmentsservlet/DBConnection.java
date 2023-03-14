package com.example.java3assignmentsservlet;

import java.sql.*;

public class DBConnection {
    /**
     * Sets up database connection.
     * @return Connection object
     */
    public static Connection initDatabase() throws SQLException {
        return DriverManager.getConnection(DBConfig.DB_URL + DBConfig.DB_BOOKS, DBConfig.DB_USER, DBConfig.DB_PASSWORD);
    }
}