package br.com.nextstep.implementacao.vaga;

import javax.swing.JOptionPane;
import br.com.nextstep.excecao.*;
import br.com.nextstep.dao.VagaDAO;
import br.com.nextstep.beans.Vaga;
import br.com.nextstep.util.Resume;

public class TesteAddVaga {
	
	public static void main(String[] args) {
		try {
			VagaDAO dao = new VagaDAO();
			Vaga vaga = new Vaga();
			
			vaga.setNumeroVaga(Resume.i("ID da Vaga: "));
			vaga.setNomeVaga(Resume.s("Nome da Vaga: "));
			vaga.setDescVaga(Resume.s("Descrição da Vaga: "));
			vaga.setSalario(Resume.d("Salário: "));
			
			if(dao.add(vaga) == 0) {
				System.out.println("Não Gravou");
			}else {
				System.out.println("Gravado");
			}
			
			dao.fecharConexao();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}
	}
}
