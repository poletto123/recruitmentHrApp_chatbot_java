package br.com.nextstep.implementacao.candidato;

import br.com.nextstep.dao.CandidatoDAO;
import br.com.nextstep.util.Resume;

public class SelectCandidato {

	public static void retornarDados(CandidatoDAO dao) throws Exception{
		String cpf = Resume.s("Digite o CPF do Usuário: ");
		System.out.println(dao.getById(cpf)); // AQUI DEVEMOS FAZER UM MÉTODO DE DELETE NO DAO QUE TENHA COMO PARÂMETRO UMA STRING
		dao.fechar();
	}
	
}
