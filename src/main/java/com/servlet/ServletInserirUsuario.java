package com.servlet;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.dao.FuncionarioDao;
import com.model.Funcionario;

@WebServlet(name = "servletInserirUsuario", value = "/servletInserirUsuario")
public class ServletInserirUsuario extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        Declarando o objeto do dao de funcionario
        FuncionarioDao funcionarioDao = new FuncionarioDao();

//        Adquirindo os valores do jsp
        int empresaid = (int) request.getSession().getAttribute("empresaid");
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String telefone = request.getParameter("telefone");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        boolean permissao = request.getParameter("permissao") != null && !request.getParameter("permissao").equals("1");

//        Declarando o funcionário
        Funcionario funcionario = new Funcionario(nome,sobrenome,telefone,email,senha,empresaid,permissao);

//        Salvando o usuário
        funcionarioDao.save(funcionario);
        if (request.getParameter("empresa").equals("sim")){
            request.getRequestDispatcher("WEB-INF/views/PaginaAposLogin/crudAdm.jsp").forward(request, response);
        }
        else {
            request.getRequestDispatcher("WEB-INF/views/PaginaAposLogin/crudRH.jsp").forward(request, response);
        }
    }
}
