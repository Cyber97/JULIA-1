<%--
  Created by IntelliJ IDEA.
  User: Cyber
  Date: 7/21/2018
  Time: 4:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/uc/updateUser.do">
        <input type="hidden" name="id" value="${requestScope.User.id}">
        <input type="text" name="firstName" value="${requestScope.User.firstName}">
        <input type="text" name="lastName" value="${requestScope.User.lastName}">
        <input type="text" name="email" value="${requestScope.User.email}">
        <input type="text" name="password" value="${requestScope.User.password}">
        <input type="text" name="image" value="${requestScope.User.image}">
        <%--image: <c:out value="${requestScope.User.image}"/><br/>--%>
        <input type="button" name="id" value="update" onclick="find('${requestScope.User.id}')">
        <input hidden="hidden" name="id" value="${requestScope.user.id}">
    </form>

    <script>
        function find(id)
        {
            window.location = "/uc/updateUser.do?id="+id;
        }
    </script>
</body>
</html>
