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
      <a class="link_pura" href="${pageContext.request.contextPath}/index.html">
          <img class="homeButton" src="${pageContext.request.contextPath}/img/homeButton.png" alt="homeButton" />
        <h1 class="texto_pura">PuraQuality</h1>
      </a>
      <h1 class="texto_bv">Comece agora conosco</h1>
        <form class="form" action="/servletCadastro" method="post">
            <div class="form-group">
                <div class="inputs">
                    <input type="text" id="cnpj" name="email" placeholder="Digite seu CNPJ" required />
                    <input type="email" id="email" name="empresa" placeholder="Digite o email da sua empresa" required />
                    <input type="email" id="nomeEmpresa" name="nome" placeholder="Digite o nome da sua empresa" required />
                    <input type="text" id="setor" name="setor" placeholder="Digite o setor da sua empresa" required>
                    <input type="tel" id="tel" name="tel" placeholder="Digite o telefone da sua empresa" required>
                    <input type="password" id="senha" name="senha" placeholder="Digite uma senha" required />

                </div>
                <button class="botao" type="submit">Cadastrar</button>
            </div>
        </form>
      <img class="celular" src="${pageContext.request.contextPath}/img/celularSolo.png" alt="celular">
      <img class="bolaC" src="${pageContext.request.contextPath}/img/bola_cromo.png" alt="bola_cromo">
      <img class="bolaC2" src="${pageContext.request.contextPath}/img/bola_cromo3.png" alt="bola_cromo2">
</body>
</html>