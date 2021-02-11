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
import com.bean.Donateur;
import com.crud.DAOappel;
import com.gestion.GestionDAOappel;

public class AppelaudonServlet extends HttpServlet{
	Appelaudon ap = new Appelaudon();
    GestionDAOappel gs = new GestionDAOappel();
    DAOappel ap_dao;
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
    }
    
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
             if(request.getParameter("afficherAppelaudon")!=null){
                List<Appelaudon> appelaudonList = new ArrayList();
                appelaudonList = gs.AfficherAppelaudons();
                request.setAttribute("appelaudonList", appelaudonList);
                RequestDispatcher rd = request.getRequestDispatcher("liste_dons.jsp");
                rd.forward(request, response);
            }
             
              if(request.getParameter("modifierappelaudon")!=null){
                 int id_appel = Integer.parseInt(request.getParameter("id_appel"));
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
                 Float budget = Float.parseFloat(request.getParameter("budget"));
                 String lieu= request.getParameter("lieu");
                 String description = request.getParameter("description");
                 gs.modifier_Appelaudon(id_appel, nom,date_lancement,date_echeance,budget,lieu,description);                 
                 RequestDispatcher rd = request.getRequestDispatcher("ModifierAppelaudon.jsp");
                 rd.forward(request, response);              
                
             }
              
             if(request.getParameter("supprimerappelaudon")!=null){
                int idx = Integer.parseInt(request.getParameter("id_appel"));
                ap.setId_appel(idx);
                gs.supprimer_Appelaudon(ap);
                RequestDispatcher rd = request.getRequestDispatcher("SupprimerAppelaudon.jsp");
                rd.forward(request, response);
             } 
             if(request.getParameter("ajoutAppelaudon")!=null){
            	 try {
                 String nom = request.getParameter("nom");
                 Date date_lancement= (Date) new SimpleDateFormat("dd-MMM-yyyy").parse(request.getParameter("date_lancement"));
                 Date date_echeance = (Date) new SimpleDateFormat("dd-MMM-yyyy").parse(request.getParameter("date_echeance"));
                 Float budget = Float.parseFloat(request.getParameter("budget"));
                 String lieu= request.getParameter("lieu");
                 String description = request.getParameter("description");
                 
                 
                 
                 ap.setNom(nom);
                 ap.setDate_lancement(date_lancement);
                 ap.setDate_echeance( date_echeance );
                 ap.setBudget(budget);
                 ap.setLieu(lieu);
                 ap.setDescription(description);
                 gs.ajouter_Appelaudon(ap);
                 RequestDispatcher rd = request.getRequestDispatcher("liste_dons.jsp");
                 rd.forward(request, response);
             }catch(Exception e){
            	 
             	}
             }
                          
         }
       

}
