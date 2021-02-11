package com.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Appelaudon;
import com.bean.Projet;
import com.crud.DAOprojet;
import com.gestion.GestionDAOprojet;

public class ProjetServlet  extends HttpServlet{
	 Projet p = new Projet();
	 GestionDAOprojet gs = new GestionDAOprojet();
	 DAOprojet p_dao;
	 
	 @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	        
	    }
	    
	        @Override
	        protected void doPost(HttpServletRequest request, HttpServletResponse response)
	                throws ServletException, IOException {
	             if(request.getParameter("afficherProjet")!=null){
	                List<Projet> projetList = new ArrayList();
	                projetList = gs.AfficherProjets();
	                request.setAttribute("projetList", projetList);
	                RequestDispatcher rd = request.getRequestDispatcher("liste_projets.jsp");
	                rd.forward(request, response);
	            }
	             
	              if(request.getParameter("modifierprojet")!=null){
	                 int id_projet = Integer.parseInt(request.getParameter("id_projet"));
	                 String nom = request.getParameter("nom");
	                 Date date_lancement = null;
					try {
						date_lancement = (Date) new SimpleDateFormat("dd-MMM-yyyy").parse(request.getParameter("date_lancement"));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                 Date date_echeance = null;
					try {
						date_echeance = (Date) new SimpleDateFormat("dd-MMM-yyyy").parse(request.getParameter("date_echeance"));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					 String duree_realisation=request.getParameter("duree_realisation");
	                 Float budget = Float.parseFloat(request.getParameter("budget"));
	                 String lieu= request.getParameter("lieu");
	                 String description = request.getParameter("description");
	                 gs.modifier_Projet(id_projet, nom,date_lancement,duree_realisation,date_echeance,budget,lieu,description);                 
	                 RequestDispatcher rd = request.getRequestDispatcher("ModifierProjet.jsp");
	                 rd.forward(request, response);              
	                
	             }
	              
	             if(request.getParameter("supprimerprojet")!=null){
	                int idx = Integer.parseInt(request.getParameter("id_projet"));
	                p.setId_projet(idx);
	                gs.supprimer_Projet(p);
	                RequestDispatcher rd = request.getRequestDispatcher("SupprimerProjet.jsp");
	                rd.forward(request, response);
	             } 
	             if(request.getParameter("ajoutProjet")!=null){
	            	 try {
	                 String nom = request.getParameter("nom");
	                 Date date_lancement= (Date) new SimpleDateFormat("dd-MMM-yyyy").parse(request.getParameter("date_lancement"));
	                 String duree_realisation= request.getParameter("duree_realisation");
	                 Date date_echeance = (Date) new SimpleDateFormat("dd-MMM-yyyy").parse(request.getParameter("date_echeance"));
	                 Float budget = Float.parseFloat(request.getParameter("budget"));
	                 String lieu= request.getParameter("lieu");
	                 String description = request.getParameter("description");
	                 
	                 
	                 
	                 p.setNom(nom);
	         		 p.setDate_lancement(date_lancement);
	         		 p.setDuree_realisation(duree_realisation);
	         		 p.setDate_echeance(date_echeance);
	         		 p.setBudget(budget);
	         		 p.setLieu(lieu);
	         		 p.setDescription(description);
	                 gs.ajouter_Projet(p);
	                 RequestDispatcher rd = request.getRequestDispatcher("liste_projets.jsp");
	                 rd.forward(request, response);
	             }catch(Exception e){
	            	 
	             	}
	             }
	                          
	         }
	       


}
