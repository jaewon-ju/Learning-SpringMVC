<%@ page import="Servlet.practice.domain.Order" %>
<%@ page import="Servlet.practice.domain.OrderRepository" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    OrderRepository orderRepository = OrderRepository.getInstance();
    System.out.println("save.jsp");
    String product = request.getParameter("product");
    int count = Integer.parseInt(request.getParameter("count"));

    Order order = new Order(product,count);
    orderRepository.save(order);
%>

<html>
<head>
    <meta charset="UTF-8">
</head>
<body> 성공
<ul>
     <li> id=<%=order.getId()%></li>
     <li>product=<%=order.getProduct()%></li>
     <li>count=<%=order.getCount()%></li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>