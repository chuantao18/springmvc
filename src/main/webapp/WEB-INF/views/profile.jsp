<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>
    <h1>Your Profile</h1>
    <div><c:out value="${spitter.username}"/></div>
    <div>
        <span><c:out value="${spitter.firstName}"/></span>
        <span><c:out value="${spitter.lastName}"/></span>
    </div>
</body>
</html>
