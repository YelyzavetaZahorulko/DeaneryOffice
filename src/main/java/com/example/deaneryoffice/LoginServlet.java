package com.example.deaneryoffice;

import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/auth")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("login".equals(action)) {
            String name = request.getParameter("name");
            String password = request.getParameter("password");

            // Тут має бути ваша логіка перевірки імені користувача та пароля
            // Наприклад, перевірка з базою даних

            response.sendRedirect("registration-success.jsp"); // Перенаправлення на головну сторінку

        } else if ("register".equals(action)) {
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            String email = request.getParameter("email");

            request.setAttribute("name", name);
            request.setAttribute("email", email);

            // Перенаправлення на сторінку успіху
            request.getRequestDispatcher("/registration-success.jsp").forward(request, response);
            // Логіка реєстрації
            // Збір даних з форми реєстрації
            // Тут має бути ваша логіка збереження даних користувача

            // Після реєстрації можна перенаправити користувача на сторінку входу або на головну сторінку
            // response.sendRedirect("login.jsp"); // Перенаправлення на сторінку входу
        }
//        else {
//            response.sendRedirect("error.jsp"); // Перенаправлення на сторінку помилки
//        }
    }
}
