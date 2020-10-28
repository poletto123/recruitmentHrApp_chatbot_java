<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Recruta B2W</title>
    <link rel="stylesheet" href="./css/global.css">
    <link rel="stylesheet" href="./css/video.css">
    <link rel="stylesheet" href="./css/drag-drop.css">
    <link href="./img/B2W_Digital_logo.png" rel="icon" type="image/x-icon" />

</head>

<body>

    <header>
        <figure>
            <a href="index.html"><img src="./img/B2W_Digital_logo.png" class="logo" alt=""></a></figure>
        <span class="mobile-btn"></span>
        <nav class="menu-nav mobile-menu">
            <ul class="title-list">
                <li>
                    <h1><a href="chatbot.html">Chatbot</a></h1>
                </li>
                <li>
                    <h1><a href="video.html">VÃ­deo</a></h1>
                </li>
                <li>
                    <h1><a href="ranking.html">Ranking</a></h1>
                </li>
                <li>
                    <h1><a href="login.html">Log Out</a></h1>
                </li>
            </ul>
        </nav>
    </header>

    <div class="general">
        <div class="video">
            <div class="texto">
                <div class="txt-1">
                    <h2>VÃ­deo IntrodutÃ³rio</h2>
                    <p>Nos conte mais sobre vocÃª e da pessoa que vocÃª Ã©:</p>
                    <p>VocÃª poderÃ¡ nos mandar um vÃ­deo se descrevendo dizendo coisas como:</p>
                    <li>
                        <ul>Descrever o momento mais importante da sua vida;</ul>
                        <ul>Dizer quais sÃ£o as 3 coisas mais importantes pra vocÃª;</ul>
                        <ul></ul>
                    </li>
                </div>
                <div class="txt-2">
                    <p>* O vÃ­deo deve estar nos <u>formatos de mp4, mkv, avi</u> com a <u>resoluÃ§Ã£o mÃ­nima de
                            1280x720(HD)</u> e com o som audÃ­vel,
                        <u>tamanho mÃ¡ximo de 100mb.</u>
                    </p>
                </div>
            </div>
            <div class="video__container">
                <div class="drop-zone">
                    <span class="drop-zone__prompt">Clique para enviar ou arraste o vÃ­deo aqui</span>
                    <input type="file" name="myFile" class="drop-zone__input">
                </div>
                <button type="submit" class="btn-enviar">Enviar</button>
            </div>
        </div>
    </div>

    <footer>
        <h1>RecrutaB2W</h1>
        <h1>1TDST - NextStep - FIAP</h1>
    </footer>

    <script src="https://code.jquery.com/jquery-3.5.1.min.js"
        integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
    <script type="text/javascript" src="./js/video.js"></script>
    <script type="text/javascript" src="./js/index.js"></script>
</body>

</html>