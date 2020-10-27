<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="f"%>

<!DOCTYPE html>
<html lang="pt-BR">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Recruta B2W</title>
<link rel="stylesheet" href="./css/global.css">
<link rel="stylesheet" href="./css/candidatos.css">
<link href="./img/B2W_Digital_logo.png" rel="icon" type="image/x-icon" />

</head>

<body>

	<header>
		<figure>
			<a href="index.html"><img src="./img/B2W_Digital_logo.png"
				class="logo" alt=""></a>
		</figure>
		<span class="mobile-btn"></span>
		<nav class="menu-nav mobile-menu">
			<ul class="title-list">
				<li>
					<h1>
						<a href="candidatos">Candidatos</a>
					</h1>
				</li>
				<li>
					<h1>
						<a href="ranking">Ranking</a>
					</h1>
				</li>
			</ul>
		</nav>
		<div class="logcontrol">
			<p>Bem-Vindo ${objusu.nome}</p>
			<a href="index.html">Sair</a>
		</div>
	</header>
	<main class="general">
		<section>
		<table class="table table-dark table-hover">
			<tr >
				<th>#</th>
				<th>Nome</th>
				<th>Dt Nasc</th>
				<th>Tel</th>
				<th>Editar</th>
			</tr>

			<%-- Criando a estrutura para receber o atributo com a lista de clientes --%>

			<c:forEach var="cand" items="${ListaCandidatos}" varStatus="#">
				<tr>
					<td>${#.count}</td>
					<td>${cand.nome}</td>
					<td><f:formatDate value="${cand.dataNasc}" pattern="dd MMMM yyyy"/></td>
					<td>${cli.telefone}</td>
					<td><a href="AudioVideo?id-cli=${cand.cpf}">
					<svg width="1em" height="1em"
								viewBox="0 0 16 16" class="bi bi-pencil-square"
								fill="currentColor" xmlns="http://www.w3.org/2000/svg">
								<path
									d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456l-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z" />
								<path fill-rule="evenodd"
									d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z" /></svg></a></td>
					<td><a href="excluir?id-cli=${cli.id}">
					
					<svg width="1em" height="1em" viewBox="0 0 16 16"
							class="bi bi-trash" fill="currentColor"
							xmlns="http://www.w3.org/2000/svg">d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/><path
								fill-rule="evenodd"
								d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z" /></svg></a></td>					
				</tr>
			</c:forEach>
		</table>
	</section>
	</main>
	<footer>
		<h1>RecrutaB2W</h1>
		<h1>1TDST - NextStep - FIAP</h1>
	</footer>

	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="js/index.js"></script>
</body>

</html>