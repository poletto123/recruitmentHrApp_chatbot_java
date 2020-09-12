package br.com.nextstep.implementacao.vaga;

import br.com.nextstep.excecao.*;
import br.com.nextstep.dao.VagaDAO;
import br.com.nextstep.util.Resume;

public class TesteSelectVaga {
	
	public static void main(String[] args) {
		try{
			VagaDAO dao = new VagaDAO();
			
			int id = Resume.i("Digite o id da vaga: ");
			System.out.println(dao.mostrar(id));
			
			dao.fecharConexao();
		}catch(Exception e) {
			Excecao.tratarExcecao(e);
		}
		
	}

}
