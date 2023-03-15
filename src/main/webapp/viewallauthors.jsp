<%@ page import="java.util.List" %>
<%@ page import="com.example.java3assignmentsservlet.Author" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>View all authors from the Database</title>
</head>
<body>

<h2>List of Authors</h2>

<% List<Author> authorList =  (List<Author>) request.getAttribute("authorlist"); %>

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
</br>
<a href="index.jsp">Back to Main Menu</a>

</body>
</html>