<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
	<link href="${pageContext.request.contextPath}/layout.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<table>
		<caption>
			<c:choose>
				<c:when test="${usuario != null}">
								<h2>Edição</h2>
							</c:when>
				<c:otherwise>
								<h2>Cadastro</h2>
							</c:otherwise>
			</c:choose>
		</caption>
		<c:if test="${usuario != null}">
			<input type="hidden" name="id" value="${usuario.id}" />
		</c:if>
		<tr>
			<td><label for="nome">Nome</label></td>
			<td><input type="text" id="nome" name="nome"
				required value="${usuario.nome}" /></td>
		</tr>
		<tr>
			<td><label for="email">Email</label></td>
			<td><input type="email" id="email" name="email" required
				value="${usuario.email}" /></td>
		</tr>
		<tr>
			<td><label for="cpf">CPF (sem pontos ou traços)</label></td>
			<td>
				<c:choose>
					<c:when test="${usuario == null}">
						<input type="text" id="cpf" name="cpf" size="11" required
							   value="${usuario.cpf}"/>
					</c:when>
					<c:otherwise>
						<input type="text" id="cpf" name="cpf" size="11" required
							   value="${usuario.cpf}" readonly="true" class='disabled'/>
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
		<tr>
			<td><label for="sexo">Sexo</label></td>
			<td><select id="sexo" name="sexo">
				<option value="F"> Feminino </option>
				<option value="M"> Masculino </option>
				<option value="O"> Outro </option>
			</select></td>
		</tr>
		<tr>
			<td><label for="nascimento">Data de Nascimento</label></td>
			<td><input type="date" id="nascimento" name="nascimento" required
				min="1500" value="${usuario.nascimento}" /></td>
		</tr>
		<tr>
			<td><label for="telefone">Telefone</label></td>
			<td><input type="tel" id="telefone" name="telefone" required value="${usuario.telefone}" /></td>
		</tr>
		<tr>
			<td><label for="senha">Senha</label></td>
			<td><input type="password" id="senha" name="senha" required
			 value="${usuario.senha}" /></td>
		</tr>
		<tr>
			<td><label for="papel">Papel</label></td>
			<td><select id="papel" name="papel">
						<option value="USR"> Cliente </option>
						<option value="ADM"> Administrador </option>
			</select></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="Salvar Dados" /></td>
		</tr>
	</table>
</body>