<%@ page import="java.io.IOException" %>
<%@ page import="javax.imageio.ImageIO" %>
<%@ page import="java.awt.image.BufferedImage" %>
<%@ page import="java.io.File" %>
<%@ page import="br.ufscar.dc.dsw.dao.PacoteDAO" %>
<%@ page import="br.ufscar.dc.dsw.dao.AgenciaDAO" %>
<%@ page import="br.ufscar.dc.dsw.domain.Usuario" %>
<%@ page import="java.util.List" %>
<%@ page import="br.ufscar.dc.dsw.domain.Pacote" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
String contextPath = request.getContextPath().replace("/", "");
%>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">


<h2>Pacotes disponíveis</h2>
<br>
<c:if test="${mensagens.existeErros}">
	<div class="alert alert-warning" role="alert">
		<c:forEach var="erro" items="${mensagens.erros}">
			${erro}
		</c:forEach>
	</div>
</c:if>
<br/>
<div class="row">
	<c:forEach var="pacote" items="${PacoteDAO().getAll()}">
		<div class="col-3">
			<div class="card">
				<img class="card-img-top"
					src="${pacote.getFotosImages(pageContext.servletContext.getRealPath("images"), pageContext.request.contextPath)[0]}">
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
				<div class="card-body">
					<c:choose>
						<c:when test="${sessionScope.usuarioLogado.papel == 'USR'}">
									<form id="formulario${pacote.id}" method="post"
										action="comprar">
										<input type="hidden" name="pacoteDesejado"
											value="${pacote.id}" required /> <input type="hidden"
											name="valor" value="${pacote.valor}" required /> <input
											type="submit" class="btn btn-primary" value="Comprar"/>
									</form>
						</c:when>
						<c:otherwise>
							<button href=# class="btn btn-outline-primary">Ver mais</button>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
	</c:forEach>
</div>
