package br.com.nextstep.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import br.com.nextstep.beans.Chatbot;
import br.com.nextstep.conexao.ConectaBanco;
import br.com.nextstep.util.PadraoDAO;

public class ChatbotDAO implements PadraoDAO<Chatbot> {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public ChatbotDAO() throws Exception{

		con =  ConectaBanco.conectar();
	}
	
	@Override
	public void fechar() throws Exception{
		con.close();
	}
	
	@Override
	public int add(Chatbot chatbot) throws Exception{

		con = ConectaBanco.conectar();
		
		Gson gson = new Gson();
		String json = gson.toJson(chatbot.getRespostas());

		stmt = con.prepareStatement("INSERT INTO T_RBW_CHATBOT (CD_CHATBOT, DS_RESPOSTA) VALUES (T_RBW_CHATBOT_SEQ.NEXTVAL, ?)");
		stmt.setString(1, json);

		return stmt.executeUpdate();
	}
	
	@Override
	public int deleteById(int id) throws Exception{
		Connection con = ConectaBanco.conectar();
		
		PreparedStatement stmt = con.prepareStatement("DELETE FROM T_RBW_CHATBOT WHERE CD_CHATBOT=?");
		stmt.setInt(1, id);
		
		return stmt.executeUpdate();
		
	}
	
	public int modifyConversa(Chatbot chatbot, int numero) throws Exception {
		
		Gson gson = new Gson();
		String json = gson.toJson(chatbot.getRespostas());
		
		stmt = con.prepareStatement("UPDATE T_RBW_CHATBOT SET DS_RESPOSTA=? WHERE CD_CHATBOT=?");
		stmt.setString(1, json);
		stmt.setInt(2, numero);
		
		return stmt.executeUpdate();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Chatbot getById(int id) throws Exception{
		stmt = con.prepareStatement("SELECT * FROM T_RBW_CHATBOT WHERE CD_CHATBOT=?");
		stmt.setInt(1, id);
				
		rs = stmt.executeQuery();
		
		Gson gson = new Gson();

		if(rs.next()) {
			return new Chatbot(
				rs.getInt("CD_CHATBOT"),
				gson.fromJson
				(rs.getString("DS_RESPOSTA"),
				Map.class));

		}
		
		return new Chatbot();
	}

	@Override
	public List<Chatbot> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
