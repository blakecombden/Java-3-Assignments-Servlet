package com.example.java3assignmentsservlet;

import java.sql.*;
import java.util.List;

/**
 * Connects to database and uses insert prepared statement to insert a new relationship in authorisbn table
 * Iterates through stored authors to retrieve id of new author to insert into table
 * @author blake
 */

public class InsertAuthorISBN {

    public static void insertAuthorISBN(Book book, Author authorFromForm) throws SQLException {

        Connection connection = DBConnection.initDatabase();

        // retrieve all authors
        List<List<String>> authorList;
        authorList = GetAuthors.getAllAuthors();

        // insert statement requires id
        String authorID = null;

        // iterate through authors and match submitted author to get their id
        for (int i = 0; i < authorList.size(); ++i) {
            if (authorList.get(i).get(1).equals(authorFromForm.getFirstName() + " " + authorFromForm.getLastName())) {
                authorID = authorList.get(i).get(0);
            }
        }

        // convert to int
        Integer intAuthorID = Integer.parseInt(authorID);

        String sql = "INSERT INTO authorISBN (authorID, isbn) VALUES (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1, intAuthorID);
        preparedStatement.setString(2, book.getIsbn());

        preparedStatement.executeUpdate();

        preparedStatement.close();
    }
}