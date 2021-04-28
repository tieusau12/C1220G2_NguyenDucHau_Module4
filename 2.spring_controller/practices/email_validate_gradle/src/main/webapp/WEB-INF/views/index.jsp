<%--
  Created by IntelliJ IDEA.
  User: moon
  Date: 28/04/2021
  Time: 08:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Spring Gradle</title>
  </head>
  <body>
  <h1>Email Validate</h1>
  <h3 style="color:blue">${message}</h3>
<form action="validate" method="post">
  <input type="text" name="email"> <br>
  <input type="submit" value="validate">
</form>
  </body>
</html>
