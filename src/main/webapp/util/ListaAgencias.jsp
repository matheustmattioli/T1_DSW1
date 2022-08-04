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

<head>
    <script src="${pageContext.request.contextPath.concat('/js/formEdit.js')}"></script>
</head>
<body>
    <h2>Agencias:</h2>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Agencia</th>
            <th>CNPJ</th>
            <th>Email</th>
            <th>Descrição</th>
            <td></td>
        </tr>
        </thead>
        <c:forEach var="agencia" items="${AgenciaDAO().getAll()}">
            <tr>
                <td>${agencia.id}</td>
                <td>${agencia.nome}</td>
                <td>${agencia.CNPJ}</td>
                <td>${agencia.email}</td>
                <td>${agencia.descricao}</td>
                <td>
                    <button onclick='requestAgenciaEdit("<%= contextPath %>", ${agencia.id})'>
                        Editar
                    </button>
                    <button onclick='requestAgenciaDelete("<%= contextPath %>", ${agencia.id})'>
                        Deletar
                    </button>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>