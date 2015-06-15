<%@ page import="ge.exchangeservicegela.beans.User" %>
<%--
  Created by IntelliJ IDEA.
  User: Ratmach
  Date: 9/6/15
  Time: 23:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script src="http://code.jquery.com/jquery-2.1.4.min.js"> </script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<%
  User user = (User) session.getAttribute("user");
  if(user!=null){
      String redirectURL = "preferences.jsp";
      response.sendRedirect(redirectURL);
  }
%>
<head>
  <title>თავისუფალი და აგრარული უნივერსიტეტის საველე პრაქტიკის გაცვლები</title>
</head>
<style>
  body{
    background:url("bg.jpg") no-repeat;
  }
  #authHolder{
    width:960px;
    height:100%;
    display: table;
    left:50%;
    margin:0 0 0 -480px;
    position:absolute;
    border:1px solid black;
    text-align: center;
    background-color:white;
  }
  #authHolder .btn{
    margin-right:2px;
  }
</style>
<body>
<div id="authHolder">
  <img src="http://blog.leaf.ge/uploads/account/d1de932af66e610e16138450998b6973/files/%E1%83%97%E1%83%90%E1%83%95%E1%83%98%E1%83%A1%E1%83%A3%E1%83%A4%E1%83%90%E1%83%9A%E1%83%98%20%E1%83%A3%E1%83%9C%E1%83%98%E1%83%95%E1%83%94%E1%83%A0%E1%83%98%E1%83%A2%E1%83%94%E1%83%A2%E1%83%98/freeunii.jpg"><br><br><br><br><br><br>
  <h2> გამარჯობა თანაუნივერსიტეტელო ^_^ </h2>

  <div class="btn-group" role="group" aria-label="">
    <a href="registration.jsp"><button type="button" class="btn btn-danger btn-lg">რეგისტრაცია</button></a>
    <a href="authorisation.html"><button type="button" class="btn btn-danger btn-lg">ავტორიზაცია</button></a>
    <a href="in.html">
      <button type="button" class="btn btn-danger btn-lg">დახმარება</button>
    </a>

  </div>
</div>
</body>
</html>