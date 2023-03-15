package com.example.java3assignmentsservlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "libraryData", value = "/library-data")
public class LibraryData extends HttpServlet {

    private String message;
    public void init() {
        message = "Library Servlet!";
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        //TODO Use a variable "view" to determine book or author query

        String view = request.getParameter("view");
        List<Book> bookList = null;
        List<Author> authorList = null;

        if(view.equals("booklist")) {

            try {
                bookList = GetBooks.getAllBooks();

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("viewallbooks.jsp");
                request.setAttribute("booklist", bookList);

                //TODO add the list to the request
                requestDispatcher.forward(request, response);

            } catch (SQLException e) {
                e.printStackTrace();
                //TODO Navigate to some error page
            }

        } else if (view.equals("authorlist")) {

            try {
                authorList = GetAuthors.getAllAuthors();
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("viewallauthors.jsp");
                request.setAttribute("authorlist", authorList);

                //TODO add the list to the request
                requestDispatcher.forward(request, response);

            } catch (SQLException e) {
                e.printStackTrace();
                //TODO Navigate to some error page
            }
        } else if (view.equals("authordropdown")) {

            try {
                authorList = GetAuthors.getAllAuthors();
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("addbook.jsp");
                request.setAttribute("authordropdown", authorList);

                //TODO add the list to the request
                requestDispatcher.forward(request, response);

            } catch (SQLException e) {
                e.printStackTrace();
                //TODO Navigate to some error page
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String view = request.getParameter("view");

        if(view.equals("book")){
            try {

                Book book = new Book(
                        request.getParameter("isbn"),
                        request.getParameter("title"),
                        Integer.valueOf(request.getParameter("edition_number")),
                        request.getParameter("copyright")
                );

                Author author = new Author(
                        0, // placeholder since authorID in db is autoincrement
                        request.getParameter("first_name"),
                        request.getParameter("last_name")
                );

                book.setAuthor(author);
                author.setBook(book);

                InsertBook.insertBook(book);

                InsertAuthor.insertAuthor(author);

                InsertAuthorISBN.insertAuthorISBN(book, author);

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
                requestDispatcher.forward(request, response);

            } catch (SQLException e) {
                e.printStackTrace();
                // navigate to error page
            }

        } else if (view.equals("author")) {
            try {
                InsertAuthor.insertAuthor(
                        new Author(
                                0, // placeholder since authorID in db is autoincrement
                                request.getParameter("first_name"),
                                request.getParameter("last_name")
                        ));
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
                requestDispatcher.forward(request, response);

            } catch (SQLException e) {
                e.printStackTrace();
                // navigate to error page
            }
        } else {
            // navigate to error page
        }
    }
}