<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wangqingning
  Date: 2019/1/11
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>spittle</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css"/>">
</head>
<body>
    <div class="spittleMessages">
        <c:out value="${spittle.message}"/>
    </div>
    <div>
        <span><c:out value="${spittle.time}" /></span>
    </div>
</body>
</html>
