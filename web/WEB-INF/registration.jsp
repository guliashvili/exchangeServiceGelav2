<%--
  Created by IntelliJ IDEA.
  User: Ratmach
  Date: 10/6/15
  Time: 01:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script src="http://code.jquery.com/jquery-2.1.4.min.js"> </script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

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
    background-color:white;
  }
  .form-control{
    width:300px;
    top:30%;
    position:relative;
    margin-left:40px;
  }
  label{
    margin-left:40px;
  }
  button{
    margin-left:300px;
  }
</style>
<body>
<div id="authHolder">
  <div class="form-group">
    <form role="form">
      <h1 style="margin-left:30px">გთხოვთ შეიყვანოთ ინფორმაცია</h1><br><br><br>
      <label for="email">ელექტრონული ფოსტის მისამართი</label>
      <input type="email" class="form-control" id="email" placeholder="ელექტრონული ფოსტის მისამართი" required></input>
      <label for="password">თქვენი პაროლი:</label>
      <input type="passWord" class="form-control" id="password" placeholder="თქვენი პაროლი" required></input>
      <label for="firstName">თქვენი სახელი:</label>
      <input type="text" class="form-control" id="firstName" placeholder="თქვენი სახელი" required></input>
      <label for="lastName">თქვენი გვარი:</label>
      <input type="text" class="form-control" id="lastName" placeholder="თქვენი გვარი" required></input>
      <label for="phoneNumber">თქვენი ტელეფონის ნომერი:</label>
      <input type="text" class="form-control" id="phoneNumber" placeholder="თქვენი ტელეფონის ნომერი" required> </input><br><br><br>
      <button type="submit" class="btn btn-success btn-lg">რეგისტრაცია</button>
  </div>
  </form>
</div>
</body>
</html>