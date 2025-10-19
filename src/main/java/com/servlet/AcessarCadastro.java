package com.servlet;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.dao.FuncionarioDao;
import com.model.Funcionario;

@WebServlet("/servcadastro")
public class AcessarCadastro extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/LoginSignUp/cadastro.jsp").forward(request, response);
    }
}