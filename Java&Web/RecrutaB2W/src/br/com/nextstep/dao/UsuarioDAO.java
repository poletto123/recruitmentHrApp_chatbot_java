package br.com.nextstep.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.nextstep.beans.Recrutador;
import br.com.nextstep.conexao.ConectaBanco;
import br.com.nextstep.util.PadraoDAO;

public class UsuarioDAO implements PadraoDAO<Recrutador> {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public UsuarioDAO() throws Exception{
		con =  ConectaBanco.conectar();
	}
	
	@Override
	public void fechar() throws Exception{
		con.close();
	}
	
	@Override
	public int add(Recrutador objeto) throws Exception{

		stmt = con.prepareStatement("INSERT INTO T_RBW_USUA "
				+ "(NR_ID, NR_CPF, NM_USUA, DS_EMAIL, NM_SENHA) VALUES (?, ?, ?, ?, ?)");

		stmt.setInt(1, objeto.getId());
		stmt.setString(2, objeto.getCpf());
		stmt.setString(3, objeto.getNome());
		stmt.setString(4, objeto.getEmail());
		stmt.setString(5, objeto.getSenha());

		return stmt.executeUpdate();
	}
	
	@Override
	public int deleteById(int id) throws Exception{
	
		PreparedStatement stmt = con.prepareStatement("DELETE FROM T_RBW_USUA WHERE NR_ID=?");
		stmt.setInt(1, id);
		
		return stmt.executeUpdate();
		
	}
	
	public int modifyEmail(String email, String cpf) throws Exception {
		
		stmt = con.prepareStatement("UPDATE T_RBW_USUA SET DS_EMAIL=? WHERE NR_CPF=?");
		stmt.setString(1, email);
		stmt.setString(2, cpf);
		
		return stmt.executeUpdate();
	}
	
	@Override
	public Recrutador getById(int id) throws Exception{
		
		stmt = con.prepareStatement("SELECT * FROM T_RBW_USUA WHERE NR_ID=?");
		stmt.setInt(1, id);
		
		rs = stmt.executeQuery();
		
		if(rs.next()) {
			
			return new Recrutador(
					
					rs.getInt("NR_ID"),
					rs.getString("NM_USUA"),
					rs.getString("DS_EMAIL"),
					rs.getString("NM_SENHA"),
					rs.getString("NR_CPF")
					
					);
		}
		
		return new Recrutador();
	}

	@Override
	public List<Recrutador> getAll() throws Exception {

		stmt = con.prepareStatement("SELECT * FROM T_RBW_USUA");
	
		rs = stmt.executeQuery();
		
		List<Recrutador> listaUsuarios = new ArrayList<Recrutador>();
		
		while(rs.next()) {
			
			Recrutador usuario = new Recrutador(
					
					rs.getInt("T_RBW_USUA.NR_ID"),
					rs.getString("T_RBW_USUA.NM_USUA"),
					rs.getString("T_RBW_USUA.DS_EMAIL"),
				    rs.getString("T_RBW_USUA.NM_SENHA"),
				    rs.getString("T_RBW_USUA.NR_CPF")
					
					);
		
			listaUsuarios.add(usuario);

		}
		
		return listaUsuarios;
	}
	
	
}
