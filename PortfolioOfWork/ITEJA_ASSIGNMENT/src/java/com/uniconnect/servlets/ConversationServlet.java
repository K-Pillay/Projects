
package com.uniconnect.servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/conversations")
public class ConversationServlet extends HttpServlet{
    
    private static final long serialVersionUID = 1L;
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        HttpSession session = request.getSession(false);
        
         //Make sure use is logged in 
        if(session == null || session.getAttribute("username") == null){
            response.sendRedirect("index.jsp"); // redirects user back to login if they are not logged in 
           
        }
        
        //redirects user to the homepage
        request.getRequestDispatcher("conversations.jsp").forward(request, response);
        
    }

}
