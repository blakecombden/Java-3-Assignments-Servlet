<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book Database</title>
</head>
<body>

<li><a href="addbook.jsp">Add a Book</a></li>
<li><a href="addauthor.jsp">Add an Author</a></li>

<!-- //TODO Add in a param to differentiate the books vs authors -->
<li><a href="/library-data?view=books">View all books</a></li>
<li><a href="library-data">View all Authors</a></li>


</body>
</html>