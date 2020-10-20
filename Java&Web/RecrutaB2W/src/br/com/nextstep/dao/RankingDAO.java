package br.com.nextstep.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import br.com.nextstep.beans.Candidato;
import br.com.nextstep.conexao.ConectaBanco;
import br.com.nextstep.util.PadraoDAO;

public class RankingDAO implements PadraoDAO<Candidato>{

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public RankingDAO() throws Exception {
		con =  ConectaBanco.conectar();
	}
	
	@Override
	public void fechar() throws Exception{

		con.close();
	}
	
	@Override
	public int add(Candidato objeto) throws Exception{
		
		con = ConectaBanco.conectar();
		
		stmt = con.prepareStatement("INSERT INTO T_RBW_CAND (NR_CPF,DT_NASCIMENTO, NM_PONTUACAO, NM_VAGA) VALUES(?, ?, ?, ?)");

		stmt.setString(1, objeto.getCpf());
		stmt.setString(2, objeto.getDataNascimento());
		stmt.setInt(3, objeto.getPontuacao());
		stmt.setString(4, objeto.getVaga());
		
		return stmt.executeUpdate();
	}

	@Override
	public Candidato getById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Candidato> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteById(int id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
