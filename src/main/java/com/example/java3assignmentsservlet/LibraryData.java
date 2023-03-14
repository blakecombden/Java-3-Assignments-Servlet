package com.example.java3assignmentsservlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
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

        if(view.equals("booklist")) {

            List<Book> bookList = null;

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

            List<Author> authorList = null;

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
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String view = request.getParameter("view");

        if(view.equals("book")){
            try {
                InsertBook.insertBook(
                        new Book(
                                request.getParameter("isbn"),
                                request.getParameter("title"),
                                Integer.valueOf(request.getParameter("edition_number")),
                                request.getParameter("copyright")
                        ));
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("addbook.jsp");
                requestDispatcher.forward(request, response);

            } catch (SQLException e) {
                e.printStackTrace();
                // navigate to error page
            }

        } else if (view.equals("author")) {
            try {
                InsertAuthor.insertAuthor(
                        new Author(
                                Integer.valueOf(request.getParameter("author_id")),
                                request.getParameter("first_name"),
                                request.getParameter("last_name")
                        ));

            } catch (SQLException e) {
                e.printStackTrace();
                // navigate to error page
            }
        } else {
            // navigate to error page
        }
    }
}