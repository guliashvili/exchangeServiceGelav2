<%@ page import="ge.exchangeservicegela.dao.Dao" %>
<%--
  Created by IntelliJ IDEA.
  User: GIO
  Date: 6/12/2015
  Time: 8:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
    Dao dao = new Dao();
    dao.sendAll();

%>
</body>
</html>
