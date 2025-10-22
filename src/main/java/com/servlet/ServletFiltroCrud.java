package com.servlet;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.dao.FuncionarioDao;

@WebServlet("/servletFiltro")
public class ServletFiltroCrud extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String tabela = request.getParameter("tabela");
        String coluna = request.getParameter("coluna");
        String filtro = request.getParameter("filtro");

        request.getSession().setAttribute("coluna",coluna);
        request.getSession().setAttribute("filtro",filtro);

        if(tabela.equals("crud")) {
            request.getRequestDispatcher("/WEB-INF/views/PaginaAposLogin/crud.jsp").forward(request, response);
        }
        else if(tabela.equals("empresa")) {
            request.getRequestDispatcher("/WEB-INF/views/PaginaAposLogin/empresa.jsp").forward(request, response);
        }
    }
}