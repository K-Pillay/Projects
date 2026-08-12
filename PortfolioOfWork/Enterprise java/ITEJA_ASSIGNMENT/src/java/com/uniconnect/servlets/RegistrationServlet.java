/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.uniconnect.servlets;

import com.uniconnect.tempUserStorage.tempUserStorage;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {

    private static long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //get user data from registration form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        
        tempUserStorage.addNewUser(username, password);
        

        //redirects user to login form after successful registration
        response.sendRedirect("index.jsp");
    }

}
