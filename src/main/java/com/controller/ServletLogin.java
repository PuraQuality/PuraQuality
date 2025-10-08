package com.controller;

import java.io.*;
import java.util.List;

import com.model.Empresa;
import com.repository.EmpresaDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.repository.FuncionarioDao;
import com.model.Funcionario;

@WebServlet(name = "servletLogin", value = "/servletLogin")
public class ServletLogin extends HttpServlet {
    public void init() {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        boolean validarEmail = false;
        boolean validarSenha = false;
        int posicao = -1;
        boolean prioridade = false;
        boolean validarEmpresa = false;

        FuncionarioDao usuarioDao = new FuncionarioDao();
        EmpresaDao empresaDao = new EmpresaDao();
        List<Funcionario> usuarios = usuarioDao.select();
        List<Empresa> empresas = empresaDao.select();
        for (int i = 0; i < empresas.size(); i++) {
            if (empresas.get(i).getEmail().equals(email)) {
                validarEmail = true;
                validarEmpresa = true;
                posicao = i;
                break;
            }
        }
        if(!validarEmail) {
            for (int i = 0; i < usuarios.size(); i++) {
                if(usuarios.get(i).getEmail().equals(email)){
                    validarEmail = true;
                    prioridade = usuarios.get(i).isPrioridade();
                    posicao = i;
                    break;
                }
            }
        }
        if(posicao != -1) {
            if(validarEmpresa) {
                if (senha.equals(empresas.get(posicao).getSenha())){
                    validarSenha = true;
                }
            }
            else{
                if (senha.equals(usuarios.get(posicao).getSenha())){
                    validarSenha = true;
                }
            }
        }
        request.setAttribute("email", validarEmail);
        request.setAttribute("senha", validarSenha);
        if(validarSenha){
            if(validarEmpresa) {
                request.getRequestDispatcher("PaginaAposLogin/empresa.jsp").forward(request, response);
            }
            else{
                System.out.println("Não empresa");
                if(prioridade){
                    request.getRequestDispatcher("PaginaAposLogin/crud.jsp").forward(request, response);
                }
                else{
                    request.getRequestDispatcher("PaginaAposLogin/home.jsp").forward(request, response);
                }
            }
        }
        else{
            request.getRequestDispatcher("LoginSignUp/login.jsp").forward(request, response);
        }
    }

    public void destroy() {
    }
}