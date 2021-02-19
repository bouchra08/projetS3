<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="position:center">
<h2>Merci pour votre Donation Cliquer ici pour recevroir une confirmation</h2>
<% String email=(String)session.getAttribute("email");
              %>
<form action="SendMail">  
<input name="to" type="hidden" class="form-control" value="<%=email%>">
<input type="submit" value="Recevoir une confirmation"/>  
  </form>
</div>
</body>
</html>