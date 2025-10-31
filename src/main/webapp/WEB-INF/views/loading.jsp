<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
    .loading-overlay {
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background: linear-gradient(135deg, #0a1a2e 0%, #16213e 50%, #1a0f2e 100%);
        display: none;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        z-index: 9999;
        transition: opacity 0.5s ease, visibility 0.5s ease;
    }

    .loading-overlay.active {
        display: flex;
        opacity: 1;
        visibility: visible;
    }

    .loading-overlay.hidden {
        opacity: 0;
        visibility: hidden;
    }

    .loading-spinner {
        width: 80px;
        height: 80px;
        border: 4px solid rgba(191, 0, 255, 0.3);
        border-top: 4px solid #bf00ff;
        border-radius: 50%;
        animation: spin 1s linear infinite;
        margin-bottom: 20px;
    }

    .loading-logo {
        width: 60px;
        height: 60px;
        margin-bottom: 15px;
        border-radius: 50%;
        object-fit: cover;
    }

    .loading-text {
        color: #ffffff;
        font-family: 'Montserrat', sans-serif;
        font-size: 18px;
        font-weight: 600;
        text-align: center;
        background: linear-gradient(90deg, #bf00ff, #6a00ff, #0099ff);
        -webkit-background-clip: text;
        -webkit-text-fill-color: transparent;
        background-clip: text;
    }

    .loading-dots {
        display: inline-block;
        animation: dots 1.5s infinite;
    }

    .loading-iframe {
        position: absolute;
        width: 0;
        height: 0;
        border: none;
        opacity: 0;
    }

    @keyframes spin {
        0% { transform: rotate(0deg); }
        100% { transform: rotate(360deg); }
    }

    @keyframes dots {
        0%, 20% { opacity: 0; }
        50% { opacity: 1; }
        100% { opacity: 0; }
    }
</style>

<div class="loading-overlay" id="loadingOverlay">
    <img src="${pageContext.request.contextPath}/img/logoOFC.png" alt="PuraQuality" class="loading-logo">
    <div class="loading-spinner"></div>
    <div class="loading-text">
        Processando<span class="loading-dots">...</span>
    </div>
</div>

<iframe id="loadingIframe" class="loading-iframe" name="loadingIframe"></iframe>

<script>
    // Funções globais para controle do loading
    function showLoading() {
        const loadingOverlay = document.getElementById('loadingOverlay');
        if (loadingOverlay) {
            loadingOverlay.classList.add('active');
            loadingOverlay.classList.remove('hidden');
        }
    }

    function hideLoading() {
        const loadingOverlay = document.getElementById('loadingOverlay');
        if (loadingOverlay) {
            loadingOverlay.classList.add('hidden');
            setTimeout(() => {
                loadingOverlay.classList.remove('active');
            }, 500);
        }
    }

    // Intercepta todos os forms da página
    document.addEventListener('DOMContentLoaded', function() {
        // Intercepta todos os formulários
        const forms = document.querySelectorAll('form');
        forms.forEach(form => {
            form.addEventListener('submit', function(e) {
                showLoading();

                // Se o form tem target, usa o iframe
                if (!form.target || form.target === '_self') {
                    form.target = 'loadingIframe';
                }

                // Desabilita botões de submit
                const submitButtons = form.querySelectorAll('button[type="submit"], input[type="submit"]');
                submitButtons.forEach(button => {
                    button.disabled = true;
                    if (button.tagName === 'BUTTON') {
                        const originalText = button.textContent;
                        button.textContent = 'Processando...';
                        button.setAttribute('data-original-text', originalText);
                    }
                });
            });
        });

        // Intercepta links que levam para ações (que não são âncoras)
        const links = document.querySelectorAll('a[href]:not([href^="#"]):not([href^="javascript:"])');
        links.forEach(link => {
            link.addEventListener('click', function(e) {
                // Só mostra loading se for um link interno (que não abre nova aba)
                if (!link.target || link.target === '_self') {
                    showLoading();

                    // Adiciona timeout para garantir que a navegação ocorra
                    setTimeout(() => {
                        hideLoading();
                    }, 3000); // Fallback de 3 segundos
                }
            });
        });
    });

    // Monitora o iframe para saber quando o carregamento terminou
    document.getElementById('loadingIframe').addEventListener('load', function() {
        // Quando o iframe carrega (form submetido), esconde o loading
        setTimeout(hideLoading, 500);
    });

    // Fallback: esconde loading se a página for recarregada
    window.addEventListener('beforeunload', function() {
        hideLoading();
    });

    // Esconde loading quando a página carrega completamente
    window.addEventListener('load', function() {
        setTimeout(hideLoading, 1000);
    });
</script>