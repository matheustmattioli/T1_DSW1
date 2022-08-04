<%@ page import="java.io.IOException" %>
<%@ page import="javax.imageio.ImageIO" %>
<%@ page import="java.awt.image.BufferedImage" %>
<%@ page import="java.io.File" %>
<%@ page import="br.ufscar.dc.dsw.dao.PacoteDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="br.ufscar.dc.dsw.domain.Pacote" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    String contextPath = request.getContextPath().replace("/", "");
%>

<h2>Pacotes disponíveis:</h2>
<table>
    <thead>
    <tr>
        <th>Pacote</th>
        <th>Descrição</th>
        <th>Cidade</th>
        <th>Estado</th>
        <th>Pais</th>
        <th>Agência</th>
        <th>Data de Partida</th>
        <th>Valor</th>
        <th>Fotos</th>
    </tr>
    </thead>
    <c:forEach var="pacote" items="${PacoteDAO().getAll()}">
        <tr>
            <td>${pacote.id}</td>
            <td>${pacote.descricao}</td>
            <td>${pacote.cidade}</td>
            <td>${pacote.estado}</td>
            <td>${pacote.pais}</td>
            <td>${pacote.CNPJ}</td>
            <td>${pacote.dataPartida}</td>
            <td>${pacote.valor} BTC</td>
            <td>
                <div id="images-container">
                    <c:forEach var="image"
                               items='${pacote.getFotosImages(pageContext.servletContext.getRealPath("images"),
                                                              pageContext.request.contextPath)}'
                    >
                        <img src="${image}" width="64px">
                    </c:forEach>
                </div>
            </td>
        </tr>
    </c:forEach>
</table>