<%@ page import="java.io.IOException" %>
<%@ page import="javax.imageio.ImageIO" %>
<%@ page import="java.awt.image.BufferedImage" %>
<%@ page import="java.io.File" %>
<%@ page import="br.ufscar.dc.dsw.dao.UsuarioDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="br.ufscar.dc.dsw.domain.Usuario" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    String contextPath = request.getContextPath().replace("/", "");
%>

<p>Context: <%= contextPath %></p>
<h2>Usuarios:</h2>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Usuario</th>
        <th>Email</th>
        <th>CPF</th>
        <th>Sexo</th>
        <th>Nascimento</th>
        <th>Telefone</th>
        <th>Papel</th>
    </tr>
    </thead>
    <c:forEach var="usuario" items="${UsuarioDAO().getAll()}">
        <tr>
            <td>${usuario.id}</td>
            <td>${usuario.nome}</td>
            <td>${usuario.email}</td>
            <td>${usuario.cpf}</td>
            <td>${usuario.sexo}</td>
            <td>${usuario.nascimento}</td>
            <td>${usuario.telefone}</td>
            <td>${usuario.papel}</td>
        </tr>
    </c:forEach>
</table>