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
          <img class="homeButton" src="${pageContext.request.contextPath}/img/homeButton.png" alt="homeButton" />
        <h1 class="texto_pura">PuraQuality</h1>
      </a>
      <h1 class="texto_bv">Comece agora conosco</h1>
        <form class="form" action="#" method="post" onsubmit="return validarFormulario()">
            <div class="form-group">
                <div class="inputs">
                    <input type="email" id="email" name="email" placeholder="Digite seu CNPJ" required />
                    <input type="email" id="email_empresa" name="empresa" placeholder="Digite o email da sua empresa" required />
                    <input type="password" id="senha" name="senha" placeholder="Digite sua senha" required />
                    <input type="password" id="confirm_senha" name="senha" placeholder="Confirme sua senha" required />
                </div>
                <button class="botao" type="submit">Entrar</button>
            </div>
        </form>
      <img class="celular" src="${pageContext.request.contextPath}/img/celularSolo.png" alt="celular">
      <img class="bola_cromo" src="${pageContext.request.contextPath}/img/bola_cromo.png" alt="bola_cromo">
      <img class="bola_cromo2" src="${pageContext.request.contextPath}/img/bola_cromo3.png" alt="bola_cromo2">
        <!-- JAVA SCRIPT -->
        <script>
            // valida se está tudo certo para o envio do formulário
            function validarFormulario() {
                // instanciando variáveis constantes pelo id
                const senha = document.getElementById('senha').value.trim();
                const confirm_senha = document.getElementById('confirm_senha').value.trim();
                // chekando se as senhas estão iguais
                if(senha == confirm_senha){
                    return true;
                } else{
                    alert('algumas das informações não coincidem.');
                    return false;
                } // Permite o envio do formulário
            }
        </script>
</body>
</html>