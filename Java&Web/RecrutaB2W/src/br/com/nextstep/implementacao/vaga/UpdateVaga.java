package br.com.nextstep.implementacao.vaga;

import br.com.nextstep.dao.VagaDAO;
import br.com.nextstep.util.Resume;

public class UpdateVaga {
	public static void atualizar(VagaDAO dao) throws Exception{
			String desc = Resume.s("Digite a nova descrição da vaga: ").toUpperCase();
			int numero = Resume.i("Digite o id da vaga a ser modificada: ");
			
			if(dao.modifyDesc(desc, numero) == 0) {
				System.out.println("Não Gravou");
			}else {
				System.out.println("Gravado");
			}
			
			dao.fechar();
	}
}
