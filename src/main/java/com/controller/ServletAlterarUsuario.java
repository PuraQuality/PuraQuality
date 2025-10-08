package com.controller;

import java.io.*;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.repository.FuncionarioDao;
import com.model.Funcionario;

@WebServlet(name = "servletAlterarUsuario", value = "/servletAlterarUsuario")
public class ServletAlterarUsuario extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        boolean prioridade = (request.getParameter("prioridade") != null);
        System.out.println(request.getParameter("prioridade"));

        System.out.println("Prioridade: " + prioridade);

        FuncionarioDao funcionarioDao = new FuncionarioDao();
        List<Funcionario> usuario = funcionarioDao.select();
        int posicao = -1;

        for (int i = 0; i < usuario.size(); i++) {
            if(usuario.get(i).getEmail().equals(email)){
                 posicao = i;
                break;
            }
        }

        String senha = usuario.get(posicao).getSenha();
        int id = usuario.get(posicao).getId();
        Funcionario funcionario = new Funcionario(id,email,senha,prioridade);

        funcionarioDao.update(funcionario);
        request.getRequestDispatcher("PaginaAposLogin/crud.jsp").forward(request, response);
    }
}