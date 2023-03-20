package com.example.java3assignmentsservlet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GetAuthors {
    /**
     * Retrieve all authors from database
     * Then retrieve all authors for each book.
     * @return List of Authors with their Books
     */
    public static List<List<String>> getAllAuthors() throws SQLException {
        // code a list to pass to jsp page, each item will be an array of info describing a single author
        ArrayList authorList = new ArrayList();
        Connection connection = DBConnection.initDatabase();

        try {
            // create statement to retrieve all data from authors table
            Statement statement = connection.createStatement();
            String allAuthorsQuery = "SELECT * from " + DBConfig.DB_BOOKS_AUTHORS_TABLE_NAME;
            ResultSet allAuthorsResultSet = statement.executeQuery(allAuthorsQuery);

            while(allAuthorsResultSet.next()) {
                // code another list to place in first list
                ArrayList authorAttributes = new ArrayList();

                // create prepared statement that will get all books of each author in first result set.
                String booksWithAuthorIDQuery = "SELECT title, isbn FROM titles WHERE isbn IN " +
                        "(SELECT isbn FROM authorisbn WHERE authorid= ?)";

                PreparedStatement preparedStatement = connection.prepareStatement(booksWithAuthorIDQuery);
                preparedStatement.setInt(1, allAuthorsResultSet.getInt(DBConfig.DB_BOOKS_AUTHORS_AUTHOR_ID));
                ResultSet booksWithAuthorIDResultSet = preparedStatement.executeQuery();

                // add author data to attributes list
                authorAttributes.add(allAuthorsResultSet.getString(DBConfig.DB_BOOKS_AUTHORS_AUTHOR_ID));
                authorAttributes.add(allAuthorsResultSet.getString(DBConfig.DB_BOOKS_AUTHORS_FIRST_NAME) + " "
                        + allAuthorsResultSet.getString(DBConfig.DB_BOOKS_AUTHORS_LAST_NAME));

                // add the book for each author in first result set and add to attributes
                String book;
                while(booksWithAuthorIDResultSet.next()) {
                    book = booksWithAuthorIDResultSet.getString(DBConfig.DB_BOOKS_TITLES_TITLE);
                    authorAttributes.add(book);
                }
                preparedStatement.close();

                // add list of attributes to first list
                authorList.add(authorAttributes);

            }
            statement.close();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return authorList;
    }
}