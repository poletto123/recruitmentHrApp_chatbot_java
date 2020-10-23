package br.com.nextstep.implementacao.candidato;

import br.com.nextstep.dao.CandidatoDAO;
import br.com.nextstep.util.Resume;

public class SelectCandidato {

	public static void retornarDados(CandidatoDAO dao) throws Exception{
		String cpf = Resume.s("Digite o CPF do Usu�rio: ");
		System.out.println(dao.getById(cpf)); // AQUI DEVEMOS FAZER UM M�TODO DE DELETE NO DAO QUE TENHA COMO PAR�METRO UMA STRING
		dao.fechar();
	}
	
}
