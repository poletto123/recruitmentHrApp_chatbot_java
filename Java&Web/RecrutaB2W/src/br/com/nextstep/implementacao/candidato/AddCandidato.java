package br.com.nextstep.implementacao.candidato;

import br.com.nextstep.beans.Candidato;
import br.com.nextstep.beans.Usuario;
import br.com.nextstep.dao.CandidatoDAO;
import br.com.nextstep.util.Resume;

public class AddCandidato {
	
	public static void cadastrar(CandidatoDAO dao, Usuario usuario, Candidato candidato) throws Exception{
		usuario.setNome(Resume.s("Nome"));
		usuario.setCpf(Resume.s("CPF"));
		usuario.setEmail(Resume.s("Email"));
		usuario.setSenha(Resume.s("Senha"));
		
		//candidato
		candidato.setCpf(usuario.getCpf());
		//candidato.setNome(usuario.getNome());
		candidato.setDataNascimento(Resume.s("Data"));
		candidato.setPontuacao(Resume.i("Pontuação"));
		candidato.setVaga(Resume.s("Vaga"));
		
		
		if(dao.add(usuario) == 0) {
			System.out.println("Não Gravou usuario");
		}else {
			System.out.println("Gravado usuario");
		}
		
		if(dao.add(candidato) == 0) {
			System.out.println("Não Gravou candidato");
		}else {
			System.out.println("Gravado candidato");
		}
		
		
		dao.fechar();
	}

}
