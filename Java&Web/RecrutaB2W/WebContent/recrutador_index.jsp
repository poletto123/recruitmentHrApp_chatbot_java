<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-BR">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Recruta B2W</title>
<link rel="stylesheet" href="./css/global.css">
<link rel="stylesheet" href="./css/recrutador_main.css">
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
		<section class="content-infos">
			<div class="content-infos__text">
				<div class="content-infos__text--visible">
					<h2>Seja Bem-Vindo(a) a Recruta B2W, ${objusu.nome}.</h2>
					<p>Escolha acima a funcionalidade que esteja procurando.</p>
				</div>
			</div>
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