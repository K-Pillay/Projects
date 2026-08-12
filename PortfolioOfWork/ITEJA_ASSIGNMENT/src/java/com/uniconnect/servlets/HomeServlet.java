/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.uniconnect.servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;



@WebServlet("/homepage")
public class HomeServlet extends HttpServlet {

     private static final long serialVersionUID = 1L;
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //gets current user session without creating a new one
        HttpSession session = request.getSession(false);
        
        //Make sure use is logged in 
        if(session == null || session.getAttribute("username") == null){
            response.sendRedirect("index.jsp"); // redirects user back to login if they are not logged in 
           
        }
        
        //Forward user to homepage
        request.setAttribute("welcomeMessage",  "Hi" + session.getAttribute("username"));
        //forwards request to homepage to display messagre to user
        request.getRequestDispatcher("homepage.jsp").forward(request, response);
    }
   

}
