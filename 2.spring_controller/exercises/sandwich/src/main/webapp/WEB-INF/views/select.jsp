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
    <title>Sandwich Condiments</title>
</head>
<body>
<h2>Sandwich Condiments</h2>
<form action="save" method="post">
    <ul>
        <li style="display: inline-block">
            <input type="checkbox" id="lettuce" name="condiment" value="Lettuce"/>
            <label for="lettuce">Lettuce</label>
        </li>
        <li style="display: inline-block">
            <input type="checkbox" id="tomato" name="condiment" value="Tomato"/>
            <label for="tomato">Tomato</label>
        </li>
        <li style="display: inline-block">
            <input type="checkbox" id="mustard" name="condiment" value="Mustard"/>
            <label for="mustard">Mustard</label>
        </li>
        <li style="display: inline-block">
            <input type="checkbox" id="sprouts" name="condiment" value="Sprouts"/>
            <label for="sprouts"> Sprouts</label>
        </li>
        <li>
            <input type="submit" value="save"/>
        </li>
    </ul>
</form>

</body>
</html>
