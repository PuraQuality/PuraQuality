package com.servlet;

import java.io.*;

import com.dao.EmpresaDao;
import com.model.Empresa;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.dao.FuncionarioDao;
import com.model.Funcionario;

@WebServlet(name = "servletAlterarUsuario", value = "/servletAlterarUsuario")
public class ServletAlterarUsuario extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(!request.getParameter("empresa").equals("sim")){
//        Pegando a requisição da página jsp
            int id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("nome");
            String sobrenome = request.getParameter("sobrenome");
            String telefone = request.getParameter("telefone").replaceAll("[^0-9]","");
            String email = request.getParameter("email");
            boolean prioridade = (request.getParameter("prioridade") != null || request.getParameter("prioridade").equals("true"));
            String senha = request.getParameter("senha");

//        Declarando objetos
            FuncionarioDao funcionarioDao = new FuncionarioDao();
            Funcionario funcionario = new Funcionario(nome, sobrenome, telefone, email, senha, prioridade);

//        Adicionando ao banco de dados
            funcionarioDao.update(funcionario);

//        Encaminhando de volta para o nosso crud
            request.getRequestDispatcher("WEB-INF/views/PaginaAposLogin/crudRH.jsp").forward(request, response);
        }
        else{
            if(request.getParameter("trocarsenha").equals("sim")){
//        Pegando a requisição da página jsp
                int id = Integer.parseInt(request.getParameter("id"));
                String nome = request.getParameter("nome");
                String setor = request.getParameter("setor");
                String telefone = request.getParameter("telefone").replaceAll("[^0-9]","");
                String email = request.getParameter("email");
                String cnpj = request.getParameter("cnpj");
                String senha = request.getParameter("senha");
                int planoid = Integer.parseInt(request.getParameter("planoid"));

//        Declarando objetos
                EmpresaDao empresaDao = new EmpresaDao();
                Empresa empresa = new Empresa(id, nome,setor,telefone,cnpj,email,senha,planoid);

                System.out.println("Nova senha");

//        Adicionando ao banco de dados
                empresaDao.update(empresa);

//        Encaminhando de volta para o nosso crud
                request.getRequestDispatcher("WEB-INF/views/PaginaAposLogin/crudAdm.jsp").forward(request, response);
            }
            else{
//        Pegando a requisição da página jsp
                int id = Integer.parseInt(request.getParameter("id"));
                String nome = request.getParameter("nome");
                String sobrenome = request.getParameter("sobrenome");
                String telefone = request.getParameter("telefone").replaceAll("[^0-9]","");
                String email = request.getParameter("email");
                boolean prioridade = (request.getParameter("prioridade") != null || request.getParameter("prioridade").equals("true"));
                String senha = request.getParameter("senha");

//        Declarando objetos
                FuncionarioDao funcionarioDao = new FuncionarioDao();
                Funcionario funcionario = new Funcionario(nome, sobrenome, telefone, email, senha, prioridade);

//        Adicionando ao banco de dados
                funcionarioDao.update(funcionario);

//        Encaminhando de volta para o nosso crud
                request.getRequestDispatcher("WEB-INF/views/PaginaAposLogin/crudAdm.jsp").forward(request, response);
            }
        }
    }
}