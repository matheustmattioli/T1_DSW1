<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ROTES - Home</title>
        <link href="${renderRequest.getContextPath()}/layout.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Página do Usuário</h1>
        <p>Olá, ${sessionScope.usuarioLogado.nome}</p>
        <ul>
            <li>
                <a href="${pageContext.request.contextPath}/logout.jsp">Sair</a>
            </li>
        </ul>
        <jsp:include page="${renderRequest.getContextPath()}//util/ListaPacotes.jsp" />  
    </body>
</html>