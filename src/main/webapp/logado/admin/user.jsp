<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu do Sistema</title>
        <link href="${pageContext.request.contextPath}/layout.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Página do Administrador</h1>
        <p>Olá ${sessionScope.usuarioLogado.nome}</p>
        <ul>
            <li>
            	<a href="${pageContext.request.contextPath}/admin/cadastro?tipo=usuario">Criar novo Usuário</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/admin/cadastro?tipo=agencia">Criar nova Agência</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/logout.jsp">Sair</a>
            </li>
        </ul>
        <jsp:include page="${renderRequest.getContextPath()}/util/ListaUsuarios.jsp" />  
        <jsp:include page="${renderRequest.getContextPath()}/util/ListaPacotes.jsp" /> 
        <jsp:include page="${renderRequest.getContextPath()}/util/ListaAgencias.jsp" />  
    </body>
</html>