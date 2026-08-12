
package com.uniconnect.servlets;

import com.uniconnect.tempUserStorage.tempUserStorage;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve login parameters from form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Handle null values safely and remove extra spaces
        if (username != null) username = username.trim();
        if (password != null) password = password.trim();

        // Debug logs (check GlassFish console output)
        System.out.println("Username entered: " + username);
        System.out.println("Password entered: " + password);

        // Validation of credentials (replace with DB check later)
        if (tempUserStorage.isValidUser(username, password)) {

            // Create session for authenticated user
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            // Redirect to homepage after successful login
            response.sendRedirect("homepage.jsp");

        } else {
            // Invalid login → set error message and return to login page
            request.setAttribute("error", "Invalid username or password. Please enter valid details");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}