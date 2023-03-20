<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>View all authors from the Database</title>
</head>
<body>

<h2>List of Authors and their Books</h2>

<!-- Get "authorlist" attribute from request -->
<% List<List<String>> authorList =  (List<List<String>>) request.getAttribute("authorlist"); %>

<!-- Display data in table format -->
<table>
  <tr>
    <th>Author ID</th>
    <th>Name</th>
    <th>Books</th>
  </tr>

  <%
    for (int i = 0; i < authorList.size(); ++i) {
      out.println("<tr style=\"height:100px\">");
      for (int j = 0; j < authorList.get(i).size(); ++j) {
        out.println("<td style=\"width:600px\">" + authorList.get(i).get(j) + "</td>");
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