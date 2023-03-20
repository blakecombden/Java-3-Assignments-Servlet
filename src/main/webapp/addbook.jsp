<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add a book to the database</title>
</head>
<body>

<h2>Add a Book</h2>

<!-- Get "authorlist" attribute from request -->
<% List<List<String>> authorList =  (List<List<String>>)  request.getAttribute("authorlist"); %>

<!-- Form inputs, including hidden field with "book" value -->
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
<!-- Display data in table format for user to reference when adding author-->
<table>
    <tr>
        <th>Author ID</th>
        <th>Name</th>
    </tr>

    <%
        for (int i = 0; i < authorList.size(); ++i) {
            out.println("<tr>");
            for (int j = 0; j < 2; ++j) {
                out.println("<td>" + authorList.get(i).get(j) + "</td>");
            }
            out.println("</tr>");
        }
    %>

</table>

<script>
    <!-- Function to alert user -->
    function confirm() {
        alert("Book submitted!");
    }
</script>

</br>
<!-- Return to home page -->
<a href="index.jsp">Back to Main Menu</a>

</body>
</html>
