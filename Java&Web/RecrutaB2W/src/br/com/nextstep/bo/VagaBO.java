package br.com.nextstep.bo;

import br.com.nextstep.beans.Vaga;
import br.com.nextstep.dao.VagaDAO;

public class VagaBO {

	public static String novaVaga(Vaga vaga) throws Exception{

		if(vaga.getNomeVaga() == null) {
			return "Nome da vaga não foi preenchido";
		}
		
		VagaDAO dao = new VagaDAO();

		dao.add(vaga);
		dao.fechar();
		return "Cadastrado";
	}

	public static Vaga pesquisarVaga(int id) throws Exception{
		if(id < 1) {
			//throw new RuntimeException("ID inv�lido");
			return new Vaga();
		}
		
		VagaDAO dao = new VagaDAO();
		Vaga resposta = dao.getById(id);
		
		dao.fechar();
		
		return resposta;
	}
	
	public static String atualizarVaga(int id, String novaDescricao)throws Exception{
		if(id < 1) {
			return "ID inválido";
		}
		
		if(novaDescricao == null) {
			return "Descrição inexistente";
		}
		
		VagaDAO dao = new VagaDAO();

		dao.modifyDesc(novaDescricao, id);
		dao.fechar();
		
		return "Conversa de chatbot atualizada";
	}
	
	
	public static String apagarVaga(int id) throws Exception{
		if(id < 1) {
			return "ID inválido";
		}
		
		VagaDAO dao = new VagaDAO();

		dao.deleteById(id);
		dao.fechar();
		
		return "Apagou";
	}
	
}
