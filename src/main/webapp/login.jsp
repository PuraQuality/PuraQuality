<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="icon" href="img/LogoPura.png">
    <link rel="stylesheet" href="styles/login.css">
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
      <a class="link_pura" href="index.jsp">
        <h1 class="texto_pura">PuraQuality</h1>
      </a>
      <h1 class="texto_bv" >Bem-vindo de volta</h1>
      <button class="google_button">
        <img class="img_google" src="img/google_logo.png" alt="google">
        <p class="texto_google">Entrar com o google</p>
      </button>
      <div class="divider-container">
      <div class="divider divider2"></div><p class="divider_text">or<p><div class="divider"></div>
      </div>
        <form class="form" action="#" method="post" onsubmit="return validarFormulario()">
          <div class="form-group">
              <div class="inputs">
                <input type="email" id="email" name="email" placeholder="Digite seu email" required />
                <input type="password" id="senha" name="senha" placeholder="Digite sua senha" required />
                <input type="password" id="confirm_senha" name="senha" placeholder="Confirme sua senha" required />
              </div>
              <button class="botao" type="submit">Entrar</button>
              <p class="sing_up">Ainda não tem uma conta? <a class="sing_A" href="singup.jsp">cadastre-se</a></p>
          </div>
          </form>
      </div>
      <img class="notebook" src="img/notebook.png" alt="notebook">
      <img class="bola_cromo" src="img/bola_cromo.png" alt="bola_cromo">
      <img class="bola_cromo2" src="img/bola_cromo3.png" alt="bola_cromo2">
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