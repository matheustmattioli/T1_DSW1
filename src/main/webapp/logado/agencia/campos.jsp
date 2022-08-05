<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
	<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
</head>
<body>
<div class="container w-50 p-3">
			<c:choose>
				<c:when test="${pacote != null}">
								<h2>Edição</h2>
							</c:when>
				<c:otherwise>
								<h2>Cadastro</h2>
							</c:otherwise>
			</c:choose>
		<c:if test="${pacote != null}">
			<input type="hidden" name="id" value="${pacote.id}" />
		</c:if>
			<input class="btn btn-primary" type="submit" value="Salvar Dados" />
			</div>
</body>