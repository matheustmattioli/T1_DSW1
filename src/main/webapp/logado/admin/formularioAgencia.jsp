<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>ROTES Cadastro Agência</title>
</head>

<body>
	<div align="center">
	<br><br>
		<h1>Gerenciamento de Agências</h1>
		<h2>
			<a href="lista">Lista de Agências</a>
		</h2>
	</div>
	<br>
	<div align="center">
		<c:choose>
			<c:when test="${agencia != null}">
				<form action="atualiza?tipo=agencia&id=${agencia.id}" method="post">
					<%@include file="camposAgencia.jsp"%>
				</form>
			</c:when>
			<c:otherwise>
				<form action="insercao?tipo=agencia" method="post">
					<%@include file="camposAgencia.jsp"%>
				</form>
			</c:otherwise>
		</c:choose>
	</div>
	<c:if test="${!empty requestScope.mensagens}">
		<ul class="erro">
			<c:forEach items="${requestScope.mensagens}" var="mensagem">
				<li>${mensagem}</li>
			</c:forEach>
		</ul>
	</c:if>
</body>

</html>