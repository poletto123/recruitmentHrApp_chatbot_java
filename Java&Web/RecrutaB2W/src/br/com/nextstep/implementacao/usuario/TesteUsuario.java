package br.com.nextstep.implementacao.usuario;

import javax.swing.JOptionPane;

import br.com.nextstep.beans.Usuario;
import br.com.nextstep.dao.UsuarioDAO;
import br.com.nextstep.excecao.Excecao;

public class TesteUsuario {

	public static void main(String[] args) {
		String opcao[] = {"Sair", "INSERT", "DELETE", "SELECT", "UPDATE"};
		
		Integer escolha = JOptionPane.showOptionDialog(null, "Selecione: ", "USUARIO", 0, 
				JOptionPane.QUESTION_MESSAGE, null, opcao, opcao[0]);
		
		try {
			UsuarioDAO dao = new UsuarioDAO();
			Usuario usuario = new Usuario();
			
			if(escolha == 1) {
				AddUsuario.cadastrar(dao, usuario);
			}else if(escolha == 2) {
				DelUsuario.deletar(dao);
			}else if(escolha == 3) {
				SelectUsuario.retornarDados(dao);
			}else if(escolha == 4) {
				UpdateUsuario.atualizar(dao);
			}
			
			
		}catch(Exception e) {
			Excecao.tratarExcecao(e);
		}
	}

}
