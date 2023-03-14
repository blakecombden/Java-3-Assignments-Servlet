package com.example.java3assignmentsservlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 *
 * @author blake
 */

public class InsertAuthor {

    public static void insertAuthor(Author author) throws SQLException {
        Connection connection = DBConnection.initDatabase();

        String sqlQuery = "INSERT INTO " + DBConfig.DB_BOOKS_AUTHORS_TABLE_NAME +
                " VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

        preparedStatement.setInt(1, author.getAuthorID());
        preparedStatement.setString(2, author.getFirstName());
        preparedStatement.setString(3, author.getLastName());
        preparedStatement.setString(4, author.getBook().getTitle());

        preparedStatement.executeQuery();
    }
}