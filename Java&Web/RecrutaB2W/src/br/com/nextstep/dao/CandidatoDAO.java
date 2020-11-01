package br.com.nextstep.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.nextstep.beans.AudioVideo;
import br.com.nextstep.beans.Candidato;
import br.com.nextstep.beans.Chatbot;
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

		stmt = con.prepareStatement("INSERT INTO T_RBW_CANDIDATO (NR_CPF, DT_NASCIMENTO, NR_MEDALHA, NM_CANDIDATO, NM_SENHA, DS_EMAIL) VALUES(?, TO_DATE(?,'YYYY-MM-DD'), ?, ?, ?, ?)");
		
		stmt.setString(1, objeto.getCpf());
		stmt.setString(2, objeto.getDataNascimento());
		stmt.setInt(3, 0);
		stmt.setString(4, objeto.getNome());
		stmt.setString(5, objeto.getSenha());
		stmt.setString(6, objeto.getEmail());
		
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
	
	public int modifyChatbot(int cpf, Chatbot objeto) throws Exception {
		stmt = con.prepareStatement("UPDATE T_RBW_CANDIDATO SET CD_CHATBOT=? WHERE NR_CPF=?");
		stmt.setInt(1, objeto.getId());
		stmt.setInt(2, cpf);
		
		return stmt.executeUpdate();
	}
	
	public int modifyAudioVideo(int cpf, AudioVideo objeto) throws Exception {
		stmt = con.prepareStatement("UPDATE T_RBW_CANDIDATO SET CD_AUDIO_VIDEO=? WHERE NR_CPF=?");
		stmt.setInt(1, objeto.getId());
		stmt.setInt(2, cpf);
		
		return stmt.executeUpdate();
	}
	
	@Override
	public Candidato getById(int id) throws Exception{
		
		stmt = con.prepareStatement("SELECT * FROM T_RBW_CANDIDATO "
								+ "INNER JOIN T_RBW_VAGA "
								+ "ON T_RBW_CANDIDATO.NR_VAGA = T_RBW_VAGA.NR_VAGA "
								+ "INNER JOIN T_RBW_RECRUTADOR "
								+ "ON T_RBW_CANDIDATO.CD_RECRUTADOR = T_RBW_RECRUTADOR.CD_RECRUTADOR"
								+ "WHERE CD_CANDIDATO=?");
		stmt.setInt(1, id);
		
		rs = stmt.executeQuery();
		
		if(rs.next()) {
			
			return new Candidato(
					
					rs.getInt("CD_CANDIDATO"),
					rs.getString("NM_CANDIDATO"),
					rs.getString("DS_EMAIL"),
					rs.getString("DT_NASCIMENTO"),
					new Vaga(
							rs.getInt("NR_VAGA"),
							rs.getString("NM_VAGA"),
							rs.getString("DS_VAGA"),
							rs.getDouble("VL_SALARIO")
							),
					rs.getInt("NR_MEDALHA"),
				    rs.getString("NR_CPF"),
					new Recrutador(
							rs.getInt("CD_RECRUTADOR"),
							rs.getString("NM_RECRUTADOR"),
							rs.getString("DS_EMAIL")
					));
			
//			return new Candidato(
//					
//					rs.getInt("CD_CANDIDATO"),
//					rs.getString("NM_CANDIDATO"),
//					rs.getString("DS_EMAIL"),
//					rs.getString("NM_SENHA"),
//					rs.getString("DT_NASCIMENTO"),
//					new Vaga(
//							rs.getInt("NR_VAGA"),
//							rs.getString("NM_VAGA"),
//							rs.getString("DS_VAGA"),
//							rs.getDouble("VL_SALARIO")
//							),
//					rs.getInt("NR_MEDALHA"),
//				    rs.getString("NR_CPF"),
//					new Recrutador(
//							rs.getInt("CD_RECRUTADOR"),
//							rs.getString("NM_RECRUTADOR"),
//							rs.getString("DS_EMAIL")
//							),
//					new Chatbot(
//							rs.getInt("CD_CHATBOT"),
//							rs.getString("DS_RESPOSTA")
//							),
//					new AudioVideo(
//							rs.getString("FL_AUDIO"),
//							rs.getString("FL_VIDEO"),
//							rs.getInt("CD_AUDIO_VIDEO")
//							)
//					);
					
		}
		
		return new Candidato();
	}

	@Override
	public List<Candidato> getAll() throws Exception {

		stmt = con.prepareStatement("SELECT * FROM T_RBW_CANDIDATO "
				+ "INNER JOIN T_RBW_VAGA "
				+ "ON T_RBW_CANDIDATO.NR_VAGA = T_RBW_VAGA.NR_VAGA "
				+ "INNER JOIN T_RBW_RECRUTADOR "
				+ "ON T_RBW_CANDIDATO.CD_RECRUTADOR = T_RBW_RECRUTADOR.CD_RECRUTADOR");
	
		
		rs = stmt.executeQuery();
		
		List<Candidato> listaMedalhaZero = new ArrayList<Candidato>();
		List<Candidato> listaMedalhaUm = new ArrayList<Candidato>();
		List<Candidato> listaMedalhaDois = new ArrayList<Candidato>();

		
		while(rs.next()) {
			
			Candidato candidato = new Candidato(
					
					rs.getInt("CD_CANDIDATO"),
					rs.getString("NM_CANDIDATO"),
					rs.getString("DS_EMAIL"),
					rs.getString("DT_NASCIMENTO"),
					new Vaga(
							rs.getInt("NR_VAGA"),
							rs.getString("NM_VAGA"),
							rs.getString("DS_VAGA"),
							rs.getDouble("VL_SALARIO")
							),
					rs.getInt("NR_MEDALHA"),
				    rs.getString("NR_CPF"),
					new Recrutador(
							rs.getInt("CD_RECRUTADOR"),
							rs.getString("NM_RECRUTADOR"),
							rs.getString("DS_EMAIL")
					));
			
//			Candidato candidato = new Candidato(
//					
//					rs.getInt("CD_CANDIDATO"),
//					rs.getString("NM_CANDIDATO"),
//					rs.getString("DS_EMAIL"),
//					rs.getString("NM_SENHA"),
//					rs.getString("DT_NASCIMENTO"),
//					new Vaga(
//							rs.getInt("NR_VAGA"),
//							rs.getString("NM_VAGA"),
//							rs.getString("DS_VAGA"),
//							rs.getDouble("VL_SALARIO")
//							),
//					rs.getInt("NR_MEDALHA"),
//				    rs.getString("NR_CPF"),
//					new Recrutador(
//							rs.getInt("CD_RECRUTADOR"),
//							rs.getString("NM_RECRUTADOR"),
//							rs.getString("DS_EMAIL")
//							),
//					new Chatbot(
//							rs.getInt("CD_CHATBOT"),
//							rs.getString("DS_RESPOSTA")
//							),
//					new AudioVideo(
//							rs.getString("FL_AUDIO"),
//							rs.getString("FL_VIDEO"),
//							rs.getInt("CD_AUDIO_VIDEO")
//							)
//					);
			
			if (candidato.getNumeroMedalha() == 0) {
				listaMedalhaZero.add(candidato);
			} else if (candidato.getNumeroMedalha() == 1) {
				listaMedalhaUm.add(candidato);
			} else if (candidato.getNumeroMedalha() == 2) {
				listaMedalhaDois.add(candidato);
			}
		}
		
		List<Candidato> listaCandidatos = new ArrayList<Candidato>();
		listaCandidatos.addAll(listaMedalhaDois);
		listaCandidatos.addAll(listaMedalhaUm);
		listaCandidatos.addAll(listaMedalhaZero);
		
		return listaCandidatos;
	}
	
}
