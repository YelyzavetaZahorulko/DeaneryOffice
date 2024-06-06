package com.example.deaneryoffice;

import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.util.logging.*;

@WebServlet("/auth")
public class LoginServlet extends HttpServlet {
    private static final String EMPLOYEE_PASSWORD = "admin123"; // Static admin password

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userType = request.getParameter("userType");

        if ("student".equals(userType)) {
            response.sendRedirect("search.jsp");
        } else if ("employee".equals(userType)) {
            String password = request.getParameter("password");
            if (password.equals(EMPLOYEE_PASSWORD)) {
                response.sendRedirect("editGroups.jsp");
            } else {
                response.sendRedirect("index.jsp?error=incorrect_password");
            }
        }
    }
}
