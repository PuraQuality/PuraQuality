package com.servlet;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.dao.FuncionarioDao;
import com.model.Funcionario;

@WebServlet(name = "servletAlterarUsuario", value = "/servletAlterarUsuario")
public class ServletAlterarUsuario extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        Pegando a requisição da página jsp
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String telefone = request.getParameter("telefone").replaceAll("[^0-9]","");
        String email = request.getParameter("email");
        boolean prioridade = (request.getParameter("prioridade") != null || request.getParameter("prioridade").equals("true"));
        String senha = request.getParameter("nvsenha");

//        Declarando objetos
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        Funcionario funcionario = new Funcionario(id,nome,sobrenome,telefone,email,senha,prioridade);

//        Adicionando ao banco de dados
        funcionarioDao.update(funcionario);

//        Encaminhando de volta para o nosso crud
        request.getRequestDispatcher("WEB-INF/views/PaginaAposLogin/crudAdm.jsp").forward(request, response);
    }
}