package br.com.nextstep.bo;

import java.util.List;

import br.com.nextstep.beans.AudioVideo;
import br.com.nextstep.beans.Candidato;
import br.com.nextstep.dao.AudioVideoDAO;
import br.com.nextstep.dao.CandidatoDAO;

public class CandidatoBO {

	public static String apagarCandidato(int id) throws Exception{
		if(id < 1) {
			return "ID inválido";
		}
		
		CandidatoDAO dao = new CandidatoDAO();

		dao.deleteById(id);
		dao.fechar();
		
		return "Apagou";
	}
	
	public static Candidato mostraCandidato(int id) throws Exception{
		if(id < 1) {
			return new Candidato();
		}
		
		CandidatoDAO dao = new CandidatoDAO();
		Candidato candidato = dao.getById(id);
		
		dao.fechar();
		
		return candidato;
	}
	
	public static List<Candidato> mostraCandidato() throws Exception{

		CandidatoDAO dao = new CandidatoDAO();
			
		List<Candidato> listaCandidatos = dao.getAll();
		
		dao.fechar();
		
		return listaCandidatos;
	}
	
	public static String atualizaEmail(int id, AudioVideo av)throws Exception{
		if(id < 1) {
			return "ID inválido";
		}
		
		if(av.getPathAudio() == null) {
			return "Arquivo inexistente de Áudio";
		}
		
		AudioVideoDAO dao = new AudioVideoDAO();

		dao.modifyAudio(id, av);
		dao.fechar();
		
		return "Arquivo de Áudio Atualizado";
	}
	
	public static String add(Candidato candidato) throws Exception {

		if(candidato.getCpf().length() < 11) {
			return "CPF inválido";
		} else if (candidato.getVaga() == null) {
			return "Uma vaga é necessária para adicionar o candidato";
		}
		
		CandidatoDAO dao = new CandidatoDAO();

		dao.add(candidato);
		dao.fechar();
		return "Cadastrado";
	}

}
