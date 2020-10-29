package br.com.nextstep.bo;

import br.com.nextstep.beans.Chatbot;
import br.com.nextstep.dao.ChatbotDAO;

public class ChatbotBO {

	public static String novoChatbot(Chatbot chat) throws Exception{

		if(chat.getRespostas() == null) {
			return "Conversa de chatbot não foi realizada";
		}
		
		ChatbotDAO dao = new ChatbotDAO();

		dao.add(chat);
		dao.fechar();
		return "Cadastrado";
	}

	public static Chatbot pesquisarChatbot(int id) throws Exception{
		if(id < 1) {
			//throw new RuntimeException("ID inv�lido");
			return new Chatbot();
		}
		
		ChatbotDAO dao = new ChatbotDAO();
		Chatbot resposta = dao.getById(id);
		
		dao.fechar();
		
		return resposta;
	}
	
	public static String atualizaChatbot(int id, Chatbot chat)throws Exception{
		if(id < 1) {
			return "ID inválido";
		}
		
		if(chat.getRespostas() == null) {
			return "Arquivo inexistente de vídeo";
		}
		
		ChatbotDAO dao = new ChatbotDAO();

		dao.modifyConversa(chat.getRespostas(), id);
		dao.fechar();
		
		return "Conversa de chatbot atualizada";
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
