package br.com.nextstep.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.nextstep.beans.Candidato;
import br.com.nextstep.bo.CandidatoBO;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = {"/ranking", "/login", "/paginacao"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			switch (request.getRequestURI()) {
		
				case "/RecrutaB2W/login":
					realizaLogin(request, response);
					break;
				case "/RecrutaB2W/paginacao":
					paginacao(request, response);
					break;
				default:
					response.sendRedirect("index.jsp");
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	
	}

	private void paginacao(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if (request.getParameter("pag").equals("candidato_ranking.jsp")) {
			mostraRanking(request, response, "candidato_ranking.jsp");
		} else if (request.getParameter("pag").equals("recrutador_ranking.jsp")) {
			mostraRanking(request, response, "recrutador_ranking.jsp");
		} else {
		request.getRequestDispatcher("./WEB-INF/" + request.getParameter("pag")).forward(request, response);		
		}
	}

	private void realizaLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		 if (request.getParameter("cpmail").equals("candidato")) {
			 request.getRequestDispatcher("./WEB-INF/candidato_index.jsp").forward(request,response);
		 } else if (request.getParameter("cpmail").equals("recrutador")) {
			 request.getRequestDispatcher("./WEB-INF/recrutador_index.jsp").forward(request,response);
		 }
		
	}

	private void mostraRanking(HttpServletRequest request, HttpServletResponse response, String path) throws Exception {
		
		List<Candidato> listaCandidatos = CandidatoBO.mostraCandidato();
		
		if (listaCandidatos.isEmpty() == true) {
			request.getRequestDispatcher("./WEB-INF/" + path).forward(request, response);
		} else {
			request.setAttribute("listaCandidatos", listaCandidatos);
			request.getRequestDispatcher("./WEB-INF/" + path).forward(request, response);
		}
	}
		
		
	}
