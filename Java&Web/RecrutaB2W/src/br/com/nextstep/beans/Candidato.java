package br.com.nextstep.beans;

public class Candidato extends Usuario {
    
	private String dataNascimento;
    private String vaga; 
    private int pontuacao;
     
	public Candidato(int id, String nome, String email, String senha,
				String cpf, String dataNascimento, int pontuacao, String vaga) {
		super(id, nome, email, senha, cpf);
		this.dataNascimento = dataNascimento;
		this.pontuacao = pontuacao;
		this.vaga = vaga;
	}
	
	public Candidato() {}

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

	@Override
	public String toString() {
		return "Candidato [dataNascimento=" + dataNascimento + ", vaga=" + vaga + ", pontuacao=" + pontuacao
				+ ", getId()=" + getId() + ", getNome()=" + getNome() + ", getEmail()=" + getEmail() + ", getSenha()="
				+ getSenha() + ", getCpf()=" + getCpf() + "]";
	}
		
}
