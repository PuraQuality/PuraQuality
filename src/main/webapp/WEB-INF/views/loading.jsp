<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
    .loading-overlay {
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background: linear-gradient(135deg, #0a1a2e 0%, #16213e 50%, #1a0f2e 100%);
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        z-index: 9999;
        transition: opacity 0.5s ease, visibility 0.5s ease;
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
        color: var(--text-light, #ffffff);
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
        Carregando<span class="loading-dots">...</span>
    </div>
</div>

<script>
    // Esconde o loading quando a página terminar de carregar
    window.addEventListener('load', function() {
        const loadingOverlay = document.getElementById('loadingOverlay');
        setTimeout(function() {
            loadingOverlay.classList.add('hidden');
            // Remove completamente do DOM após a animação
            setTimeout(function() {
                loadingOverlay.remove();
            }, 500);
        }, 1000); // 1 segundo de delay para garantir que tudo carregou
    });

    // Mostra o loading imediatamente se a página demorar muito
    document.addEventListener('DOMContentLoaded', function() {
        const loadingOverlay = document.getElementById('loadingOverlay');
        // Garante que o loading está visível
        loadingOverlay.classList.remove('hidden');
    });
</script>