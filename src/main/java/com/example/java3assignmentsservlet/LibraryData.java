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

/**
 * Overrides doPost and doGet methods, handles form submission data,
 * inserts this data into database, and handles views of submitted data.
 */

@WebServlet(name = "libraryData", value = "/library-data")
public class LibraryData extends HttpServlet {

    // stores data to display in lists of lists
    List<List<String>> bookList = null;
    List<List<String>> authorList = null;

    // initiate RequestDispatcher object
    RequestDispatcher requestDispatcher = null;

    private String message;
    /**
     * Init method for service to instantiate attribute.
     */
    public void init() {
        message = "Library Servlet!";
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        // uses "view" variable to determine book or author query
        String view = request.getParameter("view");

        if(view.equals("booklist")) {

            try {
                // retrieve entire book list (with authors) and add to request
                bookList = GetBooks.getAllBooks();

                requestDispatcher = request.getRequestDispatcher("viewallbooks.jsp");
                request.setAttribute("booklist", bookList);

                requestDispatcher.forward(request, response);

            } catch (SQLException e) {
                e.printStackTrace();
                requestDispatcher = request.getRequestDispatcher("errorpage.jsp");
                requestDispatcher.forward(request, response);
            }

        } else if (view.equals("authorlist")) {

            try {
                // retrieve entire author list (with books) and add to request
                authorList = GetAuthors.getAllAuthors();

                requestDispatcher = request.getRequestDispatcher("viewallauthors.jsp");
                request.setAttribute("authorlist", authorList);

                requestDispatcher.forward(request, response);

            } catch (SQLException e) {
                e.printStackTrace();
                requestDispatcher = request.getRequestDispatcher("errorpage.jsp");
                requestDispatcher.forward(request, response);
            }
        } else if (view.equals("addbook")) {

            try {
                // retrieve entire author list and add to request
                authorList = GetAuthors.getAllAuthors();

                requestDispatcher = request.getRequestDispatcher("addbook.jsp");
                request.setAttribute("authorlist", authorList);

                requestDispatcher.forward(request, response);

            } catch (SQLException e) {
                e.printStackTrace();
                requestDispatcher = request.getRequestDispatcher("errorpage.jsp");
                requestDispatcher.forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // uses "view" variable to determine book and author query or just author query
        String view = request.getParameter("view");

        if(view.equals("book")){
            try {
                // instantiate both objects
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

                // insert into book and authorISBN tables
                InsertBook.insertBook(book);
                InsertAuthorISBN.insertAuthorISBN(book, author);

                // go to home page
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
                requestDispatcher.forward(request, response);

            } catch (SQLException e) {
                e.printStackTrace();
                requestDispatcher = request.getRequestDispatcher("errorpage.jsp");
                requestDispatcher.forward(request, response);
            }

        } else if (view.equals("author")) {
            try {
                // instantiate an author object
                Author author = new Author(
                        0, // placeholder since authorID in db is autoincrement
                        request.getParameter("first_name"),
                        request.getParameter("last_name")
                );

                // insert into authors table
                InsertAuthor.insertAuthor(author);

                // go to home page
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
                requestDispatcher.forward(request, response);

            } catch (SQLException e) {
                e.printStackTrace();
                requestDispatcher = request.getRequestDispatcher("errorpage.jsp");
                requestDispatcher.forward(request, response);
            }
        } else {
            requestDispatcher = request.getRequestDispatcher("errorpage.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}