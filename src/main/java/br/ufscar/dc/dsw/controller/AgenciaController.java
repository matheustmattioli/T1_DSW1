package br.ufscar.dc.dsw.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.domain.Agencia;
import br.ufscar.dc.dsw.util.Erro;

@WebServlet(urlPatterns = "/agencia/*")
public class AgenciaController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	Agencia agencia = (Agencia) request.getSession().getAttribute("usuarioLogado");
    	Erro erros = new Erro();
    	
    	if (agencia == null) {
    		response.sendRedirect(request.getContextPath());
    	} else if (agencia.getCNPJ() != null) {
    		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/agencia/index.jsp");
            dispatcher.forward(request, response);
    	} else {
    		erros.add("Acesso não autorizado!");
    		request.setAttribute("mensagens", erros);
    		RequestDispatcher rd = request.getRequestDispatcher("/noAuth.jsp");
    		rd.forward(request, response);
    	}
    }
    
}