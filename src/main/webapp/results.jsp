<%--
  Created by IntelliJ IDEA.
  User: Oscar
  Date: 11/14/2021
  Time: 10:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>${data}</h1>
<h2>${title}</h2>
<table class="table table-bordered">
    <tr><th>First Name</th><th>Last Name</th></tr>
    <c:forEach items="${data}" var="customer">
        <tr>

            <td>${data.param}</td>
            <td>${data.param2}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
