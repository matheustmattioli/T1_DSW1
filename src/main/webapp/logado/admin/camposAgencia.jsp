<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
		<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
</head>
<body>
	<table>
			<c:choose>
				<c:when test="${agencia != null}">
					<h2>Edição</h2>
				</c:when>
				<c:otherwise>
					<h2>Cadastro</h2>
				</c:otherwise>
			</c:choose>
		<c:if test="${agencia != null}">
			<input type="hidden" name="id" value="${agencia.id}" />
		</c:if>
		<tr>
			<td><label for="nome">Nome</label></td>
			<td><input class="form-control" type="text" id="nome" name="nome"
				required value="${agencia.nome}" /></td>
		</tr>
		<tr>
			<td><label for="email">Email</label></td>
			<td><input class="form-control" type="email" id="email" name="email" required
				value="${agencia.email}" /></td>
		</tr>
		<tr>
			<td><label for="cnpj">CNPJ (sem pontos ou traços)</label></td>
			<td>
			<c:choose>
					<c:when test="${agencia == null}">
						<input class="form-control" type="text" id="cnpj" name="cnpj" size="11" required
							   value="${agencia.CNPJ}"/>
					</c:when>
					<c:otherwise>
						<input class="form-control" type="text" id="cnpj" name="cnpj" size="11" required
							   value="${agencia.CNPJ}" readonly="true" class="disabled"/>
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
		<tr>
			<td><label for="senha">Senha</label></td>
			<td><input class="form-control" type="password" id="senha" name="senha" required
			 value="${agencia.senha}" /></td>
		</tr>
		<tr>
			<td><label for="descricao">Descrição (máximo de 256 caracteres)</label></td>
			<td><textarea class="form-control" name="descricao" id="descricao" placeholder="Insira sua descrição aqui...">${agencia.descricao}</textarea></td>
		</tr>
		<tr>
		<tr>
		<td></td>
		</tr>
			<td colspan="2" align="center"><input type="submit" class="btn btn-primary" value="Salvar Dados" /></td>
		</tr>
	</table>
</body>