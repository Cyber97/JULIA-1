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


<form action="/bc/updateBox.do" method="post">
    name: <input type="text" name="name" readonly value="<c:out value="${requestScope.Box.name}"/>"><br/>
    price: <input type="text" name="price" readonly value="<c:out value="${requestScope.Box.price}"/>"><br/>
    description: <input type="text" name="description" readonly value="<c:out value="${requestScope.Box.description}"/>"><br/>
    <input type="submit" value="view & payment" onclick="find('${requestScope.Box.id}">
</form>

<script>
    function find(id)
    {
        window.location = "/bc/findBox.do?id="+id;
    }

</script>

</body>
</html>
