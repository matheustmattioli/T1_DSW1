<%@ page import="java.io.IOException" %>
<%@ page import="javax.imageio.ImageIO" %>
<%@ page import="java.awt.image.BufferedImage" %>
<%@ page import="java.io.File" %>
<%@ page import="br.ufscar.dc.dsw.dao.AgenciaDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="br.ufscar.dc.dsw.domain.Agencia" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    String contextPath = request.getContextPath().replace("/", "");
%>

<p>Context: <%= contextPath %></p>
<h2>Agencias:</h2>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Agencia</th>
        <th>CNPJ</th>
        <th>Email</th>
        <th>Descrição</th>
    </tr>
    </thead>
    <c:forEach var="agencia" items="${AgenciaDAO().getAll()}">
        <tr>
            <td>${agencia.id}</td>
            <td>${agencia.nome}</td>
            <td>${agencia.CNPJ}</td>
            <td>${agencia.email}</td>
            <td>${agencia.descricao}</td>
        </tr>
    </c:forEach>
</table>