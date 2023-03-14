<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book Database</title>
</head>
<body>

<h1>Welcome to the Book Database!</h1>

<li><a href="addbook.jsp">Add a book</a></li>
<li><a href="addauthor.jsp">Add an author</a></li>

<!-- //TODO Add in a param to differentiate the books vs authors -->
<li><a href="library-data?view=booklist">View all books</a></li>
<li><a href="library-data?view=authorlist">View all authors</a></li>


</body>
</html>