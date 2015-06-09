<%@ page import="ge.exchangeservicegela.dao.Dao" %>
<%@ page import="ge.exchangeservicegela.beans.Location" %>
<%@ page import="java.util.ArrayList" %>
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
    padding-left:30px;
  }
  .form-control{
    width:300px;
    top:30%;
    position:relative;
    margin-left:40px;
  }
</style>
<body>
<div id="authHolder">
  <div class="form-group">
    <form role="form" action="/updateUser">
      <h1 style="margin-left:20px">გთხოვთ შეიყვანოთ ინფორმაცია</h1><br><br><br>
      <div class="form-group">
        <label for="locationHave">აირჩიეთ რომელი ლოკაცია გაქვთ</label>
        <%
          Dao dao = new Dao();
          ArrayList<Location> locations = dao.getLocations();
        %>
        <select class="form-control" id="locationHave">
          <%
            for(Location loc:locations){
              out.println("<option value="+loc.getLocationID()+">"+loc.getStartDate()+" " + loc.getLocationName()+"</option>");
            }
          %>
        </select>
      </div>
      <div class="form-group">
        <label for="locationWANT">აირჩიე რომელი ლოკაცია გინდა:</label>
        <select class="form-control" id="locationWANT">
          <%
            for(Location loc:locations){
              out.println("<option value="+loc.getLocationID()+">"+loc.getStartDate()+" " + loc.getLocationName()+"</option>");
            }
          %>
        </select>
      </div>
      <button type="submit" style="margin-left:200px;" class="btn btn-success btn-lg">შეინახე</button>
    </form>
    <form>
      <button type="submit" style="margin-left:200px;" class="btn btn-danger btn-lg">აღარ მინდა გაცვლა</button>
    </form>
  </div>
</body>
</html>