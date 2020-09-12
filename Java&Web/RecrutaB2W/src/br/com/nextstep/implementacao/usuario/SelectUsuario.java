package br.com.nextstep.implementacao.usuario;

import br.com.nextstep.dao.UsuarioDAO;
import br.com.nextstep.util.Resume;

public class SelectUsuario {
	
	public static void retornarDados(UsuarioDAO dao) throws Exception{
		
		String cpf = Resume.s("Digite o CPF do Usuário: ");
		System.out.println(dao.mostrar(cpf));
		
		dao.fecharConexao();
	}

}
