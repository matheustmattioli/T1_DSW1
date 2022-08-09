<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="br.ufscar.dc.dsw.dao.AgenciaDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="br.ufscar.dc.dsw.domain.Agencia" %>

<head>
	<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
</head>
<body>
<div class="container d-flex flex-column w-50 p-2">
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
<%--	private Date dataPartida;--%>
<%--	private int duracaoDias;--%>
<%--	private BigDecimal valor;--%>
<%--	private String descricao;--%>
	<input type="hidden" name="idAgencia" value="${sessionScope.usuarioLogado.id}">
	<input type="hidden" name="cnpj" value="${AgenciaDAO().getbyID(sessionScope.usuarioLogado.id).CNPJ}">

	<label class="p-2 mt-2" for="cidade">Cidade</label>
	<input class="p-1" type="text" id="cidade" name="cidade" required>

	<label class="p-2 mt-2" for="estado">Estado</label>
	<input class="p-1" type="text" id="estado" name="estado" required>

	<label class="p-2 mt-2" for="pais">País</label>
	<input class="p-1" type="text" id="pais" name="pais" required>

	<label class="p-2 mt-2" for="dataPartida">Data de Partida</label>
	<input class="p-1" type="date" id="dataPartida" name="dataPartida" required>

	<label class="p-2 mt-2" for="duracao">Duração</label>
	<input class="p-1" type="number" id="duracao" name="duracao" required>

	<label class="p-2 mt-2" for="valor">Valor</label>
	<input class="p-1" type="number" id="valor" name="valor" required>

	<label class="p-2 mt-2" for="descricao">Descrição (máximo de 256 caracteres)</label>
	<textarea class="p-1" id="descricao" name="descricao" placeholder="Coloque uma descrição bem bacana!"></textarea>

	<input class="mt-4 btn btn-primary" type="submit" value="Salvar Dados" />
</div>
</body>