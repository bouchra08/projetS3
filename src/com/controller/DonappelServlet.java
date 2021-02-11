package com.controller;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Donappel;
import com.crud.DAOdonappel;
import com.gestion.GestionDAOdon;
public class DonappelServlet extends HttpServlet{
	Donappel dp = new Donappel();
    GestionDAOdon gs = new GestionDAOdon();
    DAOdonappel d_dao;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         if(request.getParameter("afficherDonappel")!=null){
        	 try {
        		 List<Donappel> donappelList = new ArrayList();
                 donappelList = gs.AfficherDonappels();
                 request.setAttribute("donappelList", donappelList);
                 RequestDispatcher rd = request.getRequestDispatcher("liste_dons.jsp");
                 rd.forward(request, response); 
        	 }catch(Exception e){
        		System.out.print("errr");
        	 }
            
        }
         
                      
     }

}
