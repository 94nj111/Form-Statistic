<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 06.10.2022
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="logic.Result" %>
<html>
<head>
    <title>Statistic</title>
</head>
<header>
    <p><a href="form">Form</a></p>
    <p><a href="index.jsp">Login</a></p>
</header>
<body>
<%String login = (String)session.getAttribute("user_login");
    if(login != null && !"".equals(login)){
        if(Result.getMap().get(login) != null){%>
<p>Personal Statistic</p>
<%=Result.getStat(Result.getMap().get(login))%>
<%      }
    }%>
<p>All Statistic</p>
    <%=Result.getStat(Result.getList())%>

</body>
</html>
