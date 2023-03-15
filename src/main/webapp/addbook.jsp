<%@ page import="com.example.java3assignmentsservlet.Author" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add a book to the database</title>
</head>
<body>

<h2>Add a Book</h2>

<% List<Author> authorList =  (List<Author>) request.getAttribute("authordropdown"); %>

<form action = "library-data" method = "POST">
    ISBN: <input type = "text" name = "isbn"> <br />
    Title: <input type = "text" name = "title" /> <br />
    Edition Number: <input type = "text" name = "edition_number" /> <br />
    Copyright: <input type = "text" name = "copyright" /> <br />
    Author's First Name: <input type = "text" name = "first_name" /> <br />
    Author's Last Name: <input type = "text" name = "last_name" /> <br />
    <input type="hidden" id="view" name="view" value="book"> <br />
    <input type = "submit" value = "Submit" onclick="confirm()" />
</form>

<h3>Current List of Authors</h3>

<table>
    <tr>
        <th>Author ID</th>
        <th>First Name</th>
        <th>Last Name</th>
    </tr>

    <%
        for (Author author: authorList) {
            out.println("<tr>");
            out.println("<td>" + author.getAuthorID() + "</td>");
            out.println("<td>" + author.getFirstName() + "</td>");
            out.println("<td>" + author.getLastName() + "</td>");
            out.println("</tr>");
        }
    %>

</table>

<script>
function confirm() {
    alert("Book submitted!");

}
</script>

</br>

<a href="index.jsp">Back to Main Menu</a>

</body>
</html>
