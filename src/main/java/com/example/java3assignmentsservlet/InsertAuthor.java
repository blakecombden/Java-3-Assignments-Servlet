package com.example.java3assignmentsservlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Connects to database and uses insert prepared statement to insert a new Author
 * @author blake
 */

public class InsertAuthor {

    public static void insertAuthor(Author author) throws SQLException {
        Connection connection = DBConnection.initDatabase();

        String sql = "INSERT INTO authors (firstName, lastName) VALUES (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, author.getFirstName());
        preparedStatement.setString(2, author.getLastName());

        preparedStatement.executeQuery();

        preparedStatement.close();
    }
}