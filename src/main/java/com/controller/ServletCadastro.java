package com.controller;

import java.io.*;
import java.util.List;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.repository.UsuarioDao;
import com.model.Usuario;

@WebServlet(name = "servletCadastro", value = "/servletCadastro")
public class ServletCadastro extends HttpServlet {
    private String message;

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        UsuarioDao usuarioDao = new UsuarioDao();
        Usuario usuario = new Usuario(email,senha,1);
        usuarioDao.save(usuario);
    }

    public void destroy() {
    }
}
