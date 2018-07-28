<%--
  Created by IntelliJ IDEA.
  User: Cyber
  Date: 7/21/2018
  Time: 2:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/uc/registerUserAdmin.do">
        firstName: <input type="text" name="firstName" maxlength="40"/><br/>
        lastName: <input type="text" name="lastName" maxlength="40"/><br/>
        password: <input type="text" name="password" maxlength="40"/><br/>
        email: <input type="text" name="email" maxlength="40"/><br/>
        <input type="submit" value="submit"/>
    </form>

</body>
</html>
