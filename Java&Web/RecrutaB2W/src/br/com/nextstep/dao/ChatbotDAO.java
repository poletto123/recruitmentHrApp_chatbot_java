package br.com.nextstep.dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

		stmt = con.prepareStatement("INSERT INTO T_RBW_CHATBOT (DS_RESPOSTA) VALUES (?)");
		stmt.setArray(1, (Array) chatbot.getRespostas());

		return stmt.executeUpdate();
	}
	
	@Override
	public int deleteById(int id) throws Exception{
		Connection con = ConectaBanco.conectar();
		
		PreparedStatement stmt = con.prepareStatement("DELETE FROM T_RBW_CHATBOT WHERE CD_CHATBOT=?");
		stmt.setInt(1, id);
		
		return stmt.executeUpdate();
		
	}
	
	public int modifyConversa(ArrayList<String> conversa, int numero) throws Exception {
		stmt = con.prepareStatement("UPDATE T_RBW_CHATBOT SET DS_RESPOSTA=? WHERE CD_CHATBOT=?");
		stmt.setArray(1, (Array) conversa);
		stmt.setInt(2, numero);
		
		return stmt.executeUpdate();
	}
	
	@Override
	public Chatbot getById(int id) throws Exception{
		stmt = con.prepareStatement("SELECT * FROM T_RBW_CHATBOT WHERE CD_CHATBOT=?");
		stmt.setInt(1, id);
		
		rs = stmt.executeQuery();
		
		if(rs.next()) {
			
			return new Chatbot(
					rs.getInt("CD_CHATBOT"),
					(ArrayList<String>) rs.getArray("DS_RESPOSTA")
					);
		}
		
		return new Chatbot();
	}

	@Override
	public List<Chatbot> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
