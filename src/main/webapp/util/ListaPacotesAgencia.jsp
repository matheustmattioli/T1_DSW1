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

<head>
    <script src="${pageContext.request.contextPath.concat('/js/formEdit.js')}"></script>
     <link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
</head>

<div class="container">
<h2>Pacotes da ${sessionScope.usuarioLogado.nome}</h2>
<br/>
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
						<li class="list-group-item">Valor: ${pacote.valor} BTC</li>
					</ul>
					<div class="card-body">
						<button class="btn btn-primary" onclick='requestPacoteEdit("<%= contextPath %>", ${pacote.id})'> Editar </button>
						<button class="btn btn-danger" onclick='requestPacoteDelete("<%= contextPath %>", ${pacote.id})'> Deletar </button>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>
