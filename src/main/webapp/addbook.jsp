<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add a book to the database</title>
</head>
<body>

<h1>Add a Book</h1>

<!--
    private String isbn;
    private String title;
    private int editionNumber;
    private String copyright;
    private String author;
-->

<form action = "library-data" method = "POST">
    ISBN: <input type = "text" name = "isbn"> <br />
    Title: <input type = "text" name = "title" /> <br />
    Edition Number: <input type = "text" name = "edition_number" /> <br />
    Copyright: <input type = "text" name = "copyright" /> <br />
    Author: <input type = "text" name = "author" /> <br />
    <input type="hidden" id="view" name="view" value="book">
    <input type = "submit" value = "Submit" onclick="confirm()" />
</form>

<script>
function confirm() {
    alert("Book submitted!");

}
</script>

</br>

<a href="index.jsp">Back to Main Menu</a>

</body>
</html>
