<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add an author to the Database</title>
</head>
<body>

Add an Author

<!--
    private int authorID;
    private String firstName;
    private String lastName;
    private String book;
-->

<h1>Add an Author!</h1>

<form action = "library-data" method = "POST">
    Author ID: <input type = "text" name = "author_id"> <br />
    First Name: <input type = "text" name = "first_name" /> <br />
    Last Name: <input type = "text" name = "last_name" /> <br />
    Book: <input type = "text" name = "book" />
    <input type="hidden" id="view" name="view" value="author">
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