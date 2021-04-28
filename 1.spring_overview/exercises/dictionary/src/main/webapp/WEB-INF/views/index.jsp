<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Dictionary</title>
  </head>
  <body>
    <form action="/index" method="post">
        <fieldset style="width: 400px">
            <legend >
               Dictionary
            </legend>
            <label for="eng">ENGLISH : </label>
            <input type="text" name="english" id="eng" value="${english}"> <br><br>
            <p>${notfound}</p>

            <label for="vn" >VIETNAM : </label>
            <input type="text" name="vietnam" id="vn" value="${result}" readonly> <br><br>
            <input type="submit" value="Translate">
        </fieldset>

    </form>
  </body>
</html>
