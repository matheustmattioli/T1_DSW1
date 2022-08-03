<%@ page import="br.ufscar.dc.dsw.dao.PacoteDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="br.ufscar.dc.dsw.domain.Pacote" %>]
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ROTES - Home</title>
        <link href="${pageContext.request.contextPath}/layout.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Página do Usuário</h1>
        <p>Olá, ${sessionScope.usuarioLogado.nome}</p>
        <ul>
            <li>
                <a href="${pageContext.request.contextPath}/logout.jsp">Sair</a>
            </li>
        </ul>
        <jsp:include page="${renderRequest.getContextPath()}//util/ListaPacotesUsuario.jsp" />
        <jsp:include page="${renderRequest.getContextPath()}//util/ListaPacotes.jsp" />  
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
    </body>
</html>