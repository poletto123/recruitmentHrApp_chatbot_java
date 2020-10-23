package br.com.nextstep.implementacao.usuario;

import br.com.nextstep.dao.UsuarioDAO;
import br.com.nextstep.util.Resume;

public class UpdateUsuario {
	
	public static void atualizar(UsuarioDAO dao) throws Exception{
		
		String email = Resume.s("Digite o novo Email do Usuário: ").toUpperCase();

		String cpf = Resume.s("Digite o CPF do Usuário que deseja alterar as informações: ");
		
		if(dao.modifyEmail(email, cpf) == 0) {
			System.out.println("Não Gravou");
		}else {
			System.out.println("Gravado");
		}
		
		dao.fechar();
	}

}
