package br.com.nextstep.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.nextstep.beans.Candidato;
import br.com.nextstep.beans.Recrutador;
import br.com.nextstep.beans.Vaga;
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

		stmt = con.prepareStatement("INSERT INTO T_RBW_CANDIDATO (NR_CPF, DT_NASCIMENTO, NM_CANDIDATO, NM_SENHA, DS_EMAIL) VALUES(?, ?, ?, ?, ?)");
		
		stmt.setString(1, objeto.getCpf());
		stmt.setString(2, objeto.getDataNascimento());
		stmt.setString(3, objeto.getNome());
		stmt.setString(4, objeto.getSenha());
		stmt.setString(5, objeto.getEmail());
		
		return stmt.executeUpdate();
	}
	
	@Override
	public int deleteById(int id) throws Exception{
		
		PreparedStatement stmt = con.prepareStatement("DELETE FROM T_RBW_CANDIDATO WHERE CD_CANDIDATO=?");
		stmt.setInt(1, id);
		
		return stmt.executeUpdate();
		
	}
	
	public int modifyEmail(int id, String email) throws Exception {
		stmt = con.prepareStatement("UPDATE T_RBW_CANDIDATO SET DS_EMAIL=? WHERE CD_CANDIDATO=?");
		stmt.setString(1, email);
		stmt.setInt(2, id);
		
		return stmt.executeUpdate();
	}
	
	@Override
	public Candidato getById(int id) throws Exception{
		
		stmt = con.prepareStatement("SELECT * FROM T_RBW_CANDIDATO WHERE CD_CANDIDATO=?");
		stmt.setInt(1, id);
		
		rs = stmt.executeQuery();
		
		if(rs.next()) {
			
			return new Candidato(
					
					rs.getInt("CD_CANDIDATO"),
					rs.getString("DT_NASCIMENTO"),
					new Vaga(
							rs.getInt("NR_VAGA"),
							rs.getString("NM_VAGA"),
							rs.getString("DS_VAGA"),
							rs.getDouble("VL_SALARIO")
							),
					rs.getInt("NR_MEDALHA"),
					rs.getString("NM_CANDIDATO"),
					rs.getString("DS_EMAIL"),
				    rs.getString("NM_SENHA"),
				    rs.getString("NR_CPF"),
				    rs.getInt("CD_RECRUTADOR")
					);

		}
		
		return new Candidato();
	}

	@Override
	public List<Candidato> getAll() throws Exception {

		stmt = con.prepareStatement("SELECT * FROM T_RBW_CANDIDATO");
	
		rs = stmt.executeQuery();
		
		List<Candidato> listaCandidatos = new ArrayList<Candidato>();
		
		while(rs.next()) {
			
			Candidato candidato = new Candidato(
					
					rs.getInt("CD_CANDIDATO"),
					rs.getString("DT_NASCIMENTO"),
					new Vaga(
							rs.getInt("NR_VAGA"),
							rs.getString("NM_VAGA"),
							rs.getString("DS_VAGA"),
							rs.getDouble("VL_SALARIO")
							),
					rs.getInt("NR_MEDALHA"),
					rs.getString("NM_CANDIDATO"),
					rs.getString("DS_EMAIL"),
				    rs.getString("NM_SENHA"),
				    rs.getString("NR_CPF"),
				    rs.getInt("CD_RECRUTADOR")
					);
		
			listaCandidatos.add(candidato);

		}
		
		return listaCandidatos;
	}
	
}
