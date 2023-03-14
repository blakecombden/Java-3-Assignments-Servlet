package com.example.java3assignmentsservlet;

import java.io.PrintStream;

/**
 * Contains attributes, constructor, getters, and setters for
 * book objects taken from titles table in books database
 * Prints book list for user
 *
 * @author blake
 */
public class Book {

    private String isbn;
    private String title;
    private int editionNumber;
    private String copyright;
    private Author author;

    public Book(String isbn, String title, int editionNumber, String copyright) {
        this.isbn = isbn;
        this.title = title;
        this.editionNumber = editionNumber;
        this.copyright = copyright;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEditionNumber() {
        return editionNumber;
    }

    public void setEditionNumber(int editionNumber) { this.editionNumber = editionNumber; }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public Author getAuthor() { return author; }

    public void setAuthor(Author author){ this.author = author; }

    public static void printBook(PrintStream printStream, Book book){
        printStream.printf("\n%s, Edition %d (%s) ISBN: %S Author: %s %s", book.getTitle(), book.getEditionNumber(),
                book.getCopyright(), book.getIsbn(), book.getAuthor().getFirstName(), book.getAuthor().getLastName());
    }
}