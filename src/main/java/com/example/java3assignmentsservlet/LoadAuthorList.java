package com.example.java3assignmentsservlet;

import java.sql.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class LoadAuthorList {

    public static LinkedList<Author> loadAuthorList (Connection connection) {
        LinkedList<Author> authorLinkedList = new LinkedList<>();
        try{
            // create query string and execute
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM " + DBConfig.DB_BOOKS_AUTHORS_TABLE_NAME + ";";
            ResultSet resultSet = statement.executeQuery(sql);

            // create author objects using result set and add to list
            while(resultSet.next()){
                authorLinkedList.add(
                        new Author(
                                resultSet.getInt(DBConfig.DB_BOOKS_AUTHORS_AUTHOR_ID),
                                resultSet.getString(DBConfig.DB_BOOKS_AUTHORS_FIRST_NAME),
                                resultSet.getString(DBConfig.DB_BOOKS_AUTHORS_LAST_NAME))
                );
            }

            statement.close();

        } catch (
                SQLException sqlException){
            sqlException.printStackTrace();
        }
        return authorLinkedList;
    }
}

