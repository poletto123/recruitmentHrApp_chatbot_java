package br.com.nextstep.bo;

import br.com.nextstep.beans.Chatbot;
import br.com.nextstep.dao.ChatbotDAO;

public class ChatbotBO {

	public static int novoChatbot(Chatbot chat) throws Exception{

		if(chat.getRespostas() == null) {
			return 0;
		}
		
		ChatbotDAO dao = new ChatbotDAO();

		int linhasAlteradas = dao.add(chat);
		dao.fechar();
		return linhasAlteradas;
	}

	public static Chatbot pesquisarChatbot(int id) throws Exception{
		if(id < 1) {
			//throw new RuntimeException("ID inv�lido");
			return new Chatbot();
		}
		
		ChatbotDAO dao = new ChatbotDAO();
		Chatbot chatbot = dao.getById(id);
		
		dao.fechar();
		
		return chatbot;
	}
	
	public static int atualizaChatbot(int id, Chatbot chat)throws Exception{
		if(id < 1) {
			return 0;
		}
		
		if(chat.getRespostas() == null) {
			return 0;
		}
		
		ChatbotDAO dao = new ChatbotDAO();

		int linhasAlteradas = dao.modifyConversa(chat, id);
		dao.fechar();
		
		return linhasAlteradas;
	}
	
	
	public static String apagarChatbot(int id) throws Exception{
		if(id < 1) {
			return "ID inválido";
		}
		
		ChatbotDAO dao = new ChatbotDAO();

		dao.deleteById(id);
		dao.fechar();
		
		return "Apagou";
	}
	
}
