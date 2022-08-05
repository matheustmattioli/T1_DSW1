<%@ page import="java.io.IOException" %>
<%@ page import="javax.imageio.ImageIO" %>
<%@ page import="java.awt.image.BufferedImage" %>
<%@ page import="java.io.File" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ROTES</title>
    </head>
    <body>
    <nav class="navbar navbar-light bg-light px-4 justify-content-between">
		<a class="navbar-brand" href="${pageContext.request.contextPath}"> ROTES Viagens - A rota dos seus sonhos ao
			seu alcance</a><a class="btn btn-outline-primary"
			href="login.jsp">Logar</a>
	</nav>
    <%
        String contextPath = request.getContextPath().replace("/", "");
    %>
    <br><br>
    <div class="container justify-content-center p-2">
    <h1>ROTES Viagens</h1>
    <br>
    <h2>Compre os melhores pacotes de viagem sem complicação</h2>
    <br>
    <jsp:include page="${renderRequest.getContextPath()}/util/ListaPacotes.jsp" /> 
    <c:if test="${mensagens.existeErros}">
        <div id="erro">
            <ul>
                <c:forEach var="erro" items="${mensagens.erros}">
                    <li> ${erro} </li>
                </c:forEach>
            </ul>
        </div>
    </c:if>
    </div>
    </body>
</html>