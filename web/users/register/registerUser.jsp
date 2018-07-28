<%--
  Created by IntelliJ IDEA.
  User: Cyber
  Date: 7/15/2018
  Time: 4:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/uc/registerUser.do" enctype="multipart/form-data" method="post">
    username: <input type="text" name="username" maxlength="40"/><br/>
    password: <input type="text" name="password" maxlength="40"/><br/>
    email: <input type="text" name="email" maxlength="40"/><br/>
    passportScan: <input type="file" name="image" accept="image/*"><br/>
    <input type="submit" value="submit"/>
</form>
</body>
</html>
