<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.model.Funcionario" %>
<%@ page import="com.dao.FuncionarioDao" %>
<%@ page import="com.model.Empresa" %>
<%@ page import="com.dao.EmpresaDao" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Seja bem vindo Usuário da empresa</h1>
<%String tabela = (String) request.getSession().getAttribute("tabela");%>
<form method="POST" action="servletFiltro">
    <label>
        <select name="coluna" id="coluna">
            <option value="nome">Nome</option>
            <option value="setor" <%=(tabela.equals("setor")?"selected":"")%>>Setor</option>
            <option value="cnpj" <%=(tabela.equals("cnpj")?"selected":"")%>>CNPJ</option>
            <option value="email" <%=(tabela.equals("email")?"selected":"")%>>Email</option>
            <option value="plano_id" <%=(tabela.equals("plano")?"selected":"")%>>Plano</option>
        </select>
    </label>
    <label>
        <input type="text" name="filtro" placeholder="Digite o que deseja procurar:">
    </label>
    <input type="hidden" name="tabela" value="puraquality">
    <input type="submit" value="Enviar">
</form>
<table>
    <thead>
    <tr>
        <th>Nome</th>
        <th>Setor</th>
        <th>CNPJ</th>
        <th>Email</th>
        <th>Plano</th>
        <th>Deletar</th>
        <th>Alterar</th>
    </tr>
    </thead>
    <tbody>
    <%
        EmpresaDao edao = new EmpresaDao();
        List<Empresa> empresas;
        String coluna = request.getParameter("coluna");
        String filtro = (String) request.getSession().getAttribute("filtro");

        if(((String) request.getSession().getAttribute("filtro")).isEmpty()){
            empresas = edao.select();
        } else {
            if (((coluna != null)?coluna:"").equals("permissao")) {
                empresas = edao.selectFiltro((filtro.equals("true")) ? true : false);
            }
            else{
                empresas = edao.selectFiltro(coluna,filtro);
            }
        }
        for(int i = 0;i < empresas.size();i++){%>
    <tr>
        <td style="border: 1px solid black;"><%=empresas.get(i).getNome()%></td>
        <td style="border: 1px solid black;"><%=empresas.get(i).getSetor()%></td>
        <td style="border: 1px solid black;"><%=empresas.get(i).getCnpj()%></td>
        <td style="border: 1px solid black;"><%=empresas.get(i).getEmail()%></td>
        <td style="border: 1px solid black;"><%=empresas.get(i).getPlano()%></td>
        <td>
        <form method="POST" action="servletAlterarEmpresa">
            <label>
                <select name="altplano" id="altplano">
                    <option value="10">Quality</option>
                    <option value="11" <%=(empresas.get(i).getPlanoId() == 11)?"selected":""%>>FullQuality</option>
                    <option value="12" <%=(empresas.get(i).getPlanoId() == 12)?"selected":""%>>PuraQuality</option>
                </select>
            </label>
            <input type="hidden" name="empId"  value="<%=empresas.get(i).getId()%>">
            <input type="hidden" name="tabela" value="puraquality">
            <input type="submit" value="Alterar">
        </form>
        </td>
        <td style="border: 1px solid black;">
            <form action="servletDeletarEmpresa" method="post">
                <input type="hidden" name="idempresa" value="<%=empresas.get(i).getId()%>">
                <button type="submit">Deletar Usuário</button>
            </form>
        </td>
    </tr>
    <%}%>
    </tbody>
</table>
<form action="#" method="post">
    <input type="email" name="email" placeholder="Digite o email da empresa" style="width: 250px">
    <input type="password" name="senha" placeholder="Digite a senha da empresa" style="width: 250px">
    <input type="text" name="cnpj" placeholder="Digite o cnpj" style="width: 250px">
    <input type="checkbox" name="permissao">
    <button type="submit">Inserir Usuário</button>
</form>
</body>
</html>
