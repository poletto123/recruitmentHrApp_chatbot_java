package br.com.nextstep.implementacao.vaga;

import br.com.nextstep.dao.VagaDAO;
import br.com.nextstep.util.Resume;

public class SelectVaga {
	
	public static void retornarDados(VagaDAO dao) throws Exception{

			int id = Resume.i("Digite o id da vaga: ");
			System.out.println(dao.mostrar(id));
			
			dao.fecharConexao();
		
	}

}
