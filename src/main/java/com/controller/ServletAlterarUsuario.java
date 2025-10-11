package com.controller;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.repository.FuncionarioDao;
import com.model.Funcionario;

@WebServlet(name = "servletAlterarUsuario", value = "/servletAlterarUsuario")
public class ServletAlterarUsuario extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String email = request.getParameter("email");
        boolean prioridade = (request.getParameter("prioridade") != null);
        String senha = request.getParameter("senha");

        FuncionarioDao funcionarioDao = new FuncionarioDao();
        Funcionario funcionario = new Funcionario(id,email,senha,prioridade);
        funcionarioDao.update(funcionario);
        request.getRequestDispatcher("PaginaAposLogin/empresa.jsp").forward(request, response);
    }
}