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
	<c:choose>
		<c:when test="${pacote != null}">
			<input type="hidden" name="id" value="${pacote.id}" />
			<input type="hidden" name="idAgencia" value="${pacote.idAgencia}">
			<input type="hidden" name="cnpj" value="${pacote.CNPJ}">
		</c:when>
		<c:otherwise>
			<input type="hidden" name="idAgencia" value="${sessionScope.usuarioLogado.id}">
			<input type="hidden" name="cnpj" value="${AgenciaDAO().getbyID(sessionScope.usuarioLogado.id).CNPJ}">
		</c:otherwise>
	</c:choose>
<%--	private Date dataPartida;--%>
<%--	private int duracaoDias;--%>
<%--	private BigDecimal valor;--%>
<%--	private String descricao;--%>

	<label class="p-2 mt-2" for="cidade">Cidade</label>
	<input class="p-1" type="text" id="cidade" name="cidade" maxlength="256" value="${pacote.cidade}" required>

	<label class="p-2 mt-2" for="estado">Estado</label>
	<input class="p-1" type="text" id="estado" name="estado" maxlength="256" value="${pacote.estado}" required>

	<label class="p-2 mt-2" for="pais">País</label>
	<input class="p-1" type="text" id="pais" name="pais" maxlength="256" value="${pacote.pais}" required>

	<label class="p-2 mt-2" for="dataPartida">Data de Partida</label>
	<input class="p-1" type="date" id="dataPartida" name="dataPartida" value="${pacote.dataPartida}" required>

	<label class="p-2 mt-2" for="duracao">Duração (dias)</label>
	<input class="p-1" type="number" id="duracao" min="1" max="1000000000" name="duracao" value="${pacote.duracaoDias}" required>

	<label class="p-2 mt-2" for="valor">Valor (BTC)</label>
	<input class="p-1" type="number" id="valor" min="0" max="1000000000" name="valor" value="${pacote.valor}" required>

	<label class="p-2 mt-2" for="descricao">Descrição (máximo de 256 caracteres)</label>
	<textarea class="p-1" id="descricao" name="descricao" maxlength="256" placeholder="Coloque uma descrição bem bacana!">${pacote.descricao}</textarea>

	<input class="mt-4 btn btn-primary" type="submit" value="Salvar Dados" />
</div>
</body>