package br.com.nextstep.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.nextstep.beans.Recrutador;
import br.com.nextstep.conexao.ConectaBanco;
import br.com.nextstep.util.PadraoDAO;

public class RecrutadorDAO implements PadraoDAO<Recrutador> {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public RecrutadorDAO() throws Exception{
		con =  ConectaBanco.conectar();
	}
	
	@Override
	public void fechar() throws Exception{
		con.close();
	}
	
	@Override
	public int add(Recrutador objeto) throws Exception{

		stmt = con.prepareStatement("INSERT INTO T_RBW_RECRUTADOR (NM_RECRUTADOR, DS_EMAIL, NM_SENHA) VALUES (?, ?, ?)");

		stmt.setString(1, objeto.getNome());
		stmt.setString(2, objeto.getEmail());
		stmt.setString(3, objeto.getSenha());

		return stmt.executeUpdate();
	}
	
	@Override
	public int deleteById(int id) throws Exception{
	
		PreparedStatement stmt = con.prepareStatement("DELETE FROM T_RBW_RECRUTADOR WHERE CD_RECRUTADOR=?");
		stmt.setInt(1, id);
		
		return stmt.executeUpdate();
		
	}
	
	public int modifyEmail(String email, String senha) throws Exception {
		
		stmt = con.prepareStatement("UPDATE T_RBW_RECRUTADOR SET DS_EMAIL=? WHERE NM_SENHA=?");
		stmt.setString(1, email);
		stmt.setString(2, senha);
		
		return stmt.executeUpdate();
	}
	
	@Override
	public Recrutador getById(int id) throws Exception{
		
		stmt = con.prepareStatement("SELECT * FROM T_RBW_RECRUTADOR WHERE CD_RECRUTADOR=?");
		stmt.setInt(1, id);
		
		rs = stmt.executeQuery();
		
		if(rs.next()) {
			
			return new Recrutador(
					
					rs.getInt("CD_RECRUTADOR"),
					rs.getString("NM_RECRUTADOR"),
					rs.getString("DS_EMAIL"),
					rs.getString("NM_SENHA")
	
					);
		}
		
		return new Recrutador();
	}

	@Override
	public List<Recrutador> getAll() throws Exception {

		stmt = con.prepareStatement("SELECT * FROM T_RBW_RECRUTADOR");
	
		rs = stmt.executeQuery();
		
		List<Recrutador> listaUsuarios = new ArrayList<Recrutador>();
		
		while(rs.next()) {
			
			Recrutador usuario = new Recrutador(
					
					rs.getInt("CD_RECRUTADOR"),
					rs.getString("NM_RECRUTADOR"),
					rs.getString("DS_EMAIL"),
					rs.getString("NM_SENHA")
	
					);
			
			listaUsuarios.add(usuario);

		}
		
		return listaUsuarios;
	}
	
	public boolean getByLogin(String email, String senha) throws Exception{
		
		stmt = con.prepareStatement("SELECT * FROM T_RBW_RECRUTADOR WHERE DS_EMAIL='" + email +  "' AND NM_SENHA='"+ senha +"'");
	
		rs = stmt.executeQuery();
		
		if(rs.next()) {
			return true;					
		}
		return false;
	}
	
	
}
