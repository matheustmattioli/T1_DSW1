<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table>
	<caption>
		<c:choose>
			<c:when test="${agencia != null}">
                            <h2>Edição</h2>
                        </c:when>
			<c:otherwise>
                            <h2>Cadastro</h2>
                        </c:otherwise>
		</c:choose>
	</caption>
	<c:if test="${agencia != null}">
		<input type="hidden" name="id" value="${agencia.id}" />
	</c:if>
	<tr>
		<td><label for="nome">Nome</label></td>
		<td><input type="text" id="nome" name="nome"
			required value="${agencia.nome}" /></td>
	</tr>
	<tr>
		<td><label for="email">Email</label></td>
		<td><input type="email" id="email" name="email" required
			value="${agencia.email}" /></td>
	</tr>
	<tr>
		<td><label for="cnpj">CNPJ (sem pontos ou traços)</label></td>
		<td><input type="text" id="cnpj" name="cnpj" size="11" required
			value="${agencia.CNPJ}" /></td>
	</tr>
	<tr>
		<td><label for="senha">Senha</label></td>
		<td><input type="password" id="senha" name="senha" required
		 value="${usuario.senha}" /></td>
	</tr>
	<tr>
		<td><label for="descricao">Descrição (máximo de 256 caracteres)</label></td>
		<td><textarea name="descricao" id="descricao" placeholder="Insira sua descrição aqui..."></textarea></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="Salvar Dados" /></td>
	</tr>
</table>