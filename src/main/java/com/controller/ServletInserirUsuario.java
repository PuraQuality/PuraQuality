package com.controller;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.repository.FuncionarioDao;
import com.model.Funcionario;

@WebServlet(name = "servletInserirUsuario", value = "/servletInserirUsuario")
public class ServletInserirUsuario extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        FuncionarioDao funcionarioDao = new FuncionarioDao();

        int empresaid = (int) request.getSession().getAttribute("empresaid");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        boolean permissao = request.getParameter("permissao") != null && !request.getParameter("permissao").equals("1");

        Funcionario funcionario = new Funcionario(email,senha,empresaid,permissao);
        funcionarioDao.save(funcionario);
        if (request.getParameter("empresa").equals("sim")){
            request.getRequestDispatcher("PaginaAposLogin/empresa.jsp").forward(request, response);
        }
        request.getRequestDispatcher("PaginaAposLogin/crud.jsp").forward(request, response);

    }
}
