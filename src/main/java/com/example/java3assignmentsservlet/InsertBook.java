package com.example.java3assignmentsservlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 *
 * @author blake
 */

public class InsertBook {

    public static void insertBook(Book book) throws SQLException {
        Connection connection = DBConnection.initDatabase();

        String sql = "INSERT INTO titles (isbn, title, editionNumber, copyright) VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, book.getIsbn());
        preparedStatement.setString(2, book.getTitle());
        preparedStatement.setInt(3, book.getEditionNumber());
        preparedStatement.setString(4, book.getCopyright());

        preparedStatement.executeQuery();

        preparedStatement.close();
    }
}