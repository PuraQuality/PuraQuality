<%@ page isErrorPage="true" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>ERROR</title>
  <link rel="icon" href="img/logoOFC.png" />
  <link rel="stylesheet" type="text/css" href="styles/error.css" />

  <!-- Google Fonts -->
  <link rel="preconnect" href="https://fonts.googleapis.com" />
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
  <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet" />
  <link href="https://fonts.googleapis.com/css2?family=Jersey+25&display=swap" rel="stylesheet">
</head>
<body>
<div class="container">
  <h1>Página não encontrada</h1>
  <div class="alert-icon">
    <img src="img/alerta.png" alt="Alerta!" />
  </div>
  <p>Página não encontrada.
      Verifique o endereço ou volte para a página inicial</p>
  <a href="${pageContext.request.contextPath}/index.html" class="btn-voltar">Voltar para página inicial</a>
</div>
</body>
</html>