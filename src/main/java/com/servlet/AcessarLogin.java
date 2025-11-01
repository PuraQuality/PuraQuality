package com.servlet;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/login")
public class AcessarLogin extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        Servlet para encaminhar para o jsp dentro da view para a página de login
        request.getRequestDispatcher("WEB-INF/views/LoginSignUp/login.jsp").forward(request, response);
    }
}