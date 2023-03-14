package com.example.java3assignmentsservlet;

import java.sql.*;

public class DBConnection {
    /**
     * Sets up database connection.
     * @return Connection object
     */
    public static Connection initDatabase() throws SQLException {
        Connection connection = DBConfig.getConnection();
        return connection;
    }
}