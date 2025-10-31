<%@ page import="com.dao.FuncionarioDao" %>
<%@ page errorPage="/error.jsp" %>
<%@ page import="com.model.Funcionario" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
//    Criando o objeto e a lista
    FuncionarioDao fdao = new FuncionarioDao();
    List<Funcionario> funcionarios;

//    Adquirindo os parametros
    String empresaId = (String) request.getSession().getAttribute("empresaid");
    String funcionarioId = (String) request.getSession().getAttribute("funcionarioid");

//    Pegando um funcionário específico
    funcionarios = fdao.selectFiltro(Integer.parseInt(empresaId),"id",funcionarioId);
%>
    <h1>Área de trabalho</h1>
</body>
</html>
