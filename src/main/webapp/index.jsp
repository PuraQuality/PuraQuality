<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PuraQuality</title>
    <link rel="icon" href="${pageContext.request.contextPath}/img/logoOFC.png"/>
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
    <img class="celular" src="img/celularPQ.png" alt="">
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
                <a class="sobre_link" href="#"><div class="sb">Sobre</div></a>
            </nav>
        </div>
        <a class="login_link" href="${pageContext.request.contextPath}/LoginSignUp/login.jsp"><div class="lb">Login</div></a>
    </header>
    <!-- CORPO DO SITE -->
    <section class="contLanding">
        <p class="titulo-pura" style="font-family: lexend Giga; ">PuraQuality</p>
        <p class="texto-inicio" style="font-family: montserrat;">Com o processo certo, todo problema tem solução</p>
        <a class="botao-inicio" style="font-family: montserrat;" href="#planos_pg"><div class="bi">Transforme sua industria</div></a>
    </section>
    <section id="contPrincipal" class="contPrincipal">
        <div class="gridTexto">
        <div class="quemSomos">
            <h1>Quem somos?</h1>
            <p>A Magna é uma empresa comprometida com a inovação e a sustentabilidade, alinhada aos princípios da ODS 9. Dedicamo-nos a desenvolver soluções inteligentes para o controle e aprimoramento da qualidade, atendendo indústrias de pequeno a grande porte. Gerenciamos o PuraQuality, um aplicativo que facilita o monitoramento e a gestão da qualidade dos produtos, promovendo eficiência, produtividade e excelência operacional em cada processo.</p>
        </div>
        <div class="gridFunc">
            <div class="card">
                <h1 class="tituloFunc">O que fazemos?</h1>
                <p>Nosso aplicativo otimiza os processos empresariais de ponta a ponta — do recebimento à expedição.    Atuamos na identificação e solução das causas raiz dos problemas operacionais, garantindo mais eficiência, controle e produtividade em toda a cadeia de processos.</p>
            </div>
            <div class="card">
                <h1 class="tituloFunc2">Como fazemos?</h1>
                <p>Unimos feedbacks e relatórios de qualidade em uma base única, analisada por uma IA treinada.     Ela identifica falhas e oportunidades de melhoria, gerando um relatório em PDF com insights e soluções práticas para otimizar o desempenho da empresa.</p>
            </div>
        </div>

        <p class="conexo">Nosso processo é dinâmico e adaptável, ajustando-se a cada situação para identificar e resolver problemas de forma precisa e contínua.</p>

        <div class="setores">
            <div class="cardSet">
                <h1 class="tituloSet">
                    Setores que atendemos
                </h1>
                <p>
                    Atendemos indústrias de diversos setores, como automotivo, tecnológico, suinocultura, bovinocultura, entre outros. <br>Nosso aplicativo se adapta a diferentes portes e realidades empresariais, mas é especialmente projetado para indústrias de médio e grande porte que buscam otimizar seus processos e alcançar maior eficiência operacional.
                </p>
            </div>
            <img class="imgPredio" src="img/imgpredio.png" alt="imgpredio">
        </div>
        <div class="ODS">
            <div class="cardIMG">
                <img class="ODSimg" src="img/ODSimg.png" alt="ODSimg">
                <div class="ledODS"></div>
            </div>
            <div class="cardODS">
                <h1 class="ODSconc">
                    Como nos conectamos com a
                </h1>
                <h1 class="ODStitulo">
                    ODS
                </h1>
                <p class="exp">Nosso projeto se alinha à ODS 9 ao integrar práticas de controle de qualidade que fortalecem a inovação e a eficiência produtiva. Atuamos especialmente nos seguintes objetivos e metas:</p>
                <div class="gridODS">
                    <div class="cardMetas">
                        <img class="imgMeta" src="img/91.png" alt="img9.1">
                        <p><span style="color: darkred;">9.1</span> - Desenvolver infraestruturas de qualidade, confiáveis e sustentáveis</p>
                    </div>
                    <div class="cardMetas">
                        <img class="imgMeta" src="img/95.png" alt="img9.5">
                        <p><span style="color: darkgreen;">9.5</span> - Aumentar a pesquisa científica e melhorar a capacidade tecnológica industrial</p>
                    </div>
                    <div class="cardMetas">
                        <img class="imgMeta" src="img/94.png" alt="img9.4">
                        <p><span style="color: darkgoldenrod;">9.4</span> - Modernizar infraestruturas e tornar as indústrias mais sustentáveis</p>
                    </div>
                    <div class="cardMetas">
                        <img class="imgMeta" src="img/9c.png" alt="img9.c">
                        <p><span style="color: #118FB9;">9.c</span> - Aumentar o acesso à tecnologia da informação e comunicação</p>
                    </div>
                </div>
                <p class="ODSfinal">Com essas ações, fortalecemos a confiabilidade dos produtos e serviços, promovendo um ambiente industrial mais inovador, sustentável e eficiente.</p>
            </div>
        </div>
        <div class="sixS">
            <h1>Como utilizamos a metodologia <strong>Six Sigma</strong>?</h1>
            <div class="gridSix">
                <p>Aplicamos o Six Sigma para identificar, analisar e corrigir falhas nos processos de fabricação, reduzindo defeitos e elevando a qualidade dos produtos.</p>
                <div class="imgSix">
                    <img class="roda" src="img/rodaSix.png" alt="SixSgima">
                    <img class="smbSS" src="img/SSimg.png" alt="SixSgima">
                </div>
                <p>
                    Combinado à nossa Inteligência Artificial e ao método Kanban, garantimos uma gestão da qualidade mais eficiente, integrada e contínua, alinhada aos padrões das indústrias de alto desempenho.
                </p>
            </div>
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
    <h1 class="textoFooter">Conheça o nosso time!!</h1>
    <div class="cardOverflow">
        <div class="cardOver">1</div>
        <div class="cardOver">2</div>
        <div class="cardOver">3</div>
        <div class="cardOver">4</div>
        <div class="cardOver">5</div>
        <div class="cardOver">6</div>
    </div>
</footer>
<script>
    const quality_link = document.getElementById('quality_link');
    quality_link.addEventListener('click', () => {
        window.location.href = 'LoginSignUp/signUp.jsp';
    });
</script>
</body>
</html>