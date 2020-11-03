<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">

<head>
<%@ include file="./snippets/imports/libs-head.jsp"%>
<title>Recruta B2W</title>
<link rel="stylesheet" href="./css/video.css">
<link rel="stylesheet" href="./css/drag-drop.css">

</head>

<body>

	<%@ include file="./snippets/header_candidato.jsp"%>

	<div class="general">
		<div class="video">
			<div class="texto">
				<div class="txt-1">
					<h2>VÃ­deo IntrodutÃ³rio</h2>
					<p>Nos conte mais sobre vocÃª e da pessoa que vocÃª Ã©:</p>
					<p>VocÃª poderÃ¡ nos mandar um vÃ­deo se descrevendo dizendo
						coisas como:</p>
					<li>
						<ul>Descrever o momento mais importante da sua vida;
						</ul>
						<ul>Dizer quais sÃ£o as 3 coisas mais importantes pra vocÃª;
						</ul>
						<ul></ul>
					</li>
				</div>
				<div class="txt-2">
					<p>
						* O vÃ­deo deve estar nos <u>formatos de mp4, mkv, avi</u> com a <u>resoluÃ§Ã£o
							mÃ­nima de 1280x720(HD)</u> e com o som audÃ­vel, <u>tamanho
							mÃ¡ximo de 100mb.</u>
					</p>
				</div>
			</div>
			<div class="video__container">
				<form action="audioVideo" method="get">
					<div class="drop-zone">
						<span class="drop-zone__prompt">Clique para enviar ou
							arraste o vÃ­deo aqui</span> <input
							value="http://techslides.com/demos/sample-videos/small.mp4"
							type="text" name="myFile" class="drop-zone__input">
					</div>
					<button type="submit" class="btn-enviar" action="audioVideo"
						method="post">Enviar</button>
				</form>
			</div>
			${msg}
		</div>
	</div>

	<%@ include file="./snippets/footer.html"%>


	<%@ include file="./snippets/imports/libs-footer.jsp"%>
	<script type="text/javascript" src="./js/video.js"></script>
	<script type="text/javascript" src="./js/index.js"></script>
</body>

</html>