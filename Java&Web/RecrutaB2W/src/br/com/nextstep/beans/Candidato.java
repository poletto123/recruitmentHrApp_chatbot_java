package br.com.nextstep.beans;

import java.util.Date;

public class Candidato extends Usuario{
    
	private String dataNascimento;
    private String vaga; 
    private int pontuacao;

	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getVaga() {
		return vaga;
	}
	public void setVaga(String vaga) {
		this.vaga = vaga;
	}
	public int getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	
	//CONTRUTORES
	public Candidato() {
		super();

	}
	public Candidato(String nome, String email, String senha, String cpf) {
		super(nome, email, senha, cpf);

	}
	public Candidato(String dataNascimento, String vaga, int pontuacao) {
		super();
		this.dataNascimento = dataNascimento;
		this.vaga = vaga;
		this.pontuacao = pontuacao;
	}
	
	@Override
	public String toString() {
		return "Candidato [dataNascimento=" + dataNascimento + ", vaga=" + vaga + ", pontuacao=" + pontuacao + "]";
	} 
	
}
