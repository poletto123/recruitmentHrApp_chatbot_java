package br.com.nexstep.controller;

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
@WebServlet(urlPatterns = {"/ranking", ""})
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
		switch (request.getRequestURI()) {
	
			case "/RecrutaB2W/ranking":
				mostraRanking(request, response);
				break;
			
			default:
				response.sendRedirect("index.jsp");
			}
			
	
	}

	private void mostraRanking(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Candidato> listaCandidatos = CandidatoBO.mostraCandidato();
		
		if (listaCandidatos == null) {
			response.sendRedirect("ranking.jsp?msgStatus=Não existem candidatos");
		} else {
			request.setAttribute("listaCandidatos", listaCandidatos);
			request.getRequestDispatcher("ranking.jsp").forward(request, response);
		}
		
		
	}

}
