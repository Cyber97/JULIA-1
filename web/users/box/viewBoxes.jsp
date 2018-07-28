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
            <td>name</td>
            <td>price</td>
            <td>view</td>
        </tr>
        </thead>
<c:forEach items="${requestScope.Boxes}" var="boxes">
        <tr>
            <td><label>${boxes.name}</label></td>
            <td><label>${boxes.price}</label></td>
            <td><label>${boxes.description}</label></td>
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
            window.location = "/bc/findBox.do?id="+id;
        }
    </script>

</body>
</html>
