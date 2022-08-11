<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>ROTES Cadastro</title>
</head>

<body>
	<div align="center">
	<br><br>
		<h1>Gerenciamento de Pacotes</h1>
		<h2>
			<a href="lista">Lista de Pacotes</a>
		</h2>
	</div>

		<c:choose>
			<c:when test="${pacote.id != null}">
				<form action="atualiza?id=${pacote.id}" method="post">
					<%@include file="campos.jsp"%>
				</form>
			</c:when>
			<c:otherwise>
				<form action="insercao" method="post">
					<%@include file="campos.jsp"%>
				</form>
			</c:otherwise>
		</c:choose>
	<c:if test="${!empty requestScope.mensagens}">
		<ul class="erro">
			<c:forEach items="${requestScope.mensagens}" var="mensagem">
				<li>${mensagem}</li>
			</c:forEach>
		</ul>
	</c:if>
</body>

</html>