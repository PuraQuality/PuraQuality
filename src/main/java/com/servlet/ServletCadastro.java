package com.servlet;

import java.io.*;

import com.model.Empresa;
import com.dao.EmpresaDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "servletCadastro", value = "/servletCadastro")
public class ServletCadastro extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        EmpresaDao empresaDao = new EmpresaDao();
        Empresa empresa = new Empresa(1,"AAAAAAAA","101820603",email,senha,"12",10);
        if(empresaDao.save(empresa)) {
            request.getRequestDispatcher("LoginSignUp/login.jsp").forward(request, response);
        }
        else{
            request.getRequestDispatcher("LoginSignUp/signup.jsp").forward(request, response);
        }
    }

    public void destroy() {
    }
}
