
package com.uniconnect.servlets;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;


@WebServlet("/chat")
public class ChatServlet extends HttpServlet {

    
     private static final long serialVersionUID = 1L;
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        
        
          //Make sure use is logged in 
        if(session == null || session.getAttribute("username") == null){
            response.sendRedirect("index.jsp"); // redirects user back to login if they are not logged in 
           
        }
        
        String message = request.getParameter("message");
        String user = (String) session.getAttribute("username");
        
        
        
        request.setAttribute("chatMessage", user + ": " + message);
        request.getRequestDispatcher("conversation.jsp").forward(request, response);
              
    }

}
