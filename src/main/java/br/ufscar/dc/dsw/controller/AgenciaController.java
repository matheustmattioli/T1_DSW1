package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.dao.AgenciaDAO;
import br.ufscar.dc.dsw.dao.PacoteDAO;
import br.ufscar.dc.dsw.dao.UsuarioDAO;
import br.ufscar.dc.dsw.domain.Agencia;
import br.ufscar.dc.dsw.domain.Pacote;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.util.Erro;

@WebServlet(urlPatterns = "/agencia/*")
public class AgenciaController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private PacoteDAO pacoteDAO;

	@Override
	public void init() {
		pacoteDAO = new PacoteDAO();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();

		if (action == null) {
			action = "";
		}

		try {
			switch (action) {
			case "/cadastro":
				apresentaFormCadastro(request, response);
				break;
			case "/insercao":
				insercao(request, response);
				break;
			case "/edicao":
				apresentaFormEdicao(request, response);
				break;
			case "/atualiza":
				atualiza(request, response);
				break;
			case "/deletar":
				deletar(request, response);
				break;
			default:
				home(request, response);
				break;
			}
		} catch (Exception e) {
			Erro erros = new Erro();
			erros.add(e.getMessage());
			request.setAttribute("mensagens", erros);
			RequestDispatcher rd = request.getRequestDispatcher("/erro.jsp");
			rd.forward(request, response);
		}
	}
	
	private void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Erro erros = new Erro();

		try {
			Agencia agencia = (Agencia) request.getSession().getAttribute("usuarioLogado");
			if (agencia == null) {
				response.sendRedirect(request.getContextPath());
			} else if (agencia.getCNPJ() != null && agencia.getCNPJ() != null) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/agencia/user.jsp");
				dispatcher.forward(request, response);
			} else {
				erros.add("Acesso não autorizado!");
				request.setAttribute("mensagens", erros);
				RequestDispatcher rd = request.getRequestDispatcher("/noAuth.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			erros.add(e.getMessage());
			request.setAttribute("mensagens", erros);
			RequestDispatcher rd = request.getRequestDispatcher("/erro.jsp");
			rd.forward(request, response);
		}
	}
	
	private void deletar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		Long id = Long.parseLong(request.getParameter("id"));
		pacoteDAO.delete(id);
		response.sendRedirect("lista");
	}
	
	private void atualiza(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		Long idAgencia = Long.valueOf(request.getParameter("idAgencia"));
		String cnpjAgencia = request.getParameter("cnpj");
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");
		String pais = request.getParameter("pais");
		Date dataPartida = Date.valueOf(request.getParameter("dataPartida"));
		Integer duracaoDias = Integer.valueOf(request.getParameter("duracao"));
		BigDecimal valor = BigDecimal.valueOf(Double.valueOf(request.getParameter("valor")));
		String descricao = request.getParameter("descricao");

		Pacote pacote = new Pacote(
				id, idAgencia, cnpjAgencia, cidade,
				estado, pais, dataPartida,
				duracaoDias, valor, descricao
		);
		pacoteDAO.update(pacote);
		response.sendRedirect("lista");
	}

	private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		Pacote pacote = pacoteDAO.getbyID(id);
		request.setAttribute("pacote", pacote);
			
		this.apresentaFormCadastro(request, response);
	}
	
	private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/agencia/formulario.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insercao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		Long idAgencia = Long.valueOf(request.getParameter("idAgencia"));
		String cnpjAgencia = request.getParameter("cnpj");
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");
		String pais = request.getParameter("pais");
		Date dataPartida = Date.valueOf(request.getParameter("dataPartida"));
		Integer duracaoDias = Integer.valueOf(request.getParameter("duracao"));
		BigDecimal valor = BigDecimal.valueOf(Double.valueOf(request.getParameter("valor")));
		String descricao = request.getParameter("descricao");

		Pacote pacote = new Pacote(
				idAgencia, cnpjAgencia, cidade,
				estado, pais, dataPartida,
				duracaoDias, valor, descricao
		);
		pacoteDAO.insert(pacote);
		response.sendRedirect("lista");
	}

}