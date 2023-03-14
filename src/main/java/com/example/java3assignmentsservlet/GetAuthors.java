package com.example.java3assignmentsservlet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class GetAuthors {
    /**
     * Retrieve all authors from database into LinkedList.
     * @return List of Author objects
     */
    public static List<Author> getAllAuthors() throws SQLException {
        LinkedList authorList = new LinkedList();

        Connection connection = DBConnection.initDatabase();
        Statement statement = connection.createStatement();
        String sqlQuery = "SELECT * from " + DBConfig.DB_BOOKS_AUTHORS_TABLE_NAME;

        ResultSet resultSet = statement.executeQuery(sqlQuery);
        while(resultSet.next()) {
            authorList.add(
                    new Author(
                            resultSet.getInt(DBConfig.DB_BOOKS_AUTHORS_AUTHOR_ID),
                            resultSet.getString(DBConfig.DB_BOOKS_AUTHORS_FIRST_NAME),
                            resultSet.getString(DBConfig.DB_BOOKS_AUTHORS_LAST_NAME)
                    )
            );
        }
        return authorList;
    }
}