package com.servlet;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.dao.FuncionarioDao;
import com.model.Funcionario;

@WebServlet("/servletAlterarEmpresa")
public class ServletAlterarEmpresa extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String email = request.getParameter("email");
        boolean prioridade = (request.getParameter("prioridade") != null);
        String senha = request.getParameter("senha");

        FuncionarioDao funcionarioDao = new FuncionarioDao();
        Funcionario funcionario = new Funcionario(id,email,senha,prioridade);
        funcionarioDao.update(funcionario);
        request.getRequestDispatcher("WEB-INF/views/PaginaAposLogin/pu.jsp").forward(request, response);
    }
}