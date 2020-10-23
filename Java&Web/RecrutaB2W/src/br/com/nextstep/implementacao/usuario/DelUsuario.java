package br.com.nextstep.implementacao.usuario;

import br.com.nextstep.dao.UsuarioDAO;
import br.com.nextstep.util.Resume;

public class DelUsuario {
	
	public static void deletar(UsuarioDAO dao) throws Exception{
		
		String apaga = Resume.s("Digite o CPF do Usuário que deseja apagar: ");
		
		if(dao.delete(apaga) == 0) { // AQUI DEVEMOS FAZER UM MÉTODO DE DELETE NO DAO QUE TENHA COMO PARÂMETRO UMA STRING
			System.out.println("Não Apagou");
		}else {
			System.out.println("Apagou");
		}
		dao.fechar();
	}

}
