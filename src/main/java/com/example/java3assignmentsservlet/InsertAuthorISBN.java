package com.example.java3assignmentsservlet;

import java.sql.*;
import java.util.LinkedList;

/**
 *
 *
 * @author blake
 */

public class InsertAuthorISBN {

    public static void insertAuthorISBN(Book book, Author authorFromForm) throws SQLException {
        Connection connection = DBConnection.initDatabase();

        LinkedList<Author> authorList = new LinkedList<>();
        authorList = LoadAuthorList.loadAuthorList(connection);
        Integer authorID = null;

        for (Author authorFromDB : authorList) {
            if (authorFromDB.getFirstName().equals(authorFromForm.getFirstName()) &&
                    authorFromDB.getLastName().equals(authorFromForm.getLastName())) {
                authorID = authorFromDB.getAuthorID();
            }
        }

        String sql = "INSERT INTO authorISBN (authorID, isbn) VALUES (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1, authorID);
        preparedStatement.setString(2, book.getIsbn());

        preparedStatement.executeUpdate();

        preparedStatement.close();
    }
}