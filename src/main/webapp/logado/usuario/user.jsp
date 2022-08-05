<%@ page import="br.ufscar.dc.dsw.dao.PacoteDAO" %>
<%@ page import="br.ufscar.dc.dsw.dao.AgenciaDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="br.ufscar.dc.dsw.domain.Pacote" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ROTES - Página do Usuário</title>
        <link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
    </head>
    <body>
        <nav class="navbar navbar-light bg-light px-4 justify-content-between">
            <a class="navbar-brand" href="#"> ROTES Viagens - A rota dos seus sonhos ao
                seu alcance</a><a class="btn btn-outline-primary"
                href="${pageContext.request.contextPath}/logout.jsp">Logout</a>
        </nav>
        <br>
        <div class="container-fluid">
            <h1>Olá, ${sessionScope.usuarioLogado.nome}</h1>
            <ul>
                <li>
                    <a href="${pageContext.request.contextPath}/logout.jsp">Sair</a>
                </li>
            </ul>
            <c:if test="${mensagens.existeErros}">
                <div id="erro">
                    <ul>
                        <c:forEach var="erro" items="${mensagens.erros}">
                            <li> ${erro} </li>
                            </c:forEach>
                    </ul>
                </div>
            </c:if>
            <br/>
            <form action="comprar" method="post">
                <table>
                    <tr>
                        <td>Comprar novo pacote:</td>
                        <td>
                            <select id="pacoteDesejado" name="pacoteDesejado">
                                <c:forEach var="pacote" items="${PacoteDAO().getAll()}">
                                    <option value="${pacote.id}"> Pacote ${pacote.id} </option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Valor: </td>
                        <td><input type="currency" id="valor" name="valor" required
                            value="0" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Comprar" /></td>
                    </tr>
                </table>
            </form>
            <br/>
                <jsp:include page="${renderRequest.getContextPath()}/${sessionScope.tablePath}" />
            <br/>
        </div>
    </body>
</html>