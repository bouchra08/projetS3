<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
 
 
 <h3>Liste de Donateur version 3:</h3> <br> 

    <c:forEach items="${donateurList}" var="d">
     ID de la voiture: ${d.id_donateur} <br>    
     Nom  : ${d.nom} <br>
     prenom: ${d.prenom} <br>
     email: ${d.email} <br>
     tel: ${d.tel} <br>
     ville: ${d.ville} <br>
     password: ${d.password} <br>
     <br>  <br>
    </c:forEach>
    
    
<a href="AjoutDonateur.jsp">Ajouter une autre?</a>


</body>
</html>