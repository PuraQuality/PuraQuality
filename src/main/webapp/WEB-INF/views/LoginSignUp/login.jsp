<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="icon" href="${pageContext.request.contextPath}/img/logoOFC.png">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/login.css?v=<%= System.currentTimeMillis() %>">
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
        <img class="homeButton" src="${pageContext.request.contextPath}/img/homeButton.png" alt="homeButton">
      <h1 class="texto_pura">PuraQuality</h1>
    </a>
    <h1 class="texto_bv" >Bem-vindo de volta</h1>
      <form class="form" action="servletLogin" method="post">
        <div class="form-group">
            <div class="inputs">
              <input class="inputUser" type="email" id="email" name="emailfuncionario" placeholder=" " required />
              <label for="email" id="labelinput" class="labelinput">Email</label>
              <input class="inputUser" type="password" id="senha" name="senha" placeholder=" " required />
              <label for="senha" id="labelinput" class="labelinput">Senha</label>
            </div>
            <button class="botao" type="submit">Entrar</button>
        </div>
        </form>
    </div>
    <img class="notebook" src="${pageContext.request.contextPath}/img/notebookLogin.png" alt="notebook">
    <img class="bola_cromo" src="${pageContext.request.contextPath}/img/bola_cromo.png" alt="bola_cromo">
    <img class="bola_cromo2" src="${pageContext.request.contextPath}/img/bola_cromo3.png" alt="bola_cromo2">
</body>
</html>