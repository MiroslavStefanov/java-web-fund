<%@ page import="org.softuni.fdmc.data.models.Cat" %>
<%@ page import="org.softuni.fdmc.data.repos.CatRepository" %>
<%@ page import="java.util.stream.Collectors" %>
<%--
  Created by IntelliJ IDEA.
  User: atriu
  Date: 1.6.2018 г.
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FDMC</title>
    <link rel="stylesheet" href="bootstrap.min.css">
</head>
<body>
    <h1>All Cats</h1>
    <hr />
    <% CatRepository cats = (CatRepository) application.getAttribute("cats"); %>
    <%if(cats.getAllCats().size() == 0) {%>
    <h3>There are no cats.</h3>
    <%} else {
        for(Cat cat : cats.getAllCats().stream().sorted((x, y) -> Integer.compare(y.getViews(), x.getViews())).collect(Collectors.toList())) { %>
        <h3>
            <a href="/cats/profile?catName=<%= cat.getName()%>"><%= cat.getName()%></a>
        </h3>
    <% }
    }
    %>

    <br />
    <a href="/">Back to Home</a>
</body>
</html>
