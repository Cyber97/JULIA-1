<%--
  Created by IntelliJ IDEA.
  User: Cyber
  Date: 7/21/2018
  Time: 2:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/uc/findUserByEmail.do">
        search by email:
        <input type="text" name="searchEmail"/><br/>
        <input type="submit" value="submit">
    </form>
    <br/>
    <form action="/uc/usersReportByDate.do">
        report by date:
        start: <input type="text" name="startDate"/>
        end: <input type="text" name="endDate">
        <input type="submit" value="submit">
    </form>

<table>
    <thead>
    <tr>
        <td>firstName</td>
        <td>lastName</td>
        <td>email</td>
    </tr>
    </thead>
    <c:forEach items="${requestScope.Users}" var="users">
        <tr>
            <td><label>${users.firstName}</label></td>
            <td><label>${users.lastName}</label></td>
            <td><label>${users.email}</label></td>
            <td>
                <form action="/uc/findUser.do">
                    <input type="button" name="id" value="view" onclick="find('${users.id}')">
                    <input hidden="hidden" name="id" value="${users.id}">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<script>
    function find(id)
    {
        window.location = "/uc/findUser.do?id="+id;
    }

    function findByEmail()
    {
        window.location = "/uc/findUserByEmail.do";
    }
</script>

</body>
</html>
