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
    FuncionarioDao fdao = new FuncionarioDao();
    List<Funcionario> funcionarios;
    String empresaId = (String) request.getSession().getAttribute("empresaid");
    String funcionarioId = (String) request.getSession().getAttribute("funcionarioid");
    funcionarios = fdao.selectFiltro(Integer.parseInt(empresaId),"id",funcionarioId);
%>
    <h1>Área de trabalho</h1>
</body>
</html>
