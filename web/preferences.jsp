<%@ page import="ge.exchangeservicegela.beans.Location" %>
<%@ page import="ge.exchangeservicegela.beans.User" %>
<%@ page import="ge.exchangeservicegela.dao.Dao" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: Ratmach
  Date: 9/6/15
  Time: 23:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  User user = (User) session.getAttribute("user");
  if(user==null){
    String redirectURL = "index.jsp";
    response.sendRedirect(redirectURL);
  }
%>
<html>

<script src="http://code.jquery.com/jquery-2.1.4.min.js"> </script>
<link rel="stylesheet" href="http://cdn.datatables.net/plug-ins/1.10.7/integration/bootstrap/3/dataTables.bootstrap.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.7/css/jquery.dataTables.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="https://cdn.datatables.net/1.10.7/js/jquery.dataTables.min.js"> </script>

<head>
  <title>თავისუფალი და აგრარული უნივერსიტეტის საველე პრაქტიკის გაცვლები</title>
</head>
<style>
  body{
    background:url("bg.jpg") no-repeat;
  }
  div#authHolder{
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
  <a href="user.jsp"><button style="float:right" class="btn btn-lg btn-success">ცვლილებების შეტანა</button></a><br><br><br>
  <% User us = (User) session.getAttribute("user");
    out.println(us.getFirstName() + " " + us.getLastName());
    if (us.isConfirmed()) out.println("Is  confirmed");
    else out.println("Is NOT confirmed");
    if (us.isSatisfied()) out.println("ძიებისას სხვები ვეღარ დაგინახავენ");
    out.println("<br><b>გამაცვლევინეთ ცაგერი 1 ბორჯომ 1ში და მიიღეთ საჩურად 20 ლარი 557105511</b>");
  %>
  <table id="dataTable" class="display" cellspacing="0" width="100%">
    <thead>
    <tr>
      <th>სახელი</th>
      <th>გვარი</th>
      <th>ელ. ფოსტა</th>
      <th>ტელეფონის ნომერი</th>
      <th>ნაკადი</th>
      <th>ლოკაცია</th>
    </tr>
    </thead>

    <tbody>
      <%
        Dao dao = new Dao();
        ArrayList<User> usr = dao.getMewyvile(((User)session.getAttribute("user")).getUserID());
        ArrayList<Location> loc = dao.getLocations();
        for(User u : usr){
          out.println("<tr>");
          out.println("<td>"+u.getFirstName()+"</td>");
          out.println("<td>"+u.getLastName()+"</td>");
          out.println("<td>"+u.getEmail()+"</td>");
          out.println("<td>"+u.getPhoneNumber()+"</td>");
          for(Location l : loc){
            if(l.getLocationID()==u.getLocationID()) {
              out.println("<td>" + l.getStartDate() + "</td>");
              out.println("<td>" + l.getLocationName() + "</td>");

            }
          }
          out.println("</tr>");
        }
      %>
    </tbody>
  </table>
</div>
</body>
</html>
