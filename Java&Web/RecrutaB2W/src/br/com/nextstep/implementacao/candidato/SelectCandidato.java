package br.com.nextstep.implementacao.candidato;

import br.com.nextstep.dao.CandidatoDAO;
import br.com.nextstep.util.Resume;

public class SelectCandidato {

	public static void retornarDados(CandidatoDAO dao) throws Exception{
		String cpf = Resume.s("Digite o CPF do Usuário: ");
		System.out.println(dao.mostrar(cpf));
		System.out.println(dao.mostrarUsuario(cpf));
		dao.fecharConexao();
	}
	
}
