package com.example.java3assignmentsservlet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GetBooks {
    /**
     * Retrieve all books from database
     * Then retrieve all books for each author
     * @return List of Books with their Authors
     */
    public static List<List<String>> getAllBooks() throws SQLException {
        // code a list to pass to jsp page, each item will be an array of info describing a single book
        ArrayList bookList = new ArrayList();
        Connection connection = DBConnection.initDatabase();

        try {
            // create statement to retrieve all data from titles table
            Statement statement = connection.createStatement();
            String allBooksQuery = "SELECT * from " + DBConfig.DB_BOOKS_TITLES_TABLE_NAME;
            ResultSet allBooksResultSet = statement.executeQuery(allBooksQuery);

            while(allBooksResultSet.next()) {
                // code another list to place in first list
                ArrayList bookAttributes = new ArrayList();

                // create prepared statement that will get all authors of each book in first result set.
                String authorsWithISBNQuery = "SELECT firstName, lastName, authorID FROM authors WHERE authorID IN " +
                        "(SELECT authorID FROM authorisbn WHERE isbn = ?)";

                PreparedStatement preparedStatement = connection.prepareStatement(authorsWithISBNQuery);
                preparedStatement.setInt(1, allBooksResultSet.getInt(DBConfig.DB_BOOKS_TITLES_ISBN));
                ResultSet booksWithAuthorIDResultSet = preparedStatement.executeQuery();

                // add book data to attributes list
                bookAttributes.add(allBooksResultSet.getString(DBConfig.DB_BOOKS_TITLES_ISBN));
                bookAttributes.add(allBooksResultSet.getString(DBConfig.DB_BOOKS_TITLES_TITLE));
                bookAttributes.add(allBooksResultSet.getString(DBConfig.DB_BOOKS_TITLES_EDITION_NUMBER));
                bookAttributes.add(allBooksResultSet.getString(DBConfig.DB_BOOKS_TITLES_COPYRIGHT));

                // add the author for each book in first result set and add to attributes
                String author;
                while(booksWithAuthorIDResultSet.next()) {
                    author = booksWithAuthorIDResultSet.getString(DBConfig.DB_BOOKS_AUTHORS_FIRST_NAME) + " " +
                    booksWithAuthorIDResultSet.getString(DBConfig.DB_BOOKS_AUTHORS_LAST_NAME) + ",";
                    bookAttributes.add(author);
                }
                preparedStatement.close();

                // add list of attributes to first list
                bookList.add(bookAttributes);
            }
            statement.close();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return bookList;
    }
}
