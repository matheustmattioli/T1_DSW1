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
     <link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
</head>
<body>
    <h2>Agencias</h2>
    <br/>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Agencia</th>
            <th>CNPJ</th>
            <th>Email</th>
            <th>Descrição</th>
            <td>Ações</td>
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
                    <button class="btn btn-primary" onclick='requestAgenciaEdit("<%= contextPath %>", ${agencia.id})'>
                        Editar
                    </button>
                    <button class="btn btn-danger" onclick='requestAgenciaDelete("<%= contextPath %>", ${agencia.id})'>
                        Deletar
                    </button>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>