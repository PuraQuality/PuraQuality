<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/error.jsp" %>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/crudRH.css?v=<%= System.currentTimeMillis() %>">
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
            <option value="nome || sobrenome">Nome</option>
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
    <button class="insert-button" onclick="openTrocaModal()">
        Trocar senha
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
//            Criando objeto e lista
            FuncionarioDao fdao = new FuncionarioDao();
            List<Funcionario> funcionarios;

//            Adquirindo os parametros
            int empresaid = (int) request.getSession().getAttribute("empresaid");
            int funcionarioid = (int) request.getSession().getAttribute("funcionarioid");
            String coluna = request.getParameter("coluna");
            String filtro = (String) request.getSession().getAttribute("filtro");

            // Verifica se o filtro está vazio ou null
            if(filtro == null || filtro.isEmpty()){
                funcionarios = fdao.selectEmpresa(empresaid);
            } else {
//                Vendo se o filtro é uma permissão para chamar o método correto
                if (coluna != null && coluna.equals("permissao")) {
                    funcionarios = fdao.selectFiltro(empresaid, Boolean.parseBoolean(filtro));
                }
                else{
                    funcionarios = fdao.selectFiltro(empresaid, coluna, filtro);
                }
            }
//            Adicionando uma linha da tabela para cada funcionário
            for(int i = 0;i < funcionarios.size();i++){%>
        <tr>
            <td><%=funcionarios.get(i).getNome() + " " + funcionarios.get(i).getSobrenome()%></td>
            <td><%=funcionarios.get(i).getEmail()%></td>
            <td><%=funcionarios.get(i).isPrioridade()%></td>
            <td><%=funcionarios.get(i).getTelefone()%></td>
            <td>
                <div class="delete-form">
                    <div class="delete-button" onclick="openDelModal(<%=i%>)">Deletar</div>
                </div>
            </td>
        </tr>
        <div id="del-modal<%=i%>" class="modal-del">
            <div class="del-content">
                <span class="close" onclick="closeDelModal(<%=i%>)">&times;</span>
                <h1>Você tem certeza?</h1>
                <p>Você tem certeza que quer deletar <%=funcionarios.get(i).getNome() + " " + funcionarios.get(i).getSobrenome()%>?</p>
                <form action="servletDeletarUsuario" method="post" class="delete-form">
                    <input type="hidden" name="id" value="<%=funcionarios.get(i).getId()%>">
                    <input type="hidden" name="email" value="<%=funcionarios.get(i).getEmail()%>">
                    <input type="hidden" name="empresa" value="nao">
                    <div class="flexText">
                        <button type="submit" class="delete-button modal-delbutton">Deletar</button>
                        <div onclick="closeDelModal(<%=i%>)" class="delCancel">Cancelar</div>
                    </div>
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
<%
    //            Adquirindo os dados do usuário atual
    funcionarios = fdao.selectFiltro(empresaid,"id",String.valueOf(funcionarioid));
    Funcionario usuario = funcionarios.get(0);
%>
<div id="modal-troca" class="modal modal-troca">
    <div class="del-content troca-content">
        <span class="close" onclick="closeTrocaModal()">&times;</span>
        <h1>Trocar Senha</h1>
        <form action="servletAlterarUsuario" method="post" class="delete-form troca-form">
            <input type="hidden" name="id" value="<%=funcionarioid%>">
            <input type="hidden" name="nome" value="<%=usuario.getNome()%>">
            <input type="hidden" name="sobrenome" value="<%=usuario.getSobrenome()%>">
            <input type="hidden" name="telefone" value="<%=usuario.getTelefone()%>">
            <input type="hidden" name="email" value="<%=usuario.getEmail()%>">
            <input type="hidden" name="permissao" value="<%=usuario.isPrioridade()%>">
            <input type="hidden" id="senhaat" name="senha" value="<%=usuario.getSenha()%>>">
            <input type="hidden" name="empresa" value="nao">
            <div class="form-group">
                <label for="atSenha">Senha atual:</label>
                <input type="password" id="atSenha" name="atSenha" placeholder="Digite a senha atual" required>
            </div>
            <div class="form-group">
                <label for="nvSenha">Senha nova:</label>
                <input type="password" id="nvSenha" name="nvSenha" placeholder="Digite a senha nova" required>
            </div>
            <div class="form-group">
                <label for="cfSenha">Confirmar senha:</label>
                <input type="password" id="cfSenha" name="cfSenha" placeholder="Confirme a senha" required>
            </div>
            <div class="flexText">
                <button type="submit" class="delete-button modal-trocaButton">Trocar</button>
                <div onclick="closeTrocaModal()" class="delCancel trCancel">Cancelar</div>
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
    function openDelModal(id) {
        document.getElementById('del-modal'+id).style.display = 'flex';
    }
    function openTrocaModal() {
        document.getElementById('modal-troca').style.display = 'flex';
    }
    // FUNÇÃO PARA FECHAR O MODAL DE INSERÇÃO DE USUÁRIO E DELETAR USUÁRIO
    function closeInsertModal() {
        // aqui ele pega o valor do modal e troca o display para none, ou seja, fecha
        document.getElementById('insertModal').style.display = 'none';
    }
    function closeDelModal(id) {
        document.getElementById('del-modal'+id).style.display = 'none';
    }
    function closeTrocaModal() {
        document.getElementById('modal-troca').style.display = 'none';
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
    window.onclick = function(event,id) {
        // pega o modal pelo id e coloca em uma constante que nunca muda (const)
        const modal = document.getElementById('del-modal'+id);
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

    //puxando a senha atual
    const senha = document.getElementById('senhaat')
    // função para verificação da senha
    function verificacaoDeSenha(senha){
        const senhaInput = document.getElementById('atSenha').value;
        if(senhaInput !== senha.value){
            alert("Senha atual incorreta!");
            return false;
        }
        return true;
    }
</script>
</body>
</html>