package com.servlet;

import java.io.*;

import com.dao.EmpresaDao;
import com.model.Empresa;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.dao.FuncionarioDao;
import com.model.Funcionario;

@WebServlet("/servletInserirEmpresa")
public class ServletInserirEmpresa extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        Declarando o objeto do dao de funcionario
        EmpresaDao empresaDao = new EmpresaDao();
//        Adquirindo os valores do jsp
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone").replaceAll("[^0-9]","");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String setor =  request.getParameter("setor");
        String cnpj = request.getParameter("cnpj");
        int planoId = Integer.parseInt(request.getParameter("plano_id"));
//        Declarando o funcionário
        Empresa empresa = new Empresa(nome,setor,telefone,cnpj,email,senha,planoId);

//        Salvando o usuário
        empresaDao.save(empresa);
            request.getRequestDispatcher("WEB-INF/views/PaginaAposLogin/puraquality.jsp").forward(request, response);
    }
}
