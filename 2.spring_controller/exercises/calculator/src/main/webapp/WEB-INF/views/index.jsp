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
    <title>Calculator </title>
</head>
<body>
<form action="/calculator" method="post" style="border: 1px; width: 500px">
    <fieldset>
        <legend>Calculator</legend>
        <table>
            <tr>
                <td>First operand:</td>
                <td><input type="text" name="firstNumber"></td>
            </tr>
            <tr>
                <td>Operator :</td>
                <td><select name="operator">
                    <option value="+">Additon</option>
                    <option value="-">Subtraction</option>
                    <option value="/">Division</option>
                    <option value="*">Multiplication</option>
                </select></td>
            </tr>
            <tr>
                <td>Second operand :</td>
                <td><input type="text" name="secondNumber"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" id="submit" value="Calculate"></td>
            </tr>
        </table>
    </fieldset>
</form>
<h1> Result : </h1>
<c:if test="${requestScope.result == 'Infinity'}">
    <p> Cannot division by zero</p>
</c:if>

<c:if test="${requestScope.result != 'Infinity'}">
    <p><%=request.getAttribute("firstNumber")%> <%=request.getAttribute("operator")%>
        <%=request.getAttribute("secondNumber")%>
        = <%=request.getAttribute("result")%>
    </p>
</c:if>

</body>
</html>
