package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Association;
import com.bean.Donateur;
import com.crud.DAOassociation;
import com.gestion.GestionDAOasso;

public class AssociationServlet extends HttpServlet{
	
	Association a = new Association();
    GestionDAOasso gs = new GestionDAOasso();
    DAOassociation a_dao;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         if(request.getParameter("afficherAssociation")!=null){
            List<Association> associationList = new ArrayList();
            associationList = gs.AfficherAssociations();
            request.setAttribute("associationList",associationList);
            RequestDispatcher rd = request.getRequestDispatcher("liste_associations.jsp");
            rd.forward(request, response);
        }
        
         if(request.getParameter("ajoutAssociation")!=null){
        	 try {
             String nom = request.getParameter("nom");
             String tel = request.getParameter("tel");
             String email = request.getParameter("email");
             String adresse= request.getParameter("adresse");
             String ville= request.getParameter("ville");
             String description= request.getParameter("description");
             String password = request.getParameter("password");
             
             
             a.setNom(nom);
             a.setTel(tel);
             a.setEmail(email);
             a.setAdresse(adresse);
             a.setVille(ville);
             a.setPassword(password);
             gs.ajouter_Association(a);
             RequestDispatcher rd = request.getRequestDispatcher("AfficherDonateurs.jsp");
             rd.forward(request, response);
         }catch(Exception e){
        	 
         	}
         }
                      
     }
    
}
