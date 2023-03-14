package com.example.java3assignmentsservlet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class GetBooks {
    /**
     * Retrieve all books from database into LinkedList.
     * @return List of Book objects
     */
    public static List<Book> getAllBooks() throws SQLException {
        LinkedList bookList = new LinkedList();

        Connection connection = DBConnection.initDatabase();
        Statement statement = connection.createStatement();
        String sqlQuery = "SELECT * from " + DBConfig.DB_BOOKS_TITLES_TABLE_NAME;

        ResultSet resultSet = statement.executeQuery(sqlQuery);
        while(resultSet.next()) {
            bookList.add(
                    new Book(
                            resultSet.getString(DBConfig.DB_BOOKS_TITLES_ISBN),
                            resultSet.getString(DBConfig.DB_BOOKS_TITLES_TITLE),
                            resultSet.getInt(DBConfig.DB_BOOKS_TITLES_EDITION_NUMBER),
                            resultSet.getString(DBConfig.DB_BOOKS_TITLES_COPYRIGHT)
                    )
            );
        }
        return bookList;
    }
}
