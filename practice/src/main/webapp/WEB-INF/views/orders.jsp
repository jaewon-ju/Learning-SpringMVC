<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body> 성공
<a href="/index.html">메인</a>
<table>
    <thead>
    <th>id</th>
    <th>product</th>
    <th>count</th>
    </thead>
<tbody>
<c:forEach var="item" items="${orders}">
    <tr>
        <td>${item.id}</td>
        <td>${item.product}</td>
        <td>${item.count}</td>
    </tr>
</c:forEach>
    </tbody>
</table>
</body>
</html>