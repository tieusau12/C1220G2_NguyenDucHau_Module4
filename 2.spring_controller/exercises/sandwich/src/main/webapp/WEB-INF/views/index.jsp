<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: moon
  Date: 28/04/2021
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich </title>
</head>
<body>
<h1>Sandwich Condiment</h1>
<c:forEach items='${requestScope["condiment"]}' var="choise">
  <h2 style="color: red">${choise}</h2>
</c:forEach>
<c:out value="${result}"/>
</body>
</html>
