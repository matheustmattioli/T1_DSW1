<%@ page import="java.io.IOException" %>
<%@ page import="javax.imageio.ImageIO" %>
<%@ page import="java.awt.image.BufferedImage" %>
<%@ page import="java.io.File" %>
<%@ page import="br.ufscar.dc.dsw.dao.PropostaDAO" %>
<%@ page import="br.ufscar.dc.dsw.domain.Proposta" %>
<%@ page import="br.ufscar.dc.dsw.dao.PacoteDAO" %>
<%@ page import="br.ufscar.dc.dsw.dao.AgenciaDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="br.ufscar.dc.dsw.domain.Pacote" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    String contextPath = request.getContextPath().replace("/", "");
%>

<head>
    <script src="${pageContext.request.contextPath.concat('/js/formEdit.js')}"></script>
</head>
<body>
    <c:choose>
        <c:when test="${PropostaDAO().getAllCancelledbyIDUsuario(sessionScope.usuarioLogado.id).size() == '0'}">
            <h2>Você não cancelou nenhum pacote.</h2>
        </c:when>    
        <c:otherwise>
    <h2>Pacotes Cancelados</h2>
    <br/>
    <table class="table">
        <thead>
        <tr>
            <th>Pacote</th>
            <th>Descrição</th>
            <th>Cidade</th>
            <th>Estado</th>
            <th>Pais</th>
            <th>Agência</th>
            <th>Data de Partida</th>
            <th>Duração (Dias)</th>
            <th>Valor (BTC)</th>
            <th>Fotos</th>
            <th>Ações</th>
        </tr>
        </thead>
        <c:forEach var="proposta" items="${PropostaDAO().getAllCancelledbyIDUsuario(sessionScope.usuarioLogado.id)}">
            <tr>
                <td>${PacoteDAO().getbyID(proposta.idPacote).id}</td>
                <td>${PacoteDAO().getbyID(proposta.idPacote).descricao}</td>
                <td>${PacoteDAO().getbyID(proposta.idPacote).cidade}</td>
                <td>${PacoteDAO().getbyID(proposta.idPacote).estado}</td>
                <td>${PacoteDAO().getbyID(proposta.idPacote).pais}</td>
                <td>${AgenciaDAO().getByCNPJ(PacoteDAO().getbyID(proposta.idPacote).CNPJ).nome}</td>
                <td>${PacoteDAO().getbyID(proposta.idPacote).dataPartida}</td>
                <td>${PacoteDAO().getbyID(proposta.idPacote).duracaoDias} dias</td>
                <td>${PacoteDAO().getbyID(proposta.idPacote).valor} BTC</td>
                <td>
                        <c:forEach var="image"
                                items='${PacoteDAO().getbyID(proposta.idPacote)
                                         .getFotosImages(pageContext.servletContext.getRealPath("images"),
                                                         pageContext.request.contextPath)}'
                        >
                            <img src="${image}" width="64px">
                        </c:forEach>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </table>
    </c:otherwise>
    </c:choose>
</body>