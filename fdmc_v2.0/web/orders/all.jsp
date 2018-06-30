<%@ page import="org.softuni.fdmc.data.models.Order" %>
<%@ page import="org.softuni.fdmc.data.repos.OrderRepository" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page import="java.time.format.DateTimeFormatter" %><%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 5.6.2018 г.
  Time: 12:10 ч.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FDMC</title>
    <link rel="stylesheet" href="bootstrap.min.css">
</head>
<body>
    <h1>All Orders</h1>
    <hr />

    <% OrderRepository orderRepository = (OrderRepository)application.getAttribute("orders");
    if(orderRepository.getAllOrders().size() == 0) {%>
    <h3>There are no orders.</h3>
    <%} else {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        for(Order order : orderRepository.getAllOrders().stream().sorted((x, y) -> y.getMadeOn().compareTo(x.getMadeOn())).collect(Collectors.toList())) {%>
    <h3>Client: <%=order.getClient().getUsername()%></h3>
    <h3>Cat: <%=order.getCat().getName()%></h3>
    <h3>MadeOn: <%=order.getMadeOn().format(formatter)%></h3>
    <br/>
    <% }
    } %>
    <a href="/">Back to Home</a>
</body>
</html>
