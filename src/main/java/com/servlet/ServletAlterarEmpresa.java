package com.servlet;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.dao.EmpresaDao;
import com.model.Empresa;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.dao.FuncionarioDao;
import com.model.Funcionario;

@WebServlet("/servletAlterarEmpresa")
public class ServletAlterarEmpresa extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        Pegando a requisição da página jsp
        int id = Integer.parseInt(request.getParameter("empId"));
        int planoId = Integer.parseInt(request.getParameter("altplano"));

//        Declarando objetos
        EmpresaDao empresaDao = new EmpresaDao();
        List<Empresa> empresas = empresaDao.selectEmpresa(id);
        Empresa empresa = new Empresa(empresas.get(0).getId(),empresas.get(0).getNome(),empresas.get(0).getSetor(),empresas.get(0).getCnpj(),empresas.get(0).getEmail(),empresas.get(0).getSenha(),planoId);

//        Adicionando ao banco de dados
        empresaDao.update(empresa);

//        Encaminhando de volta para o nosso crud
        request.getRequestDispatcher("WEB-INF/views/PaginaAposLogin/puraquality.jsp").forward(request, response);
    }
}