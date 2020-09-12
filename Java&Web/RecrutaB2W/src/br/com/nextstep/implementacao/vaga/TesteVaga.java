package br.com.nextstep.implementacao.vaga;

import javax.swing.JOptionPane;

import br.com.nextstep.beans.Vaga;
import br.com.nextstep.dao.VagaDAO;
import br.com.nextstep.excecao.Excecao;
import br.com.nextstep.util.Resume;

public class TesteVaga {
	
	public static void main(String[] args){
		
		String opcao[] = {"Sair", "INSERT", "DELETE", "SELECT", "UPDATE"};
		
		Integer escolha = JOptionPane.showOptionDialog(null, "Selecione: ", "VAGA", 0, 
				JOptionPane.QUESTION_MESSAGE, null, opcao, opcao[0]);
		
		try {
			VagaDAO dao = new VagaDAO();
			Vaga vaga = new Vaga();
			
			if(escolha == 1) {
				AddVaga.cadastrar(dao, vaga);
			}else if(escolha == 2) {
				DelVaga.deletar(dao);
			}else if(escolha == 3) {
				SelectVaga.retornarDados(dao);
			}else if(escolha == 4) {
				UpdateVaga.atualizar(dao);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		
		}
	}
}
