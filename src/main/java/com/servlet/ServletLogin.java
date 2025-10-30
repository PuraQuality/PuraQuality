package com.servlet;

import java.io.*;
import java.util.List;

import com.dao.EmpresaDao;
import com.model.Empresa;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.dao.FuncionarioDao;
import com.model.Funcionario;

@WebServlet(name = "servletLogin", value = "/servletLogin")
public class ServletLogin extends HttpServlet {
    public void init() {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

//        Pegando os Parâmetros
        String email = request.getParameter("emailfuncionario");
        String senha = request.getParameter("senha");

//        Declarando variáveis com valores padrões
        boolean validarEmail = false;
        boolean validarSenha = false;
        int posicao = -1;
        boolean prioridade = false;
        boolean validarEmpresa = false;

//        Guardando informações para usar depois
        request.getSession().setAttribute("emailfuncionario", email);
        request.getSession().setAttribute("filtro","");
        request.getSession().setAttribute("tabela","");

//        Validando para ver se nós estamos tentando logar
        if(email.equals("puraquality@gmail.com") || senha.equals("PuraQuality2025+")){
            request.getRequestDispatcher("WEB-INF/views/PaginaAposLogin/puraquality.jsp").forward(request, response);
        }
        else {

//            Declarando diversos objetos
            FuncionarioDao usuarioDao = new FuncionarioDao();
            EmpresaDao empresaDao = new EmpresaDao();
            List<Funcionario> usuarios = usuarioDao.select();
            List<Empresa> empresas = empresaDao.select();

//            Vendo se o e-mail da empresa está presente no banco de dados
            for (int i = 0; i < empresas.size(); i++) {
                if (empresas.get(i).getEmail().equals(email)) {
                    validarEmail = true;
                    validarEmpresa = true;
                    posicao = i;
                    request.getSession().setAttribute("empresaid", empresas.get(i).getId());
                    break;
                }
            }

//            Vendo se o e-mail do funcionário está presente no banco de dados
            if (!validarEmail) {
                for (int i = 0; i < usuarios.size(); i++) {
                    if (usuarios.get(i).getEmail().equals(email)) {
                        validarEmail = true;
                        prioridade = usuarios.get(i).isPrioridade();
                        posicao = i;
                        request.getSession().setAttribute("empresaid", usuarios.get(i).getEmpresaId());
                        request.getSession().setAttribute("funcionarioid", usuarios.get(i).getId());
                        break;
                    }
                }
            }

//            Vendo se a senha corresponde ao e-mail do banco de dados
            if (posicao != -1) {
                if (validarEmpresa) {
                    if (senha.equals(empresas.get(posicao).getSenha())) {
                        validarSenha = true;
                    }
                } else {
                    if (senha.equals(usuarios.get(posicao).getSenha())) {
                        validarSenha = true;
                    }
                }
            }

//            Encaminhando para a página correspondente
            if (validarSenha) {
                if (validarEmpresa) {
                    request.getRequestDispatcher("WEB-INF/views/PaginaAposLogin/crudAdm.jsp").forward(request, response);
                } else {
                    if (prioridade) {
                        request.getRequestDispatcher("WEB-INF/views/PaginaAposLogin/crudEmpresa.jsp").forward(request, response);
                    } else {
                        request.getRequestDispatcher("WEB-INF/views/PaginaAposLogin/home.jsp").forward(request, response);
                    }
                }
            }

//            Voltando para login caso a senha esteja errada
            else {
                request.getRequestDispatcher("WEB-INF/views/LoginSignUp/login.jsp").forward(request, response);
            }
        }
    }
}