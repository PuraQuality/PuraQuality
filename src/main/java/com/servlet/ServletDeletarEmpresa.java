package com.servlet;

import java.io.*;

import com.dao.EmpresaDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.dao.FuncionarioDao;

@WebServlet("/servletDeletarEmpresa")
public class ServletDeletarEmpresa extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        Pegando o valor da requisição
        int id = Integer.parseInt(request.getParameter("idempresa"));

//        Declarando o objeto
        EmpresaDao empresaDao = new EmpresaDao();

//        Deletando do banco de dados
        empresaDao.deleteById(id);

//        Voltando para a página
        request.getRequestDispatcher("WEB-INF/views/PaginaAposLogin/puraquality.jsp").forward(request, response);
    }
}