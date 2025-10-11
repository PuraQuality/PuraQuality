package com.controller;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.repository.FuncionarioDao;

@WebServlet(name = "servletDeletarUsuario", value = "/servletDeletarUsuario")
public class ServletDeletarUsuario extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String email = request.getParameter("email");
        String emailFuncionario = (String) request.getSession().getAttribute("emailfuncionario");
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        if(!email.equals(emailFuncionario)) {
            funcionarioDao.deleteById(id);
        }
        if(((String)request.getParameter("empresa")).equals("sim")) {
            request.getRequestDispatcher("PaginaAposLogin/empresa.jsp").forward(request, response);
        }
        request.getRequestDispatcher("PaginaAposLogin/crud.jsp").forward(request, response);
    }
}