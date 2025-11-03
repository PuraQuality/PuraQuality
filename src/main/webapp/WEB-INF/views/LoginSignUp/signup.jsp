<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/error.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up</title>
    <link rel="icon" href="${pageContext.request.contextPath}/img/logoOFC.png">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/signup.css">
    <!---------------- imports ---------------->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Lexend+Giga:wght@100..900&display=swap" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
</head>
<body>
  <!-- CORPO DO SITE -->
    <div class="container-geral">
      <a class="link_pura" href="${pageContext.request.contextPath}/index.html">+
          <img class="homeButton" src="${pageContext.request.contextPath}/img/homeButton.png" alt="homeButton" />
        <h1 class="texto_pura">PuraQuality</h1>
      </a>
      <h1 class="texto_bv">Comece agora conosco</h1>
      <form class="form" action="servletCadastro" method="post">
        <div class="form-group">
            <div class="inputs">
                <div class="input-container">
                    <input type="text" id="cnpj" name="cnpj" maxlength="18" required placeholder=" " />
                    <label for="cnpj" class="labelcnpj">CNPJ EX: 12.345.678/0001-09</label>
                </div>
                <div class="input-container">
                    <input type="email" id="email" name="empresa" required placeholder=" " />
                    <label for="email" class="labelemail">Email:</label>
                </div>
                <div class="input-container">
                    <input type="text" id="nomeEmpresa" name="nome" required placeholder=" " />
                    <label for="nome" class="labelnome">Empresa:</label>
                </div>
                <div class="input-container">
                    <input type="text" id="setor" name="setor" required placeholder=" " />
                    <label for="setor" class="labelsetor">Setor:</label>
                </div>
                <div class="input-container">
                    <input type="tel" id="tel" name="tel" required placeholder=" " />
                    <label for="tel" class="labeltel">Telefone EX: (55) 12345-6789</label>
                </div>
                <div class="input-container">
                    <input type="password" id="senha" name="senha" required placeholder=" " />
                    <label for="senha" class="labelsenha">Senha:</label>
                    <button id="verSenha" class="ver"
                    style="width: 25px;
                      height: 25px;
                      cursor: pointer;
                      border: none;
                      border-radius: 5px;
                      color: var(--text-muted);
                      background-color: #bf00ff;
                      transition: all 0.3s ease;
                      position:relative;
                      right: 40px">🙈</button>
                </div>
            </div>
            <button class="botao" type="submit" id="botao">Cadastrar</button>
        </div>
    </form>

        <!-- Modal de Erros -->
        <div id="modal-erros" class="modal">
          <div class="modal-content">
              <span class="close">&times;</span>
              <h2>Erros de Validação:</h2>
              <ul id="lista-erros"></ul>
          </div>
        </div>
      <img class="celular" src="${pageContext.request.contextPath}/img/celularSolo.png" alt="celular">
      <img class="bolaC" src="${pageContext.request.contextPath}/img/bola_cromo.png" alt="bola_cromo">
      <img class="bolaC2" src="${pageContext.request.contextPath}/img/bola_cromo3.png" alt="bola_cromo2">
      <script>
        //puxando botao pelo id
        const botao = document.getElementById('botao')
        // puxando a senha, cnpj e o email pelo id
        const cnpj = document.getElementById('cnpj')
        const email = document.getElementById('email')
        const tel = document.getElementById('tel')
        // setando os regex para validação
        const regexEmail = /[^ ]+@[a-z]+(\.[a-z]+)?(\.com|\.br)/;
        const regexCNPJ = /^\d{2}\.?\d{3}\.?\d{3}\/?\d{4}-?\d{2}$/;
        const regexTelefone = /^(\+55\s?)?(\(?\d{2}\)?\s?)(\d{4,5}\s?-?\d{4})$/;

        // Função que verifica os campos e exibe o modal com os erros
        function validarEExibirErros() {
          // setando uma variável
            let erros = [];
              // verificando os regex e dando push para a lista
            if (!regexCNPJ.test(cnpj.value)) {
                erros.push("CNPJ inválido. Exemplo: 12.345.678/0001-90");
                cnpj.style.borderColor = 'red';
            }
            if (!regexEmail.test(email.value)) {
                erros.push("E-mail inválido. Exemplo: empresa@dominio.com.br");
                email.style.borderColor = 'red';
            }
            if (!regexTelefone.test(tel.value)) {
                erros.push("Telefone inválido. Exemplo: (11) 98765-4321");
                tel.style.borderColor = 'red';
            }
            // se os erros forem maiores que zero, ou seja, tiver quaisquer erros, abre o modal
            if (erros.length > 0) {
                exibirModal(erros); // chama a função para abrir o modal
            } else { // manda o form para o servlet
                console.log("Todos os campos são válidos.");
                document.querySelector('form').submit(); // Submete o formulário se estiver tudo certo
            }
        }

        // Função para exibir o modal com os erros
        function exibirModal(erros) {
          // constantes que nunca mudam, puxando o modal e a lista de erros pelo id
            const modal = document.getElementById('modal-erros');
            const listaErros = document.getElementById('lista-erros');

            // Limpa os erros anteriores
            listaErros.innerHTML = '';

            // Adiciona cada erro à lista
            erros.forEach(erro => {
                const item = document.createElement('li');
                item.textContent = erro;
                listaErros.appendChild(item);
            });

            // Exibe o modal
            modal.style.display = 'block';
        }

        // Fecha o modal quando o usuário clica no "x"
        document.querySelector('.close').addEventListener('click', function() {
            document.getElementById('modal-erros').style.display = 'none';
        });

        // Fecha o modal quando clica fora do conteúdo
        window.addEventListener('click', function(e) {
            const modal = document.getElementById('modal-erros');
            if (e.target === modal) {
                modal.style.display = 'none';
            }
        });

        // Adicionando evento de clique no botão
        botao.addEventListener('click', function(e) {
            e.preventDefault(); // Impede o envio automático
            validarEExibirErros();
        });
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