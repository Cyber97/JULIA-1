<%--
  Created by IntelliJ IDEA.
  User: Cyber
  Date: 7/18/2018
  Time: 10:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <thead>
        <tr>
            <td>id</td>
            <td>name</td>
            <td>price</td>
            <td>update</td>
            <td>delete</td>
        </tr>
        </thead>
<c:forEach items="${requestScope.Boxes}" var="boxes">
        <tr>
            <td>${boxes.id}</td>
            <td><input type="text" name="name" value="${boxes.name}"></td>
            <td><input type="text" name="price" value="${boxes.price}"></td>
            <td>
                <form action="/bc/updateBox.do">
                    <input type="button" name="id" value="delete" onclick="doDelete('${boxes.id}')">
                    <input hidden="hidden" name="id" value="${boxes.id}">
                </form>

            </td>
            <td>
                <form action="/bc/findBox.do">
                    <input type="button" name="id" value="view" onclick="find('${boxes.id}')">
                    <input hidden="hidden" name="id" value="${boxes.id}">
                </form>
            </td>
        </tr>
</c:forEach>
    </table>

    <script>
        function find(id)
        {
            window.location = "/bc/findBoxAdmin.do?id="+id;
        }
        function doDelete(id)
        {
            window.location = "/bc/removeBox.do?id="+id;
        }

    </script>

</body>
</html>
