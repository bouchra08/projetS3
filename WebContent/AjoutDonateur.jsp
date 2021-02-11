<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="Ajouter">
        <h1> Ajouter un donateur </h1>
        <form action="DonateurServlet" method="POST">
            <table>
                <tr>
                    <td> Nom de donateur: </td>
                    <td><input type="text" name="nom"></td>
                </tr>
                <tr>
                    <td> prenom de donateur: </td>
                    <td><input type="text" name="prenom"></td>
                </tr>
                <tr>
                    <td> prenom de donateur: </td>
                    <td><input type="text" name="email"></td>
                </tr>
                <tr>
                    <td> prenom de donateur: </td>
                    <td><input type="text" name="tel"></td>
                </tr>
                <tr>
                    <td> prenom de donateur: </td>
                    <td><input type="text" name="ville"></td>
                </tr>
                <tr>
                    <td> prenom de donateur: </td>
                    <td><input type="text" name="password"></td>
                </tr>
                <tr>
                    <td><input type="submit" name="ajoutDonateur" value="Ajouter"></td>
                    
                </tr>
            </table>
        </form>
        </div>
        
        
        <form action="DonateurServlet" method="POST">
            <input type="submit" name="afficherDonateur" value="Afficher"> &nbsp; &nbsp;<br>          
        </form>
         <form action="DonappelServlet" method="POST">
            <input type="submit" name="afficherDonappel" value="Afficher"> &nbsp; &nbsp;<br>          
        </form>
         </form>
         <form action="ProjetServlet" method="POST">
            <input type="submit" name="afficherProjet" value="AfficherProjet"> &nbsp; &nbsp;<br>          
        </form>
        
<a href="Ajoutdonateur.jsp">Ajouter une autre?</a>
 <h3>Liste des Donateurs:</h3> <br> 

   <%-- <c:forEach items="${donateurList}" var="d">
     ID : ${d.id_donateur} <br>    
     Nom  : ${d.nom} <br>
     prenom: ${d.prenom} <br>
     email: ${d.email} <br>
     tel: ${d.tel} <br>
     ville: ${d.ville} <br>
     password: ${d.password} <br>
     
      <br>  <br>
    </c:forEach>  --%>
    
    
</body>
</html>