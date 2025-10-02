<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PuraQuality</title>
    <link rel="icon" href="${pageContext.request.contextPath}/img/LogoOFC.png"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/index.css?v=<%= System.currentTimeMillis() %>">
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
            <img class="logo" src="img/logoOFC.png" alt="PuraQuality">
        </div>
        <div class="navegacao-cont">
            <nav class="navegacao">
                <a class="planos_link" href="#planos_pg"><div class="pb">Planos</div></a>
                <a class="sobre_link" href="#"><div class="sb">Sobre</div></a>
            </nav>
        </div>
        <a class="login_link" href="${pageContext.request.contextPath}/LoginSignUp/login.jsp"><div class="lb">Login</div></a>
    </header>
    <!-- CORPO DO SITE -->
    <section class="cont1">
        <p class="titulo-pura" style="font-family: lexend Giga; ">PuraQuality</p>
        <p class="texto-inicio" style="font-family: montserrat;">Com o processo certo, todo problema tem solução</p>
        <a class="botao-inicio" style="font-family: montserrat;" href="#planos_pg"><div class="bi">Transforme sua industria</div></a>
    </section>
    <section id="cont2" class="cont2">
        <div class="gridTexto">
            <div class="card">
                <h1 class="tituloPrincipal">O que fazemos?</h1>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Natus eaque repellendus dicta. Impedit totam quae, molestias assumenda deserunt unde voluptate, repellendus veniam, accusamus facilis debitis? Doloribus minus incidunt necessitatibus deleniti?</p>
            </div>
            <div class="card">
                <h1 class="tituloPrincipal2">Como fazemos?</h1>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Tempora impedit vitae eveniet molestiae nam aliquam adipisci pariatur qui debitis nihil. Esse neque explicabo nobis cum laboriosam, ratione totam dolorum aspernatur!</p>
            </div>
        </div>
        <div class="textoConexo">
            <h1 class="tituloConexo">Nosso processo gira como uma bola e se adapta como uma cobra</h1>
            <p class="conexo">Logo, toda vez que ouver um problema dentro da indústria vamos partir do ponto em que o problema se iniciou e fazer com que todo o processo se adapate, como uma cobra se adapta ao terreno que passa</p>
        </div>
    </section>
</main>
<section id="planos_pg" class="planos_pg">
    <!-- Background estático - não se move com hovers -->
    <div class="background_static">
        <!-- Aqui você pode adicionar suas divs e imagens de background -->
        <div class="ledBola"></div>
        <img class="bola" src="img/bolaGira.png" alt="">
        <img id="bolaPg" class="bolaPg" src="img/bola_cromo.png" alt="">
        <img id="bolaPg" class="bolaPg2" src="img/bola_cromo2.png" alt="">
        <img id="bolaPg" class="bolaPg3" src="img/bola_cromo3.png" alt="">
    </div>
    <div class="plano1">
        <h2 class="quality">Quality</h2>
        <p class="quality_p">R$999,00/mês</p>
        <a class="quality_link" id="quality_link" href="">
            <div class="quality_div">???</div>
        </a>
        <ul type="none">
            <li>Análise completa de processos</li>
            <li>Relatórios detalhados</li>
            <li>Suporte 24/7</li>
            <li>Dashboard interativo</li>
            <li>Integração com sistemas</li>
            <li>Backup automático</li>
            <li>Atualizações mensais</li>
            <li>Treinamento da equipe</li>
        </ul>
    </div>
    <div class="plano2">
        <h2 class="quality2">FullQuality</h2>
        <p class="quality_p2">R$2490,90/mês</p>
        <a class="quality_link2" id="quality_link" href="">
            <div class="quality_div2">???</div>
        </a>
        <ul type="none">
            <li>Análise completa de processos</li>
            <li>Relatórios detalhados</li>
            <li>Suporte 24/7</li>
            <li>Dashboard interativo</li>
            <li>Integração com sistemas</li>
            <li>Backup automático</li>
            <li>Atualizações mensais</li>
            <li>Treinamento da equipe</li>
        </ul>
    </div>
    </div>
    <div class="plano3">
        <h2 class="quality3">PuraQuality</h2>
        <p class="quality_p3">R$4290,90/mês</p>
        <a class="quality_link3" id="quality_link" href="">
            <div class="quality_div3">???</div>
        </a>
        <ul type="none">
            <li>Análise completa de processos</li>
            <li>Relatórios detalhados</li>
            <li>Suporte 24/7</li>
            <li>Dashboard interativo</li>
            <li>Integração com sistemas</li>
            <li>Backup automático</li>
            <li>Atualizações mensais</li>
            <li>Treinamento da equipe</li>
        </ul>
    </div>
</section>
<footer class="footer">
    preto
</footer>
<script>
    const quality_link = document.getElementById('quality_link');
    quality_link.addEventListener('click', () => {
        window.location.href = '/LoginSingUp/login.html';
    });
</script>
</body>
</html>