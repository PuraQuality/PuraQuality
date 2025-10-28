<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.model.Funcionario" %>
<%@ page import="com.dao.FuncionarioDao" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Seja bem vindo Usuário da empresa</h1>
<form method="POST" action="servletFiltro">
    <label>
        <select name="coluna" id="coluna">
            <option value="nome">Nome</option>
            <option value="sobrenome">Sobrenome</option>
            <option value="telefone">Telefone</option>
            <option value="email">Email</option>
            <option value="permissao">Permissão</option>
        </select>
    </label>
    <label>
        <input type="text" name="filtro" placeholder="Digite o que deseja procurar:">
    </label>
    <input type="hidden" name="tabela" value="empresa">
    <input type="submit" value="Enviar">
</form>
<table>
    <thead>
    <tr>
        <th>Nome Completo</th>
        <th>Telefone</th>
        <th>Email</th>
        <th>Permissões</th>
        <th>Alterar informações</th>
        <th>Deletar cadastro</th>
    </tr>
    </thead>
    <tbody>
    <%
        FuncionarioDao fdao = new FuncionarioDao();
        List<Funcionario> funcionarios;
        int empresaid = (int) request.getSession().getAttribute("empresaid");
        String coluna = request.getParameter("coluna");
        String filtro = (String) request.getSession().getAttribute("filtro");

        if(((String) request.getSession().getAttribute("filtro")).isEmpty()){
            funcionarios = fdao.selectEmpresa(empresaid);
        } else {
            if (((coluna != null)?coluna:"").equals("permissao")) {
                funcionarios = fdao.selectFiltro(empresaid, (filtro.equals("true")) ? true : false);
            }
            else{
                funcionarios = fdao.selectFiltro(empresaid,coluna,filtro);
            }
        }
        for(int i = 0;i < funcionarios.size();i++){%>
    <tr>
        <td style="border: 1px solid black;"><%=funcionarios.get(i).getNome() + " " + funcionarios.get(i).getSobrenome()%></td>
        <td style="border: 1px solid black;"><%=funcionarios.get(i).getTelefone()%></td>
        <td style="border: 1px solid black;"><%=funcionarios.get(i).getEmail()%></td>
        <td style="border: 1px solid black;"><%=funcionarios.get(i).isPrioridade()%></td>

        <td style="border: 1px solid black;">
            <form action="servletAlterarUsuario" method="post">
                <label>
                    Permissão:<input type="checkbox" name="prioridade" <%=funcionarios.get(i).isPrioridade()?"checked":null%>>
                </label>
                <input type="hidden" name="id" value=<%=funcionarios.get(i).getId()%>>
                <input type="hidden" name="nome" value=<%=funcionarios.get(i).getNome()%>>
                <input type="hidden" name="sobrenome" value=<%=funcionarios.get(i).getSobrenome()%>>
                <input type="hidden" name="telefone" value=<%=funcionarios.get(i).getTelefone()%>>
                <input type="hidden" name="email" value=<%=funcionarios.get(i).getEmail()%>>
                <input type="hidden" name="senha" value=<%=funcionarios.get(i).getSenha()%>>
                <button type="submit">Alterar Usuário</button>
            </form>
        </td>
        <td style="border: 1px solid black;">
            <form action="servletDeletarUsuario" method="post">
                <input type="hidden" name="id" value="<%=funcionarios.get(i).getId()%>">
                <input type="hidden" name="email" value="<%=funcionarios.get(i).getEmail()%>">
                <input type="hidden" name="empresa" value="sim">
                <button type="submit">Deletar Usuário</button>
            </form>
        </td>
    </tr>
    <%}%>
    </tbody>
</table>
<form action="servletInserirUsuario" method="post">
    <input type="email" name="email" placeholder="Digite o email do novo funcionário" style="width: 250px">
    <input type="password" name="senha" placeholder="Digite a senha do novo funcionário" style="width: 250px">
    <input type="checkbox" name="permissao">
    <input type="hidden" name="empresa" value="sim">
    <input type="hidden" name="id_empresa" value="<%=request.getParameter("empresaid")%>">
    <button type="submit">Inserir Usuário</button>
</form>
</body>
</html>
