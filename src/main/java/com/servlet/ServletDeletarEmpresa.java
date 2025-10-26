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
        EmpresaDao empresaDao = new EmpresaDao();
        int id = Integer.parseInt(request.getParameter("idempresa"));
        empresaDao.deleteById(id);
        request.getRequestDispatcher("WEB-INF/views/PaginaAposLogin/puraquality.jsp").forward(request, response);
    }
}