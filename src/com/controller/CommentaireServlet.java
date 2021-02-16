package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Assofavorites;
import com.bean.Commentaire;
import com.crud.DAOcom;
import com.gestion.GestionDAOcom;

public class CommentaireServlet extends HttpServlet{
	Commentaire c = new Commentaire();
    GestionDAOcom gs = new GestionDAOcom();
    DAOcom c_dao;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         if(request.getParameter("afficherCommentaire")!=null){
        	 int id_asso = Integer.parseInt(request.getParameter("id_asso"));
            List<Commentaire> commentaireList= new ArrayList();
            commentaireList= gs.AfficherCommentaire(id_asso);
            request.setAttribute("commentaireList",commentaireList);
            RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
            rd.forward(request, response);
        }
        
         if(request.getParameter("ajoutCommentaire")!=null){
        	 try {
        	 int id_asso = Integer.parseInt(request.getParameter("id_asso"));
        	 int id_donateur = Integer.parseInt(request.getParameter("id_donateur"));
        	 String description= request.getParameter("description");
        	 
             c.setId_asso(id_asso);
             c.setId_donateur(id_donateur );
             c.setDescription(description);
             
             gs.ajouter_Commentaire(c);
             RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
             rd.forward(request, response);
         }catch(Exception e){
        	 System.out.print(e);
         	}
         }
         
                      
     }

    

}
