package com.controller;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.repository.FuncionarioDao;
import com.model.Funcionario;

@WebServlet(name = "servletCadastro", value = "/servletCadastro")
public class ServletCadastro extends HttpServlet {
    private String message;

    public void init() {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        FuncionarioDao usuarioDao = new FuncionarioDao();
        Funcionario usuario = new Funcionario(email,senha,1,true);
        if(usuarioDao.save(usuario)) {
            request.getRequestDispatcher("LoginSignUp/login.jsp").forward(request, response);
        }
        else{
            request.getRequestDispatcher("LoginSignUp/signup.jsp").forward(request, response);
        }
    }

    public void destroy() {
    }
}
