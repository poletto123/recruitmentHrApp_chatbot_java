package br.com.nextstep.bo;

import br.com.nextstep.dao.AudioVideoDAO;
import br.com.nextstep.beans.AudioVideo;

public class AudioVideoBO {

	public static String apagarAudioVideo(int id) throws Exception{
		if(id < 1) {
			return "ID inválido";
		}
		
		AudioVideoDAO dao = new AudioVideoDAO();

		dao.delete(id);
		dao.fecharConexao();
		
		return "Apagou";
	}
	
	public static AudioVideo pesquisarAudioVideo(int id) throws Exception{
		if(id < 1) {
			//throw new RuntimeException("ID inválido");
			return new AudioVideo();
		}
		
		AudioVideoDAO dao = new AudioVideoDAO();
		AudioVideo resposta = dao.mostrar(id);

		return resposta;
	}
	
	public static String novoAudioVideo(AudioVideo av) throws Exception{

		if(av.getPathVideo() == null || av.getPathAudio() == null) {
			return "Arquivo inexistente de Áudio ou Vídeo";
		}
		
		//é preferível deixar a conexão do BD no final
		AudioVideoDAO dao = new AudioVideoDAO();

		dao.add(av);
		dao.fecharConexao();
		return "Cadastrado";
	}

}
