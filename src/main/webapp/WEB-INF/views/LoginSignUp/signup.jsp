<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up</title>
    <link rel="icon" href="${pageContext.request.contextPath}/img/LogoPura.png">
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
        <form class="form" action="/servletCadastro" method="post">
            <div class="form-group">
                <div class="inputs">
                    <input type="text" id="cnpj" name="cnpj" placeholder="Digite seu CNPJ" maxlength="18" required />
                    <input type="email" id="email" name="empresa" placeholder="Digite o email da sua empresa" required />
                    <input type="text" id="nomeEmpresa" name="nome" placeholder="Digite o nome da sua empresa" required />
                    <input type="text" id="setor" name="setor" placeholder="Digite o setor da sua empresa" required>
                    <input type="tel" id="tel" name="tel" placeholder="Digite o telefone da sua empresa" required>
                    <input type="password" id="senha" name="senha" placeholder="Digite uma senha" required />
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
        const senha = document.getElementById('senha')
        const email = document.getElementById('email')
        const tel = document.getElementById('tel')

        // setando os regex
        const regexSenha = /^(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%&])(?=.*[a-z])[a-zA-Z0-9@#$%&]{8,100}$/;
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
            }
            if (!regexEmail.test(email.value)) {
                erros.push("E-mail inválido. Exemplo: empresa@dominio.com.br");
            }
            if (!regexSenha.test(senha.value)) {
                erros.push("Senha inválida. Deve ter 8-100 caracteres, maiúscula, minúscula, número e símbolo (@#$%&)");
            }
            if (!regexTelefone.test(tel.value)) {
                erros.push("Telefone inválido. Exemplo: (11) 98765-4321");
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
        
      </script>
</body>
</html>