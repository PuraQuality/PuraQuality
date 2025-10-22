package com.servlet;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.dao.FuncionarioDao;

@WebServlet("/servlogin")
public class AcessarLogin extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/LoginSignUp/login.jsp").forward(request, response);
    }
}