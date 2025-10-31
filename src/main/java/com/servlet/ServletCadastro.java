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

//        Pegando a requisição do jsp
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

//        Declarando objeto
        EmpresaDao empresaDao = new EmpresaDao();
        Empresa empresa = new Empresa(1,"AAAAAAAA","101820603",email,senha,"12",10);

//        Validando se o cadastro deu certo, se sim vai para login, se não volta
        if(empresaDao.save(empresa)) {
            request.getRequestDispatcher("LoginSignUp/login.jsp").forward(request, response);
        }
        else{
            request.getRequestDispatcher("LoginSignUp/signup.jsp").forward(request, response);
        }
    }
}