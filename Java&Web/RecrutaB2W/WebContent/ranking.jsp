<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-BR">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Recruta B2W</title>
  <link rel="stylesheet" href="./css/global.css">
  <link rel="stylesheet" href="./css/ranking.css">
  <link href="./img/B2W_Digital_logo.png" rel="icon" type="image/x-icon" />

</head>

<body>

  <header>
    <figure>
      <a href="index.html"><img src="./img/B2W_Digital_logo.png" class="logo" alt=""></a> </figure>
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
    <div class="ranking">
      <div class="ranking__title">
        <h1 class="ranking__title--content">PontuaÃ§Ã£o Geral</h1>
      </div>

      <div class="ranking__table">
        <table class="tabela">
          <tr class="col">
            <th>#</th>
            <th>Nome</th>
<!--             <th>Chatbot</th>
            <th>Áudio / VÃ­deo</th> -->
            <th>PTS</th>
          </tr>
     	<c:forEach var="cand" items="${listaCandidatos}" varStatus="id">
          <tr class="pos">
            <td>${id.count}</td>
            <td>${cand.nome}</td>
<!--             <td>OK</td>
            <td>OK</td> -->
            <td>${cand.pontuacao}</td>
          </tr>
         </c:forEach>
        </table>
      </div>
    </div>
  </div>


  <footer>
    <h1>RecrutaB2W</h1>
    <h1>1TDST - NextStep - FIAP</h1>
  </footer>

  <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
  <script type="text/javascript" src="js/index.js"></script>
</body>

</html>