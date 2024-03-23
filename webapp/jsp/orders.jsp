<%@ page import="java.util.List" %>
<%@ page import="Servlet.practice.domain.Order" %>
<%@ page import="Servlet.practice.domain.OrderRepository" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    OrderRepository orderRepository = OrderRepository.getInstance();
    List<Order> orders = orderRepository.findAll();
%>

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
<%
    for (Order order: orders) {
        out.write("<tr>");
        out.write("<td>"+order.getId()+"</td>");
        out.write("<td>"+order.getProduct()+"</td>");
        out.write("<td>"+order.getCount()+"</td>");
        out.write("</tr>");
    }
%>
    </tbody>
</table>
</body>
</html>