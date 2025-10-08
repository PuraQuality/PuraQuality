package com.controller;

import java.io.*;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.repository.FuncionarioDao;
import com.model.Funcionario;

@WebServlet(name = "servletDeletarUsuario", value = "/servletDeletarUsuario")
public class ServletDeletarUsuario extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        funcionarioDao.deleteById(id);
        request.getRequestDispatcher("PaginaAposLogin/crud.jsp").forward(request, response);
    }
}