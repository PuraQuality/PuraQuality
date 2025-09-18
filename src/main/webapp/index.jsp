<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PuraQuality</title>
    <link rel="icon" href="img/LogoPura.png"/>
    <link rel="stylesheet" href="styles/index.css">
    <!---------------- imports ---------------->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Lexend+Giga:wght@100..900&display=swap" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
</head>
<body>
    <main class="corpo">
        <!-- BACKGROUND -->
            <img class="bola_cromo" src="img/bola_cromo.png" alt="">
            <img class="bola_cromo2" src="img/bola_cromo2.png" alt="">
            <img class="celular" src="img/celula.png" alt="">
            <img class="faixa" src="img/faixa_cima.png" alt="">
            <div class="led-glow-container">
                <div class="led-glow pulsing"></div>
              </div>
            <div class="led-container">
                <div class="led"></div>
            </div>
        <!-- CABEÇALHO DO SITE -->
        <header class="cabecalho">
            <div class="logo-cont">
                <img class="logo" src="img/LogoPura.png" alt="PuraQuality">
            </div>
            <div class="navegacao-cont">
                <nav class="navegacao">
                    <a class="planos_link" href="#planos_pg"><div class="pb">Planos</div></a>
                    <a class="sobre_link" href="#"><div class="sb">Sobre</div></a>
                </nav>
            </div>
                <a class="login_link" href="LoginSingUp/login.jsp"><div class="lb">Login</div></a>
        </header>
        <!-- CORPO DO SITE -->
        <section class="cont1">
            <p class="titulo-pura" style="font-family: lexend Giga; ">PuraQuality</p>
            <p class="texto-inicio" style="font-family: montserrat;">Com o processo certo, todo problema tem solução</p> 
            <a class="botao-inicio" style="font-family: montserrat;" href="#planos_pg"><div class="bi">Transforme sua industria</div></a>
        </section>
        <section id="cont2" class="cont2">
            
        </section>
        <section id="planos_pg" class="planos_pg">
            <div class="plano1"></div>
            <div class="plano2"></div>
            <div class="plano3"></div>
        </section>
    </main>
    <footer class="footer">
        preto
    </footer>
</body>
</html>
