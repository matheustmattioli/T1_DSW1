<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ROTES - Administrador</title>
       <link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
    </head>
    <body>
    	<nav class="navbar navbar-light bg-light px-4 justify-content-between">
		<a class="navbar-brand" href="#"> ROTES Viagens - A rota dos seus
			sonhos ao seu alcance</a>
			<a class="btn btn-outline-primary"
			href="${pageContext.request.contextPath}/logout.jsp">Logout</a>
			</nav>
			<br>
			<br>
		<div class="container">	
			<h1>Olá, ${sessionScope.usuarioLogado.nome}</h1>
			<br>
			<a class="btn btn-primary btn-lg btn-block"
				href="${pageContext.request.contextPath}/admin/cadastro?tipo=usuario">Criar Novo Usuário</a>
				<a class="btn btn-primary btn-lg btn-block" href="${pageContext.request.contextPath}/admin/cadastro?tipo=agencia">Criar nova Agência</a>
				<br>
				<br>
				
			<jsp:include page="${renderRequest.getContextPath()}/util/ListaUsuarios.jsp" />  
			<jsp:include page="${renderRequest.getContextPath()}/util/ListaAgencias.jsp" />  
			<jsp:include page="${renderRequest.getContextPath()}/util/ListaPacotes.jsp" /> 
		</div>
    </body>
</html>