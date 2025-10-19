<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sing Up</title>
    <link rel="icon" href="${pageContext.request.contextPath}/img/LogoPura.png">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/signup.css">
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
      <a class="link_pura" href="${pageContext.request.contextPath}/index.jsp">
        <h1 class="texto_pura">PuraQuality</h1>
      </a>
      <h1 class="texto_bv">Comece agora conosco</h1>
      <div class="container-form">
          <button class="google_button">
            <img class="img_google" src="${pageContext.request.contextPath}/img/google_logo.png" alt="google">
            <p class="texto_google">Entrar com o google</p>
          </button>
          <div class="divider-container">
          <div class="divider divider2"></div><p class="divider_text">or<p><div class="divider"></div>
          </div>
            <form class="form" action="${pageContext.request.contextPath}/servletCadastro" method="post" onsubmit="return validarFormulario()">
              <div class="form-group">
                  <div class="inputs">
                    <input type="tel" id="email" name="cnpj" placeholder="Digite seu CNPJ (00.000.000/0000-00)" maxlength="18" required />
                    <input type="email" id="email_empresa" name="email" placeholder="Digite o email da sua empresa" required />
                    <input type="password" id="senha" name="senha" placeholder="Digite sua senha" required />
                    <input type="password" id="confirm_senha" name="confirm_senha" placeholder="Confirme sua senha" required />
                  </div>
                  <button class="botao" type="submit">Entrar</button>
              </div>
              </form>
            </div>
      </div>
      <img class="celular" src="${pageContext.request.contextPath}/img/celularSolo.png" alt="celular">
      <img class="bola_cromo" src="${pageContext.request.contextPath}/img/bola_cromo.png" alt="bola_cromo">
      <img class="bola_cromo2" src="${pageContext.request.contextPath}/img/bola_cromo3.png" alt="bola_cromo2">
    <!-- JAVA SCRIPT -->
      <script>
        function validarFormulario() {
          const senha = document.getElementById('senha').value.trim();
          const confirm_senha = document.getElementById('confirm_senha').value.trim();
          if(senha === confirm_senha){
            return true;
          } else{
            alert('algumas das informações não coincidem.');
            return false;
          } // Permite o envio do formulário
        }
      </script>
</body>
</html>