<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.model.Funcionario" %>
<%@ page import="com.dao.FuncionarioDao" %>
<%@ page import="java.sql.SQLException" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Seja bem vindo administrador</h1>
    <form method="POST" action="servletFiltro">
        <label>
            <select name="coluna" id="coluna">
                <option value="email">Email</option>
                <option value="permissao">Permissão</option>
            </select>
        </label>
        <label>
            <input type="text" name="filtro" placeholder="Digite o que deseja procurar:">
        </label>
        <input type="hidden" name="tabela" value="crud">
        <input type="submit" value="Enviar">
    </form>
    <table>
        <thead>
        <tr>
            <th>Email</th>
            <th>Permissões</th>
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
    <td><%=funcionarios.get(i).getEmail()%></td>
    <td><%=funcionarios.get(i).isPrioridade()%></td>
    <td>
        <form action="servletDeletarUsuario" method="post">
            <input type="hidden" name="id" value="<%=funcionarios.get(i).getId()%>">
            <input type="hidden" name="email" value="<%=funcionarios.get(i).getEmail()%>">
            <input type="hidden" name="empresa" value="">
            <button type="submit">Deletar Usuário</button>
        </form>
    </td>
</tr>
<%}%>
        </tbody>
    </table>
    <form action="servletInserirUsuario" method="post">
        <input type="email" name="email" placeholder="Digite o email do novo funcionário">
        <input type="password" name="senha" placeholder="Digite a senha do novo funcionário">
        <input type="hidden" name="permissao" value="1">
        <input type="hidden" name="empresa" value="">
        <input type="hidden" name="id_empresa" value="<%=request.getParameter("empresaid")%>">
        <button type="submit">Inserir Usuário</button>
    </form>
</body>
</html>
