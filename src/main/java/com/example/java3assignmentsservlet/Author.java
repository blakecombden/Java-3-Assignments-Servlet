package com.example.java3assignmentsservlet;

import java.io.PrintStream;

/**
 * Contains attributes, constructor, getters, and setters for
 * author objects taken from authors table in books database
 * Prints author list for user
 *
 * @author blake
 */
public class Author {

    private int authorID;
    private String firstName;
    private String lastName;
    private Book book;

    public Author(int authorID, String firstName, String lastName) {
        this.authorID = authorID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getAuthorID() { return authorID; }

    public void setAuthorID(int authorID) { this.authorID = authorID; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public Book getBook() { return book; }

    public void setBook(Book book) { this.book = book; }

    public static void printAuthor(PrintStream printStream, Author author) {
        printStream.printf("\n%s %s (ID %d) Book: %s", author.getFirstName(),
                author.getLastName(), author.getAuthorID(), author.getBook().getTitle());
    }
}