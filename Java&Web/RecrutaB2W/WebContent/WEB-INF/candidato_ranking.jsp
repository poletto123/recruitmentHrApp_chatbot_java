<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-BR">

<head>
  <%@ include file="./snippets/imports/libs-head.jsp" %>
  <title>Recruta B2W</title>
  <link rel="stylesheet" href="./css/ranking.css">


</head>

<body>

  <%@ include file="./snippets/header_candidato.jsp" %>

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
            <th>Medalhas</th>
          </tr>
     	<c:forEach var="cand" items="${listaCandidatos}" varStatus="id">
          <tr class="pos">
            <td>${id.count}</td>
            <td>${cand.nome}</td>
            <td>${cand.numeroMedalha}</td>
          </tr>
         </c:forEach>
        </table>
      </div>
    </div>
  </div>


  <%@ include file="./snippets/footer.html" %>
  <%@ include file="./snippets/imports/libs-footer.jsp"%>
  <script type="text/javascript" src="js/index.js"></script>
</body>

</html>