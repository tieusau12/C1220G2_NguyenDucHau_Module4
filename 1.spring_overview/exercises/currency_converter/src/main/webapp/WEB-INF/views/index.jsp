<%--
  Created by IntelliJ IDEA.
  User: moon
  Date: 27/04/2021
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Currency Converter</title>
</head>
<body>
<form action="/usd" method="post">
    <label>
        Rate :
    </label>
    <input type="text" name="rate" placeholder="Rate" value="23000"/> <br>
    <label>
        USD :
    </label>
    <input type="text" name="usd" placeholder="USD" value="0"/> <br>
    <input type="submit" id="submit" value="Converter">
</form>
</body>
</html>
