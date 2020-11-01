package br.com.nextstep.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.assistant.v2.Assistant;
import com.ibm.watson.assistant.v2.model.CreateSessionOptions;
import com.ibm.watson.assistant.v2.model.MessageInput;
import com.ibm.watson.assistant.v2.model.MessageOptions;
import com.ibm.watson.assistant.v2.model.MessageResponse;
import com.ibm.watson.assistant.v2.model.SessionResponse;

import br.com.nextstep.beans.Candidato;
import br.com.nextstep.bo.CandidatoBO;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = {"/ranking", "/login", "/paginacao", "/chat"})
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
				case "/RecrutaB2W/chat":
					chat(request,response);
					break;
				default:
					response.sendRedirect("index.jsp");
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	
	}

	private void chat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String message = request.getParameter("pergunta");
		String resposta = conversationAPI(message);
//		Chat chat = new Chat();
//		chat.addUserMessage(message);
		request.setAttribute("resposta", resposta);
		request.getRequestDispatcher("./WEB-INF/candidato_chatbot.jsp").forward(request, response);
	}
	
	private String conversationAPI(String resposta) {
		
		ServletContext ctx = getServletContext();

		IamAuthenticator authenticator = new IamAuthenticator("QjJRIw8chC1WJ5Ae99A3neY0QzQeq_0L829-Mqaqc9ab");
		Assistant assistant = new Assistant("2020-11-31", authenticator);
		assistant.setServiceUrl("https://api.us-south.assistant.watson.cloud.ibm.com/instances/214ecc19-d036-4afb-a3d2-a0efeabca4bd");
		
		String chatbotSessionId = null;
		
		if (ctx.getAttribute("ChatbotSessionId") == null) {
			CreateSessionOptions sessionOptions = new CreateSessionOptions.Builder("ebfbc50b-c9f5-455f-8513-6fb54cba070a").build();

			
			SessionResponse sessionResponse = assistant.createSession(sessionOptions).execute().getResult();
					
			ctx.setAttribute("ChatbotSessionId", sessionResponse.getSessionId());
			
			chatbotSessionId = sessionResponse.getSessionId();
			
		} else {
			
			chatbotSessionId = (String) ctx.getAttribute("ChatbotSessionId");
			
		}
			
		MessageInput input = new MessageInput.Builder()
				  .messageType("text")
				  .text(resposta)
				  .build();
		
		MessageOptions MsgOptions = new MessageOptions.Builder("ebfbc50b-c9f5-455f-8513-6fb54cba070a", chatbotSessionId)
				  .input(input)
				  .build();

		MessageResponse msgResponse = assistant.message(MsgOptions).execute().getResult();
		
		return msgResponse.getOutput().getGeneric().get(0).text();
		
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
