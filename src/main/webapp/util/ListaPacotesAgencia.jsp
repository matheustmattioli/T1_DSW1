<%@ page import="java.io.IOException"%>
<%@ page import="javax.imageio.ImageIO"%>
<%@ page import="java.awt.image.BufferedImage"%>
<%@ page import="java.io.File"%>
<%@ page import="br.ufscar.dc.dsw.dao.PacoteDAO"%>
<%@ page import="java.util.List"%>
<%@ page import="br.ufscar.dc.dsw.domain.Pacote"%>
<%@ page import="br.ufscar.dc.dsw.domain.Usuario" %>
<%@ page import="br.ufscar.dc.dsw.domain.Agencia" %>
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
<%!
	public Boolean isFilter = true;
%>
<div class="container">
	<h1>${pageContext.request.getPathInfo()}</h1>
	<h2>Pacotes da ${sessionScope.usuarioLogado.nome}</h2>
	<br>
	<c:choose>
	<c:when test='${pageContext.request.getParameter("filter").equals("false")}'>
		<form action="" method="post">
			<input type="hidden" value="true" name="filter" id="filter">
			<button class="btn btn-primary submit" onclick="">Filtrar pacotes disponíveis</button>
		</form>
	</c:when>
	<c:otherwise>
		<form action="" method="post">
			<input type="hidden" value="false" name="filter" id="filter">
			<button class="btn btn-primary submit" onclick="">Exibir todos os pacotes</button>
		</form>
	</c:otherwise>
	</c:choose>
	<br>
	<div class="row">
		<c:forEach var="pacote"
			items='${
				pageContext.request.getParameter("filter").equals("false") ?
					PacoteDAO().getAllbyIDAgencia(sessionScope.usuarioLogado.id) :
					PacoteDAO().getAllbyIDAgenciaValid(sessionScope.usuarioLogado.id)}'
		>
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
						<li class="list-group-item">Duração: ${pacote.duracaoDias} dias</li>
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
