package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.dao.PacoteDAO;
import br.ufscar.dc.dsw.dao.PropostaDAO;
import br.ufscar.dc.dsw.domain.Pacote;
import br.ufscar.dc.dsw.domain.Proposta;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.util.Erro;

@WebServlet(urlPatterns = "/usuario/*")
public class UsuarioController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private PropostaDAO propostaDAO;
	private PacoteDAO pacoteDAO;

	@Override
	public void init() {
		propostaDAO = new PropostaDAO();
		pacoteDAO = new PacoteDAO();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();

		if (action == null) {
			action = "";
		}

		try {
			switch (action) {
			case "/comprar":
				comprar(request, response);
				break;
			case "/deletar":
				deletar(request, response);
				break;
			default:
				home(request, response);
				break;
			}
		} catch (RuntimeException | IOException | ServletException e) {
			Erro erros = new Erro();
			erros.add(e.getMessage());
			request.setAttribute("mensagens", erros);
			RequestDispatcher rd = request.getRequestDispatcher("/erro.jsp");
			rd.forward(request, response);
		}
	}

	private void comprar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");

		String pacote = request.getParameter("pacoteDesejado");
		String valorStr = request.getParameter("valor");
		Date dataAtual = new Date(LocalDate.now().toEpochDay());

		Proposta proposta = new Proposta(usuario.getId(), Long.valueOf(pacote).longValue(), dataAtual, Float.valueOf(valorStr).floatValue());
		if (propostaDAO.getAllbyIDPacote(Long.valueOf(pacote).longValue()).isEmpty()) {
			propostaDAO.insert(proposta);
			response.sendRedirect("lista");
		} else {
			Erro erros = new Erro();
			erros.add("Você já comprou esse pacote!");
			request.setAttribute("mensagens", erros);
			RequestDispatcher rd = request.getRequestDispatcher("/usuario/user.jsp");
			rd.forward(request, response);
			response.sendRedirect("lista");
		}
	}

	private void deletar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");

		Long propostaId = Long.parseLong(request.getParameter("id"));
		
		Proposta proposta = propostaDAO.getbyID(propostaId);
		Pacote pacote = pacoteDAO.getbyID(proposta.getIdPacote());
		
		java.util.Date date = new java.util.Date();
		if ((pacote.getDataPartida().getTime() - date.getTime())/1000 > 432000) {
			propostaDAO.delete(proposta);
			request.setAttribute("prazoEsgotado", false);
			response.sendRedirect("home");
		} else {
			request.setAttribute("prazoEsgotado", true);
			response.sendRedirect("home");
		}
		
	}

	private void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Erro erros = new Erro();
		try {
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");

			if (usuario == null) {
				response.sendRedirect(request.getContextPath());
			} else if (usuario.getPapel() != null && usuario.getPapel().equals("USR")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/usuario/user.jsp");
				dispatcher.forward(request, response);
			} else {
				acessoNegado(request, response);
			}

		} catch (Exception e) {
			erros.add(e.getMessage());
			request.setAttribute("mensagens", erros);
			RequestDispatcher rd = request.getRequestDispatcher("/erro.jsp");
			rd.forward(request, response);
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
}