<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add an author to the Database</title>
</head>
<body>

<h2>Add an Author</h2>

<form action = "library-data" method = "POST">
    First Name: <input type = "text" name = "first_name" /> <br />
    Last Name: <input type = "text" name = "last_name" /> <br />
    <input type="hidden" id="view" name="view" value="author">
    <input type = "submit" value = "Submit" onclick="confirm()" />
</form>

<script>
    function confirm() {
        alert("Author submitted!");
    }
</script>

</br>

<a href="index.jsp">Back to Main Menu</a>

</body>
</html>