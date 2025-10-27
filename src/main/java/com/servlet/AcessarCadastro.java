package com.servlet;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/servcadastro")
public class AcessarCadastro extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        Servlet para encaminhar para o jsp dentro da view para a página de cadastro
        request.getRequestDispatcher("WEB-INF/views/LoginSignUp/signup.jsp").forward(request, response);    }
}