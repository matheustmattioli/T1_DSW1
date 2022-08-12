<%@ page import="java.io.IOException"%>
<%@ page import="javax.imageio.ImageIO"%>
<%@ page import="java.awt.image.BufferedImage"%>
<%@ page import="java.io.File"%>
<%@ page import="br.ufscar.dc.dsw.dao.PacoteDAO"%>
<%@ page import="br.ufscar.dc.dsw.dao.AgenciaDAO" %>
<%@ page import="java.util.List"%>
<%@ page import="br.ufscar.dc.dsw.domain.Pacote"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
String contextPath = request.getContextPath().replace("/", "");
%>

<head>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ROTES</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </head>
</head>
<body>
<h2>Pacotes disponíveis</h2>
<fieldset>
	<form action="" method="post">
		<h3>Filtrar</h3>
		<c:choose><c:when test='${sessionScope.usuarioLogado.papel != "USR"}'>
		<label for="filter">Filtrar por disponíveis</label>
		<input type="checkbox" id="filter" name="filter">
		<br>
		</c:when></c:choose>
		<label for="cnpj">CNPJ da agência</label>
		<input type="number" name="cnpj" id="cnpj">
		<br>
		<label for="data">Data de partida</label>
		<input type="date" name="data" id="data">
		<br>
		<label for="destino">Destino</label>
		<input type="text" name="destino" id="destino">
		<br>
		<button class="btn btn-primary submit" onclick="">Filtrar</button>
	</form>
</fieldset>
<br>
<br>
<div class="row">
	<c:forEach var="pacote" items='${sessionScope.usuarioLogado.papel == "USR" ? PacoteDAO().getApplyFilters(pageContext.request.getParameter("destino"), pageContext.request.getParameter("cnpj"), pageContext.request.getParameter("data"), "on") : PacoteDAO().getApplyFilters(pageContext.request.getParameter("destino"), pageContext.request.getParameter("cnpj"), pageContext.request.getParameter("data"), pageContext.request.getParameter("filter"))}'>
		<div class="col-3">
			<div class="card">
				<div class="carousel slide" id="fotos_${pacote.id}" data-ride="carousel">
					<div class="carousel-inner" role="listbox">
						<c:forEach var="image" items='${pacote.getFotosImages(pageContext.servletContext.getRealPath("images"), pageContext.request.contextPath)}' varStatus="status">
								<div class="carousel-item <c:if test='${status.first}'>active</c:if>" data-target="#fotos_${pacote.id}">
									<img class ="d-block w-100" src="${image}">
								</div>
						</c:forEach>
					</div>
					<a class="carousel-control-prev" href="#fotos_${pacote.id}" role="button" data-slide="prev">
						<span class="carousel-control-prev-icon" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a>
					<a class="carousel-control-next" href="#fotos_${pacote.id}" role="button" data-slide="next">
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>	
				<div class="card-body">
					<h5 class="card-title">Pacote para ${pacote.cidade}
						${pacote.pais}</h5>
					<p class="card-text">${pacote.descricao}</p>
				</div>
				<ul class="list-group list-group-flush">
					<li class="list-group-item">Destino: ${pacote.cidade}
						${pacote.estado} ${pacote.pais}</li>
					<li class="list-group-item">Data de partida:
						${pacote.dataPartida}</li>
					<li class="list-group-item">Duração: ${pacote.duracaoDias} dias</li>
					<li class="list-group-item">Agência: ${AgenciaDAO().getByCNPJ(pacote.CNPJ).nome}</li>
					<li class="list-group-item">Valor: ${pacote.valor} BTC</li>
				</ul>
					<c:choose>
						<c:when test="${sessionScope.usuarioLogado.papel == 'USR'}">
						<div class="card-body">
							<form id="formulario${pacote.id}" method="post" action="comprar">
								<input type="hidden" name="pacoteDesejado"
									value="${pacote.id}" required />
								<input type="hidden"
									name="valor" value="${pacote.valor}" required />
								<input
									type="submit" class="btn btn-primary" value="Comprar"/>
							</form>
						</div>
						</c:when>
					</c:choose>
			</div>
		</div>
	</c:forEach>
</div>
</body>
