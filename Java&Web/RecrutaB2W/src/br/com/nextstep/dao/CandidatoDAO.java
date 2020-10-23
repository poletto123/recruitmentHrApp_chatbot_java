package br.com.nextstep.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.nextstep.beans.Candidato;
import br.com.nextstep.beans.Usuario;
import br.com.nextstep.conexao.ConectaBanco;
import br.com.nextstep.util.PadraoDAO;

public class CandidatoDAO implements PadraoDAO<Candidato> {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public CandidatoDAO() throws Exception{
		con = ConectaBanco.conectar();
	}
	
	@Override
	public void fechar() throws Exception{
		con.close();
	}
	
	@Override
	public int add(Candidato objeto) throws Exception{
			
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = new Usuario(objeto.getId(), objeto.getNome(), objeto.getEmail(), objeto.getSenha(), objeto.getCpf());
		usuarioDAO.add(usuario);
		
		stmt = con.prepareStatement("INSERT INTO T_RBW_CAND (NR_ID, DT_NASCIMENTO, NM_PONTUACAO, NM_VAGA) VALUES(?, ?, ?, ?)");
		
		stmt.setInt(1, objeto.getId());
		stmt.setString(2, objeto.getDataNascimento());
		stmt.setInt(3, objeto.getPontuacao());
		stmt.setString(4, objeto.getVaga());
		
		return stmt.executeUpdate();
	}
	
	@Override
	public int deleteById(int id) throws Exception{
		
		PreparedStatement stmt = con.prepareStatement("DELETE FROM T_RBW_CAND WHERE NR_ID=?");
		stmt.setInt(1, id);
		
		return stmt.executeUpdate();
		
	}
	
	public int modifyEmail(int id, String email) throws Exception {
		stmt = con.prepareStatement("UPDATE T_RBW_USUA SET DS_EMAIL=? WHERE NR_ID=?");
		stmt.setString(1, email);
		stmt.setInt(2, id);
		
		return stmt.executeUpdate();
	}
	
	@Override
	public Candidato getById(int id) throws Exception{
		
		stmt = con.prepareStatement("SELECT * FROM TB_RBW_CAND INNER JOIN T_RBW_USUA "
				+ "ON TB_RBW_CAND.NR_ID = T_RBW_USUA.NR_ID "
				+ "WHERE T_RBW_USUA.NR_ID=?");
		stmt.setInt(1, id);
		
		rs = stmt.executeQuery();
		
		if(rs.next()) {
			
			return new Candidato(
					
					rs.getInt("T_RBW_USUA.NR_ID"),
					rs.getString("T_RBW_USUA.NM_USUA"),
					rs.getString("T_RBW_USUA.DS_EMAIL"),
				    rs.getString("T_RBW_USUA.NM_SENHA"),
				    rs.getString("T_RBW_USUA.NR_CPF"),
					rs.getString("T_RBW_CAND.DT_NASCIMENTO"),
					rs.getInt("T_RBW_CAND.NM_PONTUACAO"),
					rs.getString("T_RBW_CAND.NM_VAGA")
					
					);

		}
		
		return new Candidato();
	}

	@Override
	public List<Candidato> getAll() throws Exception {

		stmt = con.prepareStatement("SELECT * FROM TB_RBW_CAND INNER JOIN T_RBW_USUA "
				+ "ON TB_RBW_CAND.NR_ID = T_RBW_USUA.NR_ID");
	
		rs = stmt.executeQuery();
		
		List<Candidato> listaCandidatos = new ArrayList<Candidato>();
		
		while(rs.next()) {
			
			Candidato candidato = new Candidato(
					
					rs.getInt("T_RBW_USUA.NR_ID"),
					rs.getString("T_RBW_USUA.NM_USUA"),
					rs.getString("T_RBW_USUA.DS_EMAIL"),
				    rs.getString("T_RBW_USUA.NM_SENHA"),
				    rs.getString("T_RBW_USUA.NR_CPF"),
					rs.getString("T_RBW_CAND.DT_NASCIMENTO"),
					rs.getInt("T_RBW_CAND.NR_PONTUACAO"),
					rs.getString("T_RBW_CAND.NR_VAGA")
					
					);
		
			listaCandidatos.add(candidato);

		}
		
		return listaCandidatos;
	}
	
}
