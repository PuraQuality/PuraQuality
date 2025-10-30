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
    <link rel="icon" href="${pageContext.request.contextPath}/img/logoOFC.png">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/empresa.css?v=<%= System.currentTimeMillis() %>">
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
            <a href="${pageContext.request.contextPath}/index.html" class="titulo-header">PuraQuality</a>
        </div>
        <div class="header-right">
            <span class="dashboard-label">RH - dashboard</span>
        </div>
    </div>

    <!-- Control Panel -->
    <div class="control-panel">
        <div class="filter-icon" aria-label="Filter">
            <i class="fas fa-filter"></i>
        </div>
        <form method="POST" action="servletFiltro" class="search-form">
            <select name="coluna" id="coluna" class="search-dropdown">
                <option value="nome">Nome</option>
                <option value="sobrenome">Sobrenome</option>
                <option value="telefone">Telefone</option>
                <option value="email">Email</option>
                <option value="permissao">Permissão</option>
                <option value="plano">Plano</option>
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
                <th>Nome Completo</th>
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
    <td><%=funcionarios.get(i).getNome() + " " + funcionarios.get(i).getSobrenome()%></td>
    <td><%=funcionarios.get(i).getEmail()%></td>
    <td><%=funcionarios.get(i).isPrioridade()%></td>
    <td><%=funcionarios.get(i).getTelefone()%></td>
    <td>
        <div class="delete-form">
            <div class="delete-button" onclick="openDelModal()">Deletar</div>
        </div>
    </td>
</tr>
<div id="del-modal" class="modal-del">
    <div class="del-content">
        <span class="close" onclick="closeDelModal()">&times;</span>
        <h1>CALMAAAA</h1>
        <p>vc real quer deletar?</p>
        <form action="servletDeletarUsuario" method="post" class="delete-form">
            <input type="hidden" name="id" value="<%=funcionarios.get(i).getId()%>">
            <input type="hidden" name="email" value="<%=funcionarios.get(i).getEmail()%>">
            <input type="hidden" name="empresa" value="nao">
            <button type="submit" class="delete-button modal-delbutton">Deletar</button>
        </form>
    </div>
</div>
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
                <div class="formCard">
                    <div class="form-group">
                        <label for="email">Email:</label>
                        <input type="email" id="email" name="email" placeholder="Digite o email do novo funcionário" required>
                    </div>
                    <div class="form-group">
                        <label for="senha">Senha:</label>
                        <input type="password" id="senha" name="senha" placeholder="Digite a senha do novo funcionário" required>
                        <button id="verSenha" class="verSenha">🙈</button>
                    </div>
                    <div class="form-group">
                        <label for="nome">Nome:</label>
                        <input type="text" id="nome" name="nome" placeholder="Digite o nome do novo funcionário">
                    </div>
                </div>
                <div class="formCard">
                    <div class="form-group">
                        <label for="sobrenome">Sobrenome:</label>
                        <input type="text" id="sobrenome" name="sobrenome" placeholder="Digite o sobrenome do novo funcionário">
                    </div>
                    <div class="form-group">
                        <label for="telefone">Telefone:</label>
                        <input type="text" id="telefone" name="telefone" placeholder="(00) 00000-0000">
                    </div>
                </div>
                <input type="hidden" name="permissao" value="0">
                <input type="hidden" name="empresa" value="sim">
                <input type="hidden" name="id_empresa" value="<%=request.getSession().getAttribute("empresaid")%>">
                <div class="modal-buttons">
                    <button type="submit" class="btn-submit">Inserir Usuário</button>
                    <button type="button" class="btn-cancel" onclick="closeInsertModal()">Cancelar</button>
                </div>
            </form>
        </div>
    </div>
    <script>
            // FUNÇÃO PARA ABRIR O MODAL DE INSERÇÃO DE USUÁRIO E DELETAR USUÁRIO
        function openInsertModal() {
            // aqui ele pega o valor do modal e troca o display para flex, ou seja, abre
            document.getElementById('insertModal').style.display = 'flex';
        }
        function openDelModal() {
            document.getElementById('del-modal').style.display = 'flex';
        }
        // FUNÇÃO PARA FECHAR O MODAL DE INSERÇÃO DE USUÁRIO E DELETAR USUÁRIO
        function closeInsertModal() {
            // aqui ele pega o valor do modal e troca o display para none, ou seja, fecha
            document.getElementById('insertModal').style.display = 'none';
        }
        function closeDelModal() {
            document.getElementById('del-modal').style.display = 'none';
        }

        // FECHAR O MODAL QUANDO CLICAR FORA DELE
        window.onclick = function(event) {
            // pega o modal pelo id e coloca em uma constante que nunca muda (const)
            const modal = document.getElementById('insertModal');
            // verifica se o alvo do clique é o modal
            if (event.target == modal) {
                // se for, fecha o modal
                modal.style.display = 'none';
            }
        }
        // FECHAR O MODAL QUANDO CLICAR FORA DELE
        window.onclick = function(event) {
            // pega o modal pelo id e coloca em uma constante que nunca muda (const)
            const modal = document.getElementById('del-modal');
            // verifica se o alvo do clique é o modal
            if (event.target == modal) {
                // se for, fecha o modal
                modal.style.display = 'none';
            }
        }
        // FUNÇÃO PARA VER A SENHA
        // puxando pelo id do botão e fazendo um callback de click
        document.getElementById('verSenha').addEventListener('click', function(event) {
            event.preventDefault(); // Evita o comportamento padrão do botão
            // pega o botao pelo id
            const botao = document.getElementById('verSenha');
            // pega o input da senha pelo id
            const senhaInput = document.getElementById('senha');
            // verfica o tipo do input
            if (senhaInput.type === 'password') {
                senhaInput.type = 'text'; // Mostra a senha
                botao.textContent = '👁️'; // troca os emojis
            } else {
                senhaInput.type = 'password'; // Oculta a senha
                botao.textContent = '🙈'; // troca os emojis
            }
        });
    </script>
</body>
</html>
