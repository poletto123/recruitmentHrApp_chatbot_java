<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title>Chatbot</title>
 <link rel="stylesheet" type="text/css" href="./css/global.css">
 <link rel="stylesheet" type="text/css" href="./css/chatbot.css" />
 <link href="./img/B2W_Digital_logo.png" rel="icon" type="image/x-icon" />
 
 <%@ include file="./snippets/imports/libs-head.jsp"%>
</head>
<body>

	<%@ include file="./snippets/header_candidato.jsp"%>
	
	<main>
		<div class="general">

			<div class="chatbot">
				<div class="conversa">
					<span>Digitando ...</span>
				</div>
				<textarea type="text" id="pergunta" name="pergunta" class="campo"
					placeholder="Digite aqui"></textarea>
				<button id="enviar" onclick="carregarDados()">Enviar</button>

			</div>
		</div>
	</main>
	
	<%@ include file="./snippets/footer.html" %>
	<%@ include file="./snippets/imports/libs-footer.jsp" %>
  
	<script type="text/javascript" src="./js/chatbot.js"></script>

  	
</body>
</html>