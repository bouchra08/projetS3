package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Association;
import com.bean.Assofavorites;
import com.crud.Daoassofavorites;
import com.gestion.GestionDAOfavo;

public class AssofavoritesServlet extends HttpServlet{
	Assofavorites af = new Assofavorites();
    GestionDAOfavo gs = new GestionDAOfavo();
    Daoassofavorites af_dao;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         if(request.getParameter("afficherAssofavo")!=null){
        	 int id_donateur = Integer.parseInt(request.getParameter("id_donateur"));
            List<Assofavorites> assofavoList = new ArrayList();
            assofavoList = gs.AfficherAssofavorites(id_donateur);
            request.setAttribute("assofavoList",assofavoList);
            RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
            rd.forward(request, response);
        }
        
         if(request.getParameter("ajoutAssofavo")!=null){
        	 try {
        	 int id_asso = Integer.parseInt(request.getParameter("id_asso"));
        	 int id_donateur = Integer.parseInt(request.getParameter("id_donateur"));
             af.setId_asso(id_asso);
             af.setId_donateur(id_donateur );
             
             gs.ajouter_Assofavorites(af);
             RequestDispatcher rd = request.getRequestDispatcher("AfficherDonateurs.jsp");
             rd.forward(request, response);
         }catch(Exception e){
        	 System.out.print(e);
         	}
         }
         
                      
     }

}
