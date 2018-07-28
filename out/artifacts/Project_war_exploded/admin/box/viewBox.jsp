<%@ page import="com.erp.entity.box.Box" %><%--
  Created by IntelliJ IDEA.
  User: Cyber
  Date: 7/18/2018
  Time: 11:35 AM
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
        <input type="hidden" name="id" value="${requestScope.Box.id}">
        name: <input type="text" name="name" value="<c:out value="${requestScope.Box.name}"/>"><br/>
        price: <input type="text" name="price" value="<c:out value="${requestScope.Box.price}"/>"><br/>
        description: <input type="text" name="description" value="<c:out value="${requestScope.Box.description}"/>"><br/>
        <input type="submit" value="update">
    </form>



    <%--<c items="${Box}" var="box">
        <form action="/bc/findBox.do">
            <%

                Box box = (Box) request.getAttribute("Box");
                out.print(box.getName()+"<br/>");
                out.print(box.getPrice()+"<br/>");
                out.print(box.getDescription()+"<br/>");

            %>
            <input type="button" name="id" value="update" onclick="update('${box.id}')">
            <input hidden="hidden" name="id" value="${box.id}">
        </form>
    </c>--%>

<script>
    function update(id)
    {
        window.location = "/bc/updateBox.do?id="+id;
    }
</script>
</body>
</html>
