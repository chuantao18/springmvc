<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" /> ">
</head>
<body>
    <h1>Register</h1>
    <form method="post">
        First Name: <input type="text" name="firstName" /><br />
        Last Name: <input type="text" name="lastName" /><br />
        UserName: <input type="text" name="username" /><br />
        Password: <input type="password" name="password" /><br />
        Email: <input type="text" name="email" /><br />
        <input type="submit" value="Register">
    </form>
</body>
</html>
