package com.servlet;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.dao.FuncionarioDao;

@WebServlet(name = "servletDeletarUsuario", value = "/servletDeletarUsuario")
public class ServletDeletarUsuario extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        Adquirindo o valor das requisições do jsp
        int id = Integer.parseInt(request.getParameter("id"));
        String email = request.getParameter("email");
        String emailFuncionario = (String) request.getSession().getAttribute("emailfuncionario");

//        Declarando o dao do funcionario
        FuncionarioDao funcionarioDao = new FuncionarioDao();

//        Validando para o funcionário não poder se deletar
        if(!email.equals(emailFuncionario)||!((String)request.getParameter("empresa")).equals("sim")) {
            funcionarioDao.deleteById(id);
        }

//        Validando para encaminhar para a pagina correta
        if(((String)request.getParameter("empresa")).equals("sim")) {
            request.getRequestDispatcher("WEB-INF/views/PaginaAposLogin/crudAdm.jsp").forward(request, response);
        }
        else {
            request.getRequestDispatcher("WEB-INF/views/PaginaAposLogin/crudEmpresa.jsp").forward(request, response);
        }
    }
}