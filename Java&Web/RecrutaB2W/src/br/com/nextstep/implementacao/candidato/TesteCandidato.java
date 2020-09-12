package br.com.nextstep.implementacao.candidato;

import javax.swing.JOptionPane;

import br.com.nextstep.beans.Candidato;
import br.com.nextstep.beans.Usuario;
import br.com.nextstep.dao.CandidatoDAO;
import br.com.nextstep.dao.UsuarioDAO;
import br.com.nextstep.excecao.Excecao;

public class TesteCandidato {
	
	public static void main(String[] args) {
		
		String opcao[] = {"Sair", "INSERT", "DELETE", "SELECT", "UPDATE"};
		
		Integer escolha = JOptionPane.showOptionDialog(null, "Selecione: ", "USUARIO", 0, 
				JOptionPane.QUESTION_MESSAGE, null, opcao, opcao[0]);
		
		try {
			
			CandidatoDAO dao = new CandidatoDAO();
			Candidato candidato = new Candidato();
			Usuario usuario = new Usuario();
			UsuarioDAO dao2 = new UsuarioDAO();
			
			if(escolha == 1) {
				AddCandidato.cadastrar(dao, usuario, candidato);
			}else if(escolha == 2) {
				DelCandidato.deletar(dao2, dao);
			}else if (escolha == 3) {
				SelectCandidato.retornarDados(dao);
			}else if (escolha == 4) {
				UpdateCandidato.atualizar(dao2);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			Excecao.tratarExcecao(e);
		}
	}

}
