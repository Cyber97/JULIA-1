<%--
  Created by IntelliJ IDEA.
  User: Cyber
  Date: 7/15/2018
  Time: 4:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  $END$
  <%
    out.print(request.getSession().getAttribute("verifyCode"));
  %>
  </body>
</html>
