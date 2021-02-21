<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<img src="images/thanks.jpg" alt="Girl in a jacket" style="width:100%;">
 <div style="position: absolute; top: 50%;left: 50%; transform: translate(-50%, -50%);">
<h2 style="color:white;font-size: 60px;">Merci pour votre Donation </h2>
<br>
<% String email=(String)session.getAttribute("email");
              %>
<form action="SendMail">  
<input name="to" type="hidden" class="form-control" value="<%=email%>">
<button type="submit" data-toggle="tooltip" title="" style="background:#e3c652;margin-left:45%;color:white;border: none;width:100px;height:40px;font-size: 15px;margin-top:15px;cursor: pointer;">Go back</button>         
 
  </form>
  </div>
</div>
</body>
</html>