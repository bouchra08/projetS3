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
                RequestDispatcher rd = request.getRequestDispatcher("liste_appel_au_dons.jsp");
                rd.forward(request, response);
            }
             if(request.getParameter("afficherUnAppelaudon")!=null){
            	 int id = Integer.parseInt(request.getParameter("id_appel"));
                 List<Appelaudon> appelaudonList = new ArrayList();
                 appelaudonList = gs.AfficherAppelaudon(id);
                 request.setAttribute("appelaudonList", appelaudonList);
                 RequestDispatcher rd = request.getRequestDispatcher("modifier_appeldon.jsp");
                 rd.forward(request, response);
             }
             
              if(request.getParameter("modifierappelaudon")!=null){
                 int id_appel = Integer.parseInt(request.getParameter("id_appel"));
                 String nom = request.getParameter("nom");
                 String  date_lancement =request.getParameter("date_lancement");
                 String  date_echeance =request.getParameter("date_echeance");
                 Float budget = Float.parseFloat(request.getParameter("budget"));
                 String lieu= request.getParameter("lieu");
                 String description = request.getParameter("description");
                 gs.modifier_Appelaudon(id_appel, nom,date_lancement, date_echeance,budget,lieu,description);
                 List<Appelaudon> appelaudonList = new ArrayList();
                 appelaudonList = gs.AfficherAppelaudons();
                 request.setAttribute("appelaudonList", appelaudonList);
                 RequestDispatcher rd = request.getRequestDispatcher("liste_appel_au_dons.jsp");
                 rd.forward(request, response);              
                
             }
              
             if(request.getParameter("supprimerappelaudon")!=null){
                int idx = Integer.parseInt(request.getParameter("id_appel"));
                ap.setId_appel(idx);
                gs.supprimer_Appelaudon(ap);
                List<Appelaudon> appelaudonList = new ArrayList();
                appelaudonList = gs.AfficherAppelaudons();
                request.setAttribute("appelaudonList", appelaudonList);
                RequestDispatcher rd = request.getRequestDispatcher("liste_appel_au_dons.jsp");
                rd.forward(request, response);
             } 
             if(request.getParameter("ajoutAppelaudon")!=null){
            	 try {
                 String nom = request.getParameter("nom");
                 String date_lancement= request.getParameter("date_lancement");
                 String date_echeance = request.getParameter("date_echeance");
                 Float budget = Float.parseFloat(request.getParameter("budget"));
                 String lieu= request.getParameter("lieu");
                 String description = request.getParameter("description");
                 int id_asso = Integer.parseInt(request.getParameter("id_asso"));
                 
                 
                 
                 ap.setNom(nom);
                 ap.setDate_lancement(date_lancement);
                 ap.setDate_echeance( date_echeance );
                 ap.setBudget(budget);
                 ap.setLieu(lieu);
                 ap.setDescription(description);
                 ap.setId_asso(id_asso);
                 gs.ajouter_Appelaudon(ap);
                 List<Appelaudon> appelaudonList = new ArrayList();
                 appelaudonList = gs.AfficherAppelaudons();
                 request.setAttribute("appelaudonList", appelaudonList);
                 RequestDispatcher rd = request.getRequestDispatcher("liste_appel_au_dons.jsp");
                 rd.forward(request, response);
             }catch(Exception e){
            	 System.out.print(e);
             	}
             }
                          
         }
       

}
