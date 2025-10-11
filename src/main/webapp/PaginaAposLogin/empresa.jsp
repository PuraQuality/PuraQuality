<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.model.Funcionario" %>
<%@ page import="com.repository.FuncionarioDao" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Seja bem vindo Usuário da empresa</h1>
<table>
    <thead>
    <tr>
        <th>Email</th>
        <th>Permissões</th>
        <th>Alterar informações</th>
        <th>Deletar cadastro</th>
    </tr>
    </thead>
    <tbody>
    <%
        FuncionarioDao fdao = new FuncionarioDao();
        List<Funcionario> funcionarios = fdao.selectEmpresa((int) request.getSession().getAttribute("empresaid"));
        for(int i = 0;i < funcionarios.size();i++){%>
    <tr>
        <td style="border: 1px solid black;"><%=funcionarios.get(i).getEmail()%></td>
        <td style="border: 1px solid black;"><%=funcionarios.get(i).isPrioridade()%></td>
        <td style="border: 1px solid black;">
            <form action="servletAlterarUsuario" method="post">
                <label>
                    Permissão:<input type="checkbox" name="prioridade" <%=funcionarios.get(i).isPrioridade()?"checked":null%>>
                </label>
                <input type="hidden" name="id" value=<%=funcionarios.get(i).getId()%>>
                <input type="hidden" name="email" value=<%=funcionarios.get(i).getEmail()%>>
                <input type="hidden" name="senha" value=<%=funcionarios.get(i).getSenha()%>>
                <button type="submit">Alterar Usuário</button>
            </form>
        </td>
        <td style="border: 1px solid black;">
            <form action="servletDeletarUsuario" method="post">
                <input type="hidden" name="id" value="<%=funcionarios.get(i).getId()%>">
                <input type="hidden" name="email" value="<%=funcionarios.get(i).getEmail()%>">
                <input type="hidden" name="senha" value="<%=funcionarios.get(i).getSenha()%>">
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
