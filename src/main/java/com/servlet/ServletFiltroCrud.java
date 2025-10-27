package com.servlet;

import java.io.*;
import java.util.Locale;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.dao.FuncionarioDao;

@WebServlet("/servletFiltro")
public class ServletFiltroCrud extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

//        Adquirindo o valor dos parâmetros do jsp
        String tabela = request.getParameter("tabela");
        String coluna = request.getParameter("coluna");
        String filtro = request.getParameter("filtro");

//        Guardando o valor para usar na pagina de crud
        request.getSession().setAttribute("coluna",coluna);
        request.getSession().setAttribute("filtro",filtro);

//        Encaminhando os valores de volta para a página correta
        if(tabela.equals("crud")) {
            request.getRequestDispatcher("/WEB-INF/views/PaginaAposLogin/crud.jsp").forward(request, response);
        }
        else if(tabela.equals("empresa")) {
            request.getRequestDispatcher("/WEB-INF/views/PaginaAposLogin/empresa.jsp").forward(request, response);
        } else if (tabela.equals("puraquality")) {
            request.getRequestDispatcher("/WEB-INF/views/PaginaAposLogin/puraquality.jsp").forward(request, response);
        }
    }
}