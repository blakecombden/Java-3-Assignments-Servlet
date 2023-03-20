<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>View all books from the Database</title>
</head>
<body>

<h2>List of Books and their Authors</h2>

<!-- Get "booklist" attribute from request -->
<% List<List<String>> bookList =  (List<List<String>>) request.getAttribute("booklist"); %>

<!-- Display data in table format -->
<table>
  <tr>
    <th>ISBN</th>
    <th>Title</th>
    <th>Edition</th>
    <th>Copyright</th>
    <th>Authors</th>
  </tr>

  <%
    for (int i = 0; i < bookList.size(); ++i) {
      out.println("<tr>");
      for (int j = 0; j < bookList.get(i).size(); ++j) {
        out.println("<td>" + bookList.get(i).get(j) + "</td>");
      }
      out.println("</tr>");
    }
  %>

</table>
</br>
<!-- Return to home page -->
<a href="index.jsp">Back to Main Menu</a>

</body>
</html>