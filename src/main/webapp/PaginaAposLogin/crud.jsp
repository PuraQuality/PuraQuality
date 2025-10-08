<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.List" %>
<%@ page import="com.model.Funcionario" %>
<%@ page import="com.repository.FuncionarioDao" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Seja bem vindo administrador</h1>
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
List<Funcionario> funcionarios = fdao.select();
for(int i = 0;i < funcionarios.size();i++){%>
<tr>
    <td><%=funcionarios.get(i).getEmail()%></td>
    <td><%=funcionarios.get(i).isPrioridade()%></td>
    <td><a href="servletAlterarUsuario?action=post&id='<%=i%>'"><button>Alterar Usuário</button></a></td>
    <td><a href="servletDeletarUsuario?action=post&id='<%=i%>'"><button>Deletar Usuário</button></a></td>
</tr>
<%}%>
        </tbody>
    </table>
<form action="${pageContext.request.contextPath}/servletAlterarUsuario" method="post">
    <label>
        <input type="email" name="email" placeholder="Digite o email">
    </label>
    <label>
        Permissão: <input type="checkbox" name="prioridade">
    </label>
    <input type="submit" value="Enviar">
</form>
</body>
</html>
