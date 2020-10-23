package br.com.nextstep.implementacao.usuario;

import br.com.nextstep.beans.Usuario;
import br.com.nextstep.dao.UsuarioDAO;
import br.com.nextstep.util.Resume;

public class AddUsuario {

	public static void cadastrar(UsuarioDAO dao, Usuario usuario) throws Exception{
		
		usuario.setNome(Resume.s("Nome"));
		usuario.setCpf(Resume.s("CPF"));
		usuario.setEmail(Resume.s("Email"));
		usuario.setSenha(Resume.s("Senha"));
		
		if(dao.add(usuario) == 0) {
			System.out.println("Não Gravou");
		}else {
			System.out.println("Gravado");
		}
		
		dao.fechar();
	}
}
