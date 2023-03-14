<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add a book to the database</title>
</head>
<body>

Add a Book

<!--
    private String isbn;
    private String title;
    private int editionNumber;
    private String copyright;
    private String author;
-->

<h1>Add a Book!</h1>

function confirm()
{
alert("Book added!");
}

<form action = "library-data" method = "POST" onsubmit="confirm()">
    ISBN: <input type = "text" name = "isbn"> <br />
    Title: <input type = "text" name = "title" /> <br />
    Edition Number: <input type = "text" name = "edition_number" /> <br />
    Copyright: <input type = "text" name = "copyright" />
    Author: <input type = "text" name = "author" />
    <input type="hidden" id="view" name="view" value="book">
    <input type = "submit" value = "Submit" />
</form>

</br>
<a href="index.jsp">Back to Main Menu</a>


</body>
</html>
