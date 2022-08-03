package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.dao.AgenciaDAO;
import br.ufscar.dc.dsw.dao.UsuarioDAO;
import br.ufscar.dc.dsw.domain.Agencia;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.util.Erro;

@WebServlet(urlPatterns = "/admin/*")
public class AdminController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private UsuarioDAO usuarioDAO;
	private AgenciaDAO agenciaDAO;

	@Override
	public void init() {
		usuarioDAO = new UsuarioDAO();
		agenciaDAO = new AgenciaDAO();
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
				insere(request, response);
				break;
			case "/edicao":
				apresentaFormEdicao(request, response);
				break;
			default:
				home(request, response);
				break;
			}
		} catch (RuntimeException | IOException | ServletException e) {
			throw new ServletException(e);
		}
	}

	private Boolean isAdmin(HttpServletRequest request) {
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
		if (usuario != null) {
			return usuario.getPapel().equals("ADM");
		} else {
			return false;
		}
	}

	private void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (isAdmin(request)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/user.jsp");
			dispatcher.forward(request, response);
		} else {
			acessoNegado(request, response);
		}

	}

	private void acessoNegado(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Erro erros = new Erro();
		erros.add("Acesso não autorizado!");
		request.setAttribute("mensagens", erros);
		RequestDispatcher rd = request.getRequestDispatcher("/noAuth.jsp");
		rd.forward(request, response);
	}

	private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (isAdmin(request)) {
			String tipo = request.getParameter("tipo").toString();
			if (tipo.equals("usuario")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/formulario.jsp");
				dispatcher.forward(request, response);
			} else if (tipo.equals("agencia")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/formularioAgencia.jsp");
				dispatcher.forward(request, response);
			} else {
				response.sendRedirect(tipo);
			}
		} else {
			acessoNegado(request, response);
		}

	}

	private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		Usuario usuario = usuarioDAO.getbyID(id);
		request.setAttribute("usuario", usuario);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/formulario.jsp");
		dispatcher.forward(request, response);
	}

	private void insere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String tipo = request.getParameter("tipo");
		if (tipo.equals("usuario")) {
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String cpf = request.getParameter("cpf");
			String sexo = request.getParameter("sexo");
			Date nascimento = null;
			if (request.getParameter("nascimento") != null) {
				nascimento = Date.valueOf(request.getParameter("nascimento"));
			}
			String telefone = request.getParameter("telefone");
			String senha = request.getParameter("senha");
			String papel = request.getParameter("papel");

			Usuario usuario = new Usuario(nome, email, cpf, sexo, nascimento, telefone, senha, papel);
			usuarioDAO.insert(usuario);
		} else if (tipo.equals("agencia")) {
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String cnpj = request.getParameter("cnpj");
			String senha = request.getParameter("senha");
			String descricao = request.getParameter("descricao");

			Agencia agencia = new Agencia(cnpj, nome, email, senha, descricao);
			agenciaDAO.insert(agencia);
		}
		response.sendRedirect("lista");
	}
}