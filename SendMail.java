package com.controller;

import java.io.IOException;  
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import com.bean.Mailer;

public class SendMail extends HttpServlet{
	public void doGet(HttpServletRequest request,  
			 HttpServletResponse response)  
			    throws ServletException, IOException {  
			  
			    
			   
			      
			    String to=request.getParameter("to");  
			    String subject="Confirmation de la donation";  
			    String msg="I-care vous remercie d'avoir utilisé notre plateform, et vous annonce que votre don a été bien effectué";  
			          
			    Mailer.send(to, subject, msg);  
			    RequestDispatcher rd =request.getRequestDispatcher("home.jsp");
			    rd.forward(request, response);
			      
			    }  

}
