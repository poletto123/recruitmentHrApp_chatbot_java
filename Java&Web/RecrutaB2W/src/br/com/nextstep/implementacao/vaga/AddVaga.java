package br.com.nextstep.implementacao.vaga;

import br.com.nextstep.beans.Vaga;
import br.com.nextstep.dao.VagaDAO;
import br.com.nextstep.util.Resume;

public class AddVaga {
	
	public static void cadastrar(VagaDAO dao, Vaga vaga) throws Exception{
			
			vaga.setNomeVaga(Resume.s("Nome da Vaga: "));
			vaga.setDescVaga(Resume.s("Descri��o da Vaga: "));
			vaga.setSalario(Resume.d("Sal�rio: "));
			
			if(dao.add(vaga) == 0) {
				System.out.println("N�o Gravou");
			}else {
				System.out.println("Gravado");
			}
			
			dao.fecharConexao();
	}
}
