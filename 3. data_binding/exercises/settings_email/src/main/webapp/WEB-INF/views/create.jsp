<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Create a new employee</title>
</head>
<body>
<h3>Welcome, Enter The Employee Details</h3>
<form:form action="/create" method="post" modelAttribute="email">
    <table>
        <tr>
            <td>Language : </td>
            <td><form:select path="language" items="${listLanguage}"/></td>
        </tr>
        <tr>
            <td>Page Size :</td>
            <td>Show <form:select path="pageSize" items="${listPageSize}"/></td>
        </tr>
        <tr>
            <td>Spams filter :</td>
            <td><form:checkbox path="spamsFilter"/> Enable spams filter</td>
        </tr>
        <tr>
            <td>Signature:</td>
            <td><form:textarea path="signature"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Update"/></td>
            <td><input type="submit" value="Cancel"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>