<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add an author to the Database</title>
</head>
<body>

<h2>Add an Author</h2>

<!-- Form inputs, including hidden field with "author" value -->
<form action = "library-data" method = "POST">
    First Name: <input type = "text" name = "first_name" /> <br />
    Last Name: <input type = "text" name = "last_name" /> <br />
    <input type="hidden" id="view" name="view" value="author">
    <input type = "submit" value = "Submit" onclick="confirm()" />
</form>

<script>
    <!-- Function to alert user -->
    function confirm() {
        alert("Author submitted!");
    }
</script>

</br>
<!-- Return to home page -->
<a href="index.jsp">Back to Main Menu</a>

</body>
</html>