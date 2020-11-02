<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="./snippets/imports/libs-head.jsp"%>
<title>Recruta B2W</title>
<link rel="stylesheet" href="./css/recrutador_candidatos.css">
</head>
<body>

	<%@ include file="./snippets/header_recrutador.jsp"%>

	<main class="general">
			<div class="candidatos">
				<table class="tabela">
					<tr class="col">
						<th>Id</th>
						<th>Nome</th>
						<th>E-mail</th>
						<th>Data de Nascimento</th>
						<th>Vaga</th>
						<th>CPF</th>
						<th>Recrutador</th>
						<th colspan="2">Processos</th>
					</tr>
					<%-- Criando a estrutura para receber o atributo com a lista de candidatos --%>
					<c:forEach var="cand" items="${listaCandidatos}" varStatus="id">
						<tr class="pos">
							<td>${id.count}</td>
							<td>${cand.nome}</td>
							<td>${cand.email}</td>
							<td><f:formatDate value="${cand.dataNascimento}" pattern="dd/MM/yyyy"/></td>
							<td>${cand.vaga}</td>
							<td>${cand.cpf}</td>
							<td>${cand.recrutador}</td>
							<td>
								<c:choose>
									<c:when test="${cand.audioVideo eq null}">
										<img alt="" class="link-disable" src="./img/videoCamera.png">
									</c:when>
									<c:otherwise>
										<a href="audioVideo?id-cand=${cand.id}"><img alt="" src="./img/videoCamera.png"></a>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${cand.chatbot eq null}">
										<img alt="" class="link-disable" src="./img/historico.png">
									</c:when>
									<c:otherwise>
										<a href="historico?id-cand=${cand.id}"><img alt="" src="./img/historico.png"></a>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
					</c:forEach>
					<tr class="pos">
						<td>Id</td>
						<td>Nome</td>
						<td>E-mail</td>
						<td>Data de Nascimento</td>
						<td>Vaga</td>
						<td>CPF</td>
						<td>Recrutador</td>
						<td colspan="2">
						<a href="audioVideo?id-cand=4"><img alt="" src="./img/videoCamera.png"></a>
						<a href="historico?id-cand=4"><img alt="" src="./img/historico.png"></a>
						</td>
					</tr>
					<tr class="pos">
						<td>Id2</td>
						<td>Nome2</td>
						<td>E-mail2</td>
						<td>Data de Nascimento2</td>
						<td>Vaga2</td>
						<td>CPF2</td>
						<td>Recrutador2</td>
						<td colspan="2">
						<img alt="" class="link-disable" src="./img/videoCamera.png">
						<img alt="" class="link-disable" src="./img/historico.png">
						</td>
					</tr>
				</table>
			</div>
	</main>
	<%@ include file="./snippets/footer.html"%>
	<%@ include file="./snippets/imports/libs-footer.jsp"%>
</body>

</html>