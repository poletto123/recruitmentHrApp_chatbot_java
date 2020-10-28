package br.com.nextstep.beans;

public class Candidato{
    
	private int id;
	private String dataNascimento;
    private String vaga; 
    private int qtdeMedalha;
	private String nome;
    private String email;
    private String senha;
    private String cpf;
	
	public Candidato(int id, String dataNascimento, String vaga, int qtdeMedalha, String nome, String email,
			String senha, String cpf) {
		super();
		this.id = id;
		this.dataNascimento = dataNascimento;
		this.vaga = vaga;
		this.qtdeMedalha = qtdeMedalha;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.cpf = cpf;
	}

	public Candidato() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public int getQtdeMedalha() {
		return qtdeMedalha;
	}

	public void setQtdeMedalha(int qtdeMedalha) {
		this.qtdeMedalha = qtdeMedalha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

		
}
