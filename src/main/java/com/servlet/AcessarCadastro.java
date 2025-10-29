package com.servlet;

import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/servcadastro")
public class AcessarCadastro extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // servlet que leva para a página de cadastro
            request.getRequestDispatcher("WEB-INF/views/LoginSignUp/signup.jsp").forward(request, response);
        } catch (Exception e) {
            // printa o erro no terminal
            e.printStackTrace();
            // encaminha para a página de erro com a mensagem de erro
            request.setAttribute("errorMessage", "Ocorreu um erro inesperado: " + e.getMessage());
            request.getRequestDispatcher("WEB-INF/views/Erro/error.jsp").forward(request, response);
        }
    }
}