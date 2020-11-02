<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="./snippets/imports/libs-head.jsp"%>
<title>Recruta B2W</title>
<link rel="stylesheet" href="./css/recrutador_main.css">
</head>
<body>

	<%@ include file="./snippets/header_recrutador.jsp"%>

	<main class="general">
		<section class="content-infos">
			<div class="content-infos__text">
				<div class="content-infos__text--visible">
					<h2>Respostas do chatbot</h2>
					<p>${chatbot.respostas}</p>
				</div>
			</div>
		</section>
	</main>
	<%@ include file="./snippets/footer.html" %>
	<%@ include file="./snippets/imports/libs-footer.jsp" %>
</body>

</html>