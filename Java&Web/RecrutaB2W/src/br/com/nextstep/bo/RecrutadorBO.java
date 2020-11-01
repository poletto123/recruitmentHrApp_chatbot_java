package br.com.nextstep.bo;

import java.util.List;

import br.com.nextstep.beans.Recrutador;
import br.com.nextstep.dao.CandidatoDAO;
import br.com.nextstep.dao.RecrutadorDAO;

public class RecrutadorBO {

	public static String apagarRecrutador(int id) throws Exception{
		if(id < 1) {
			return "ID inválido";
		}
		
		RecrutadorDAO dao = new RecrutadorDAO();


		dao.deleteById(id);
		dao.fechar();
		
		return "Apagou";
	
	}
	
	public static Recrutador mostraRecrutador(int id) throws Exception{
		if(id < 1) {
			return new Recrutador();
		}
		
		RecrutadorDAO dao = new RecrutadorDAO();
		Recrutador recrutador = dao.getById(id);
		
		dao.fechar();
		
		return recrutador;
	}
	
	public static List<Recrutador> mostraRecrutador() throws Exception{
			
		RecrutadorDAO dao = new RecrutadorDAO();
			
		List<Recrutador> listaRecrutadores = dao.getAll();
		
		dao.fechar();
		
		return listaRecrutadores;
		
		
	}
	
	public static boolean mostraLogin(String email,String senha) throws Exception{
		
		if(email == null) {
			return false;
		}
		
		RecrutadorDAO dao = new RecrutadorDAO();
		boolean isValidado = dao.getByLogin(email,senha);
		
		dao.fechar();
		
		return isValidado;
	}
	
	public static String atualizaEmail(String email, String senha, Recrutador recrutador) throws Exception{
		
		if(recrutador.getEmail() == null) {
			return "Email nulo";
		}
		
		if(recrutador.getSenha() == null) {
			return "Senha nula";
		}
				
		RecrutadorDAO dao = new RecrutadorDAO();

		dao.modifyEmail(recrutador.getEmail(),recrutador.getSenha());
		
		return "Email atualizado";
	
				
	}
	
	public static String add(Recrutador recrutador) throws Exception {
		
		if(recrutador.getNome() == null) {
			return "Nome nulo";
		}
		
		if(recrutador.getEmail() == null) {
			return "Email nulo";
		}
		
		if(recrutador.getSenha() == null) {
			return "Senha nula";
		}
				
		RecrutadorDAO dao = new RecrutadorDAO();

		dao.add(recrutador);
		dao.fechar();
		return "Cadastrado";

	}

}
