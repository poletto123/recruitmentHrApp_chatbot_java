package br.com.nextstep.implementacao.candidato;

import br.com.nextstep.dao.CandidatoDAO;
import br.com.nextstep.dao.UsuarioDAO;
import br.com.nextstep.util.Resume;

public class DelCandidato {
	
	public static void deletar(UsuarioDAO dao, CandidatoDAO dao2) throws Exception{
		String apaga = Resume.s("Digite o CPF do Usuário que deseja apagar: ");
		
		if(dao.deleteById(apaga) == 0) { // AQUI DEVEMOS FAZER UM MÉTODO DE DELETE NO DAO QUE TENHA COMO PARÂMETRO UMA STRING
			System.out.println("Não Apagou");
		}else {
			System.out.println("Apagou");
		}
		
		if(dao2.deleteById(apaga) == 0) {
			System.out.println("Não Apagou candidato");
		}else {
			System.out.println("Apagou candidato");
		}
		dao.fechar();
	}

}
