<%@ page import="java.util.List" %>
<%@ page import="com.example.java3assignmentsservlet.Author" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>View all authors from the Database</title>
</head>
<body>

List of Authors

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

<a href="index.jsp">Back to Main Menu</a>

</body>
</html>