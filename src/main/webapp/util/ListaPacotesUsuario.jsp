<%@ page import="java.io.IOException" %>
<%@ page import="javax.imageio.ImageIO" %>
<%@ page import="java.awt.image.BufferedImage" %>
<%@ page import="java.io.File" %>
<%@ page import="br.ufscar.dc.dsw.dao.PropostaDAO" %>
<%@ page import="br.ufscar.dc.dsw.domain.Proposta" %>
<%@ page import="br.ufscar.dc.dsw.dao.PacoteDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="br.ufscar.dc.dsw.domain.Pacote" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    String contextPath = request.getContextPath().replace("/", "");
%>

<p>Context: <%= contextPath %></p>
<h2>Pacotes adquiridos:</h2>
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
    <c:forEach var="proposta" items="${PropostaDAO().getAllbyIDUsuario(sessionScope.usuarioLogado.id)}">
        <tr>
            <td>${PacoteDAO().getbyID(proposta.idPacote).id}</td>
            <td>${PacoteDAO().getbyID(proposta.idPacote).descricao}</td>
            <td>${PacoteDAO().getbyID(proposta.idPacote).cidade}</td>
            <td>${PacoteDAO().getbyID(proposta.idPacote).estado}</td>
            <td>${PacoteDAO().getbyID(proposta.idPacote).pais}</td>
            <td>${PacoteDAO().getbyID(proposta.idPacote).CNPJ}</td>
            <td>${PacoteDAO().getbyID(proposta.idPacote).dataPartida}</td>
            <td>${PacoteDAO().getbyID(proposta.idPacote).valor} BTC</td>
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