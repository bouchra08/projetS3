
package com.controller;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Donateur;
import com.crud.DAO;
import com.gestion.GestionDAO;

public class DonateurServlet extends HttpServlet{
	 Donateur d = new Donateur();
     GestionDAO gs = new GestionDAO();
     DAO d_dao;
     
     
     
     
     @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
         
     }
     
         @Override
         protected void doPost(HttpServletRequest request, HttpServletResponse response)
                 throws ServletException, IOException {
              if(request.getParameter("afficherDonateur")!=null){
                 List<Donateur> donateurList = new ArrayList();
                 donateurList = gs.AfficherDonateurs();
                 request.setAttribute("donateurList", donateurList);
                 RequestDispatcher rd = request.getRequestDispatcher("liste_donateurs.jsp");
                 rd.forward(request, response);
             }
              
               if(request.getParameter("modifierdonateur")!=null){
                  int id_donateur = Integer.parseInt(request.getParameter("id_donateur"));
                  String nom = request.getParameter("nom");
                  String prenom= request.getParameter("prenom");
                  String email = request.getParameter("email");
                  String tel = request.getParameter("tel");
                  String ville= request.getParameter("ville");
                  String password = request.getParameter("password");
                  gs.modifier_Donateur(id_donateur, nom,prenom,email,tel,ville,password);                 
                  RequestDispatcher rd = request.getRequestDispatcher("ModifierDonateur.jsp");
                  rd.forward(request, response);                    
              }
               
              if(request.getParameter("supprimerdonateur")!=null){
                 int idx = Integer.parseInt(request.getParameter("id_donateur"));
                 d.setId_donateur(idx);
                 gs.supprimer_Donateur(d);
                 RequestDispatcher rd = request.getRequestDispatcher("SupprimerDonateur.jsp");
                 rd.forward(request, response);
              } 
              if(request.getParameter("ajoutDonateur")!=null){
             	 try {
                  String nom = request.getParameter("nom");
                  
                  String prenom= request.getParameter("prenom");
                  String email = request.getParameter("email");
                  String tel = request.getParameter("tel");
                  String ville= request.getParameter("ville");
                  String password = request.getParameter("password");
                  
                  
                  d.setNom(nom);
                  d.setPrenom(prenom);
                  d.setEmail(email);
                  d.setTel(tel);
                  d.setVille(ville);
                  d.setPassword(password);
                  gs.ajouter_Donateur(d);
                  RequestDispatcher rd = request.getRequestDispatcher("AfficherDonateurs.jsp");
                  rd.forward(request, response);
              }catch(Exception e){
             	 
              	}
              }
              if(request.getParameter("logindonateur")!=null){
             	 
             	 String username = request.getParameter("email");
             	 String password = request.getParameter("password");

             	 if (gs.validate(username, password)) {
             		 
             		 RequestDispatcher dispatcher = request.getRequestDispatcher("AjoutDonateur.jsp");
             		 dispatcher.forward(request, response);
             	 } else {
             		 System.out.print("errore somewhere");
             		RequestDispatcher dispatcher = request.getRequestDispatcher("login_don.jsp");
            		 dispatcher.forward(request, response);
             		 
             		  }
               }
                           
          }
         
}
