package br.com.nextstep.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.nextstep.beans.Candidato;
import br.com.nextstep.beans.Usuario;
import br.com.nextstep.conexao.ConectaBanco;

public class CandidatoDAO {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public CandidatoDAO() throws Exception{

		con =  ConectaBanco.conectar();
	}
	
	public void fecharConexao() throws Exception{

		con.close();
	}
	
	public int addUsuario(Usuario objeto) throws Exception{

		con = ConectaBanco.conectar();

		stmt = con.prepareStatement("INSERT INTO T_RBW_USUA (NR_CPF, NM_USUA, DS_EMAIL, NM_SENHA) VALUES (?, ?, ?, ?)");
		
		stmt.setString(1, objeto.getCpf());
		stmt.setString(2, objeto.getNome());
		stmt.setString(3, objeto.getEmail());
		stmt.setString(4, objeto.getSenha());

		return stmt.executeUpdate();
	}
	
	public int addCandidato(Candidato objeto) throws Exception{
		
		con = ConectaBanco.conectar();
		
		stmt = con.prepareStatement("INSERT INTO T_RBW_CAND (NR_CPF,DT_NASCIMENTO, NM_PONTUACAO, NM_VAGA) VALUES(?, ?, ?, ?)");

		stmt.setString(1, objeto.getCpf());
		stmt.setString(2, objeto.getDataNascimento());
		stmt.setInt(3, objeto.getPontuacao());
		stmt.setString(4, objeto.getVaga());
		
		return stmt.executeUpdate();
	}
	
	public int delete(String cpf) throws Exception{
		Connection con = ConectaBanco.conectar();
		
		PreparedStatement stmt = con.prepareStatement("DELETE FROM T_RBW_CAND WHERE NR_CPF=?");
		stmt.setString(1, cpf);
		
		return stmt.executeUpdate();
		
	}
	
	public int modifyDate(Date data, int cpf) throws Exception {
		stmt = con.prepareStatement("UPDATE T_RBW_USUA SET DS_EMAIL=? WHERE NR_CPF=?");
		stmt.setDate(1, data);
		stmt.setInt(2, cpf);
		
		return stmt.executeUpdate();
	}
	
	public Candidato mostrar(String cpf) throws Exception{
		stmt = con.prepareStatement("SELECT * FROM T_RBW_CAND WHERE NR_CPF=?");
		
		stmt.setString(1, cpf);
		
		rs = stmt.executeQuery();
		
		if(rs.next()) {
			
			return new Candidato(
					
					rs.getString("DT_NASCIMENTO"),
					rs.getString("NM_VAGA"),
					rs.getInt("NM_PONTUACAO")
					
					);

		}
		
		return new Candidato();
	}
	
	public Usuario mostrarUsuario(String cpf) throws Exception{
		stmt = con.prepareStatement("SELECT * FROM T_RBW_USUA WHERE NR_CPF=?");
		
		stmt.setString(1, cpf);
		
		rs = stmt.executeQuery();
		
		if(rs.next()) {
			
			return new Usuario(
					
					rs.getString("NM_USUA"),
					rs.getString("DS_EMAIL"),
					rs.getString("NM_SENHA"),
					rs.getString("NR_CPF")
					
					);

		}
		
		return new Usuario();
	}
	
}
