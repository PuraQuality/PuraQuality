<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.model.Empresa" %>
<%@ page import="com.dao.EmpresaDao" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ADM SUPREMO - Dashboard</title>
    <link rel="icon" href="${pageContext.request.contextPath}/img/logoOFC.png">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/puraquality.css?v=<%= System.currentTimeMillis() %>">
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
        <span class="dashboard-label">ADM SUPREMO - Dashboard</span>
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
            <option value="setor">Setor</option>
            <option value="cnpj">CNPJ</option>
            <option value="email">Email</option>
            <option value="plano_id">Plano</option>
        </select>
        <div class="search-input-wrapper">
            <input type="text" name="filtro" class="search-input" placeholder="O que procura?" value="<%=(request.getSession().getAttribute("filtro") != null) ? request.getSession().getAttribute("filtro") : ""%>">
            <button type="submit" class="search-button" aria-label="Search">
                <i class="fas fa-search"></i>
            </button>
        </div>
        <input type="hidden" name="tabela" value="puraquality">
    </form>
    <button class="insert-button" onclick="openInsertModal()">
        <i class="fas fa-plus"></i> Inserir Empresa
    </button>
</div>

<!-- Data Table -->
<div class="table-container">
    <table>
        <thead>
        <tr>
            <th>Nome</th>
            <th>Setor</th>
            <th>CNPJ</th>
            <th>Email</th>
            <th>Plano</th>
            <th class="action-column">Alterar Plano</th>
            <th class="action-column">Deletar Empresa</th>
        </tr>
        </thead>
        <tbody>
        <%
            EmpresaDao edao = new EmpresaDao();
            List<Empresa> empresas;
            String coluna = request.getParameter("coluna");
            String filtro = (String) request.getSession().getAttribute("filtro");

            if(filtro == null || filtro.isEmpty()){
                empresas = edao.select();
            } else {
                empresas = edao.selectFiltro(coluna, filtro);
            }
            for(int i = 0; i < empresas.size(); i++){%>
        <tr>
            <td><%=empresas.get(i).getNome()%></td>
            <td><%=empresas.get(i).getSetor()%></td>
            <td><%=empresas.get(i).getCnpj()%></td>
            <td><%=empresas.get(i).getEmail()%></td>
            <td><%=empresas.get(i).getPlano()%></td>
            <td class="action-column">
                <form method="POST" action="servletAlterarEmpresa" class="update-form">
                    <select name="altplano" id="altplano-<%=i%>">
                        <option value="10">Quality</option>
                        <option value="11" <%=(empresas.get(i).getPlanoId() == 11)?"selected":""%>>FullQuality</option>
                        <option value="12" <%=(empresas.get(i).getPlanoId() == 12)?"selected":""%>>PuraQuality</option>
                    </select>
                    <input type="hidden" name="empId" value="<%=empresas.get(i).getId()%>">
                    <input type="hidden" name="tabela" value="puraquality">
                    <button type="submit" class="update-button">Alterar</button>
                </form>
            </td>
            <td class="action-column">
                <div class="delete-form">
                    <button type="button" class="delete-button" onclick="openDelModal('<%=empresas.get(i).getId()%>', '<%=empresas.get(i).getNome()%>')">Deletar</button>
                </div>
            </td>
        </tr>
        <%}%>
        </tbody>
    </table>
</div>

<!-- Delete Modal -->
<div id="del-modal" class="modal-del">
    <div class="del-content">
        <span class="close" onclick="closeDelModal()">&times;</span>
        <h1>Você tem certeza?</h1>
        <p id="del-message">Você tem certeza que quer deletar esta empresa?</p>
        <form action="servletDeletarEmpresa" method="post" class="delete-form" id="del-form">
            <input type="hidden" name="idempresa" id="del-id">
            <div class="flexText">
                <button type="submit" class="delete-button modal-delbutton">Deletar</button>
                <div onclick="closeDelModal()" class="delCancel">Cancelar</div>
            </div>
        </form>
    </div>
</div>

<!-- Insert Modal -->
<div id="insertModal" class="modal">
    <div class="modal-content">
        <span class="close" onclick="closeInsertModal()">&times;</span>
        <h2>Inserir Nova Empresa</h2>
        <form action="servletInserirEmpresa" method="post">
            <div class="formCard">
                <div class="form-group">
                    <label for="nome">Nome:</label>
                    <input type="text" id="nome" name="nome" placeholder="Digite o nome da empresa" required>
                </div>
                <div class="form-group">
                    <label for="setor">Setor:</label>
                    <input type="text" id="setor" name="setor" placeholder="Digite o setor da empresa" required>
                </div>
                <div class="form-group">
                    <label for="tel">Telefone:</label>
                    <input type="tel" id="tel" name="tel" placeholder="Digite o telefone da empresa" required>
                </div>
            </div>
            <div class="formCard">
                <div class="form-group">
                    <label for="cnpj">CNPJ:</label>
                    <input type="text" id="cnpj" name="cnpj" placeholder="Digite o CNPJ da empresa" required>
                </div>
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email" placeholder="Digite o email da empresa" required>
                </div>
            </div>
            <div class="formCard">
                <div class="form-group">
                    <label for="senha">Senha:</label>
                    <input type="password" id="senha" name="senha" placeholder="Digite a senha da empresa" required>
                </div>
                <div class="form-group">
                    <label for="plano">Plano:</label>
                    <select id="plano" name="plano" class="plano-select">
                        <option value="10">Quality</option>
                        <option value="11">FullQuality</option>
                        <option value="12">PuraQuality</option>
                    </select>
                </div>
            </div>
            <div class="modal-buttons">
                <button type="submit" class="btn-submit">Inserir Empresa</button>
                <button type="button" class="btn-cancel" onclick="closeInsertModal()">Cancelar</button>
            </div>
        </form>
    </div>
</div>

<script>
    // FUNÇÃO PARA ABRIR O MODAL DE INSERÇÃO DE EMPRESA
    function openInsertModal() {
        document.getElementById('insertModal').style.display = 'flex';
    }

    // FUNÇÃO PARA FECHAR O MODAL DE INSERÇÃO DE EMPRESA
    function closeInsertModal() {
        document.getElementById('insertModal').style.display = 'none';
    }

    // FUNÇÃO PARA ABRIR O MODAL DE DELETAR EMPRESA
    function openDelModal(empresaId, empresaNome) {
        document.getElementById('del-modal').style.display = 'flex';
        document.getElementById('del-id').value = empresaId;
        document.getElementById('del-message').textContent =
            'Você tem certeza que quer deletar a empresa ' + empresaNome + '?';
    }

    // FUNÇÃO PARA FECHAR O MODAL DE DELETAR EMPRESA
    function closeDelModal() {
        document.getElementById('del-modal').style.display = 'none';
    }

    // FECHAR O MODAL QUANDO CLICAR FORA DELE
    window.onclick = function(event) {
        const insertModal = document.getElementById('insertModal');
        const delModal = document.getElementById('del-modal');

        if (event.target == insertModal) {
            insertModal.style.display = 'none';
        }
        if (event.target == delModal) {
            delModal.style.display = 'none';
        }
    }
</script>
</body>
</html>