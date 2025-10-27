<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.model.Funcionario" %>
<%@ page import="com.dao.FuncionarioDao" %>
<%@ page import="java.sql.SQLException" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RH - Dashboard</title>
    <link rel="icon" href="${pageContext.request.contextPath}/img/LogoPura.png">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/crud.css?v=<%= System.currentTimeMillis() %>">
    <!---------------- imports ---------------->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Lexend+Giga:wght@100..900&display=swap" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>
<body>
    <!-- Header Bar -->
    <div class="header-bar">
        <div class="header-left">
            <img src="${pageContext.request.contextPath}/img/logoOFC.png" alt="LogoPuraQuality" class="logo-header">
            <span class="titulo-header">PuraQuality</span>
        </div>
        <div class="header-right">
            <span class="dashboard-label">ADM - dashboard</span>
        </div>
    </div>

    <!-- Control Panel -->
    <div class="control-panel">
        <button class="menu-icon" aria-label="Menu">
            <i class="fas fa-bars"></i>
        </button>
        <button class="filter-icon" aria-label="Filter">
            <i class="fas fa-filter"></i>
        </button>
        <form method="POST" action="servletFiltro" class="search-form">
            <select name="coluna" id="coluna" class="search-dropdown">
                <option value="email">Email</option>
                <option value="permissao">Permissão</option>
            </select>
            <div class="search-input-wrapper">
                <input type="text" name="filtro" class="search-input" placeholder="O que procura?" value="<%=(request.getSession().getAttribute("filtro") != null) ? request.getSession().getAttribute("filtro") : ""%>">
                <button type="submit" class="search-button" aria-label="Search">
                    <i class="fas fa-search"></i>
                </button>
            </div>
            <input type="hidden" name="tabela" value="crud">
        </form>
        <button class="insert-button" onclick="openInsertModal()">
            <i class="fas fa-plus"></i> Inserir
        </button>
    </div>

    <!-- Data Table -->
    <div class="table-container">
        <table>
            <thead>
            <tr>
                <th>Email</th>
                <th>Permissão</th>
                <th>Telefone</th>
                <th>Deletar</th>
            </tr>
            </thead>
            <tbody>
<%
    FuncionarioDao fdao = new FuncionarioDao();
    List<Funcionario> funcionarios;
    int empresaid = (int) request.getSession().getAttribute("empresaid");
    String coluna = request.getParameter("coluna");
    String filtro = (String) request.getSession().getAttribute("filtro");
    
    // Verifica se o filtro está vazio ou null
    if(filtro == null || filtro.isEmpty()){
        funcionarios = fdao.selectEmpresa(empresaid);
    } else {
        if (coluna != null && coluna.equals("permissao")) {
            funcionarios = fdao.selectFiltro(empresaid, Boolean.parseBoolean(filtro));
        }
        else{
            funcionarios = fdao.selectFiltro(empresaid, coluna, filtro);
        }
    }
for(int i = 0;i < funcionarios.size();i++){%>
<tr>
    <td><%=funcionarios.get(i).getEmail()%></td>
    <td><%=funcionarios.get(i).isPrioridade()%></td>
    <td>-</td>
    <td>
        <form action="servletDeletarUsuario" method="post" class="delete-form">
            <input type="hidden" name="id" value="<%=funcionarios.get(i).getId()%>">
            <input type="hidden" name="email" value="<%=funcionarios.get(i).getEmail()%>">
            <input type="hidden" name="empresa" value="nao">
            <button type="submit" class="delete-button">Deletar</button>
        </form>
    </td>
</tr>
<%}%>
            </tbody>
        </table>
    </div>

    <!-- Insert Modal -->
    <div id="insertModal" class="modal">
        <div class="modal-content">
            <span class="close" onclick="closeInsertModal()">&times;</span>
            <h2>Inserir Novo Usuário</h2>
            <form action="servletInserirUsuario" method="post">
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email" placeholder="Digite o email do novo funcionário" required>
                </div>
                <div class="form-group">
                    <label for="senha">Senha:</label>
                    <input type="password" id="senha" name="senha" placeholder="Digite a senha do novo funcionário" required>
                </div>
                <input type="hidden" name="permissao" value="1">
                <input type="hidden" name="empresa" value="nao">
                <input type="hidden" name="id_empresa" value="<%=request.getSession().getAttribute("empresaid")%>">
                <div class="modal-buttons">
                    <button type="submit" class="btn-submit">Inserir Usuário</button>
                    <button type="button" class="btn-cancel" onclick="closeInsertModal()">Cancelar</button>
                </div>
            </form>
        </div>
    </div>

    <script>
        function openInsertModal() {
            document.getElementById('insertModal').style.display = 'flex';
        }

        function closeInsertModal() {
            document.getElementById('insertModal').style.display = 'none';
        }

        // Close modal when clicking outside of it
        window.onclick = function(event) {
            const modal = document.getElementById('insertModal');
            if (event.target == modal) {
                modal.style.display = 'none';
            }
        }
    </script>
</body>
</html>
