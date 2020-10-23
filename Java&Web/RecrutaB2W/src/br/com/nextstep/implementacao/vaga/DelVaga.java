package br.com.nextstep.implementacao.vaga;

import br.com.nextstep.dao.VagaDAO;
import br.com.nextstep.util.Resume;

public class DelVaga {

	public static void deletar(VagaDAO dao) throws Exception{

			int apaga = Resume.i("Digite o ID da vaga que deseja apagar: ");
			
			if(dao.deleteById(apaga) == 0) {
				System.out.println("Não Apagou");
			}else {
				System.out.println("Apagou");
			}
			dao.fechar();

	}
}
