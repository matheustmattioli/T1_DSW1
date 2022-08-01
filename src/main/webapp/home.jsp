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
        <link href="${pageContext.request.contextPath}/layout.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
    <%
        String contextPath = request.getContextPath().replace("/", "");
    %>
    <h1>ROTES Viagens</h1>
    <h2> A rota dos seus sonhos ao seu alcance</h2>
    <h3>Deseja <a href="login.jsp">logar?</a></h3>
        <c:if test="${mensagens.existeErros}">
            <div id="erro">
                <ul>
                    <c:forEach var="erro" items="${mensagens.erros}">
                        <li> ${erro} </li>
                    </c:forEach>
                </ul>
            </div>
        </c:if>
    <h2>Pacotes disponíveis:</h2>
    <table style="border-spacing:10px;">
        <thead>
        <tr>
            <th>Pacote</th>
            <th>Descrição</th>
            <th>Destinos</th>
            <th>Agência</th>
            <th>Data de Partida</th>
            <th>Valor</th>
            <th>Fotos</th>
        </tr>
        </thead>
        <c:forEach var="pacote" items="${requestScope.pacotes}">
            <tr>
                <td>${pacote.id}</td>
                <td>${pacote.descricao}</td>
                <td>${pacote.destino}</td>
                <td>${pacote.CNPJ}</td>
                <td>${pacote.dataPartida}</td>
                <td>${pacote.valor} BTC</td>
                <td>
                    <img src="images/exemple.png" width="64px">
                </td>
            </tr>
        </c:forEach>
    </table>
    </body>
</html>