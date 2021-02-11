<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier Donateur</title>
</head>


<body>
    <form action="DonateurServlet" method="POST">
            <input type="submit" name="afficherDonateur" value="Afficher la liste de voitures"> &nbsp; &nbsp;<br>          
        </form> 
    <form action="DonateurServlet" method="POST">
            
             <br>
             ID<input id="id_donateur" type="text" name="id_donateur"><br>            
             Nom<input id="nom" type="text" name="nom"><br>
            prenom<input id="prenom" type="text" name="prenom"><br>
            email<input id="email" type="text" name="email"><br>
            tel<input id="tel" type="text" name="tel"><br>
            ville<input id="ville" type="text" name="ville"><br>
            password<input id="password" type="text" name="password"><br>
           
            
             
            <button type="submit" id="modifierdonateur" name="modifierdonateur"> Modifier</button> <br> <br>
            
            
</form>
</body>

</html>