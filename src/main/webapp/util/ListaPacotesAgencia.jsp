<%@ page import="java.io.IOException"%>
<%@ page import="javax.imageio.ImageIO"%>
<%@ page import="java.awt.image.BufferedImage"%>
<%@ page import="java.io.File"%>
<%@ page import="br.ufscar.dc.dsw.dao.PacoteDAO"%>
<%@ page import="java.util.List"%>
<%@ page import="br.ufscar.dc.dsw.domain.Pacote"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
String contextPath = request.getContextPath().replace("/", "");
%>


<h2>Pacotes da ${sessionScope.usuarioLogado.nome}:</h2>
<div class="container">
	<div class="row">
		<c:forEach var="pacote"
			items="${PacoteDAO().getAllbyIDAgencia(sessionScope.usuarioLogado.id)}">
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
						<li class="list-group-item">Agência: ${pacote.CNPJ}</li>
						<li class="list-group-item">Valor: ${pacote.valor} BCT</li>
					</ul>
					<div class="card-body">
						<a href=# class="btn btn-primary"> Ver mais </a>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>