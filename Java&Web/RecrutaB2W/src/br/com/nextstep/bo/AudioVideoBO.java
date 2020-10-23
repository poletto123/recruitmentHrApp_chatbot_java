package br.com.nextstep.bo;

import br.com.nextstep.beans.AudioVideo;
import br.com.nextstep.dao.AudioVideoDAO;

public class AudioVideoBO {

	public static String apagarAudioVideo(int id) throws Exception{
		if(id < 1) {
			return "ID inválido";
		}
		
		AudioVideoDAO dao = new AudioVideoDAO();

		dao.deleteById(id);
		dao.fechar();
		
		return "Apagou";
	}
	
	public static AudioVideo pesquisarAudioVideo(int id) throws Exception{
		if(id < 1) {
			//throw new RuntimeException("ID inv�lido");
			return new AudioVideo();
		}
		
		AudioVideoDAO dao = new AudioVideoDAO();
		AudioVideo resposta = dao.getById(id);
		
		dao.fechar();
		
		return resposta;
	}
	
	public static String atualizaAudio(int id, AudioVideo av)throws Exception{
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
	
	public static String atualizaVideo(int id, AudioVideo av)throws Exception{
		if(id < 1) {
			return "ID inválido";
		}
		
		if(av.getPathAudio() == null) {
			return "Arquivo inexistente de Vídeo";
		}
		
		AudioVideoDAO dao = new AudioVideoDAO();

		dao.modifyVideo(id, av);
		dao.fechar();
		
		return "Arquivo de Vídeo Atualizado";
	}
	
	public static String novoAudioVideo(AudioVideo av) throws Exception{

		if(av.getPathVideo() == null || av.getPathAudio() == null) {
			return "Arquivo inexistente de Áudio ou Vídeo";
		}
		
		AudioVideoDAO dao = new AudioVideoDAO();

		dao.add(av);
		dao.fechar();
		return "Cadastrado";
	}

}
