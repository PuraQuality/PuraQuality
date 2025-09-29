package com.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.repository.UsuarioDao;
import com.model.Usuario;

@WebServlet(name = "servletLogin", value = "/servletLogin")
public class ServletLogin extends HttpServlet {
    private String message;

    public void init() {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        boolean validarEmail = false;
        boolean validarSenha = false;
        int posicao = -1;
        UsuarioDao usuarioDao = new UsuarioDao();
        List<Usuario> usuarios = usuarioDao.select();
        for (int i = 0; i < usuarios.size(); i++) {
            if(usuarios.get(i).getEmail().equals(email)){
                validarEmail = true;
                posicao = i;
                break;
            }
        }
        if(posicao != -1 && senha.equals(usuarios.get(posicao).getSenha())){
            validarSenha = true;
        }
        if(validarEmail && validarSenha){
            request.getRequestDispatcher("/home.jsp").forward(request, response);
        }
        else{
            request.getRequestDispatcher("LoginSignUp/login.jsp").forward(request, response);
        }
    }

    public void destroy() {
    }
}