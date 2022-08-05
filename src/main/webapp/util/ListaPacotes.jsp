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
	
</head>
<body>
<h2>Pacotes disponíveis</h2>
<br>
<div class="row">
	<c:forEach var="pacote" items="${PacoteDAO().getAll()}">
		<div class="col-3">
			<div class="card">
				<div class="carousel slide" id="fotos" data-ride="carousel">
					<div class="carousel-inner" role="listbox">
						<c:forEach var="image" items='${pacote.getFotosImages(pageContext.servletContext.getRealPath("images"), pageContext.request.contextPath)}' varStatus="status">
								<div class="carousel-item <c:if test='${status.first}'>active</c:if>" data-target="#fotos">
									<img class ="d-block w-100" src="${image}">
								</div>
						</c:forEach>
					</div>
					<a class="carousel-control-prev" href="#fotos" role="button" data-slide="prev">
						<span class="carousel-control-prev-icon" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a>
					<a class="carousel-control-next" href="#fotos" role="button" data-slide="next">
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
					<li class="list-group-item">Agência: ${AgenciaDAO().getByCNPJ(pacote.CNPJ).nome}</li>
					<li class="list-group-item">Valor: ${pacote.valor} BCT</li>
				</ul>
					<c:choose>
						<c:when test="${sessionScope.usuarioLogado.papel == 'USR'}">
						<div class="card-body">
									<form id="formulario${pacote.id}" method="post"
										action="comprar">
										<input type="hidden" name="pacoteDesejado"
											value="${pacote.id}" required /> <input type="hidden"
											name="valor" value="${pacote.valor}" required /> <input
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
