package br.com.nextstep.beans;

import java.io.Serializable;

public class Candidato implements Serializable{

	private static final long serialVersionUID = 1L;
    
	private int id;
	private String nome;
    private String email;
    private String senha;
	private String dataNascimento;
    private Vaga vaga; 
    private int numeroMedalha;
    private String cpf;
    private int codigoRecrutador;
	
	//CONSTRUTORES	
	public Candidato(int id, String dataNascimento, Vaga vaga, int numeroMedalha, String nome, String email, String senha, String cpf, int codigoRecrutador) {
		super();
		this.id = id;
		this.dataNascimento = dataNascimento;
		this.vaga = vaga;
		this.numeroMedalha = numeroMedalha;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.cpf = cpf;
		this.codigoRecrutador = codigoRecrutador;
	}

	public Candidato() {
		super();
	}

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

	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
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

	public int getNumeroMedalha() {
		return numeroMedalha;
	}

	public void setNumeroMedalha(int numeroMedalha) {
		this.numeroMedalha = numeroMedalha;
	}

	public int getCodigoRecrutador() {
		return codigoRecrutador;
	}

	public void setCodigoRecrutador(int codigoRecrutador) {
		this.codigoRecrutador = codigoRecrutador;
	}

	@Override
	public String toString() {
		return "Candidato [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", dataNascimento="
				+ dataNascimento + ", vaga=" + vaga + ", numeroMedalha=" + numeroMedalha + ", cpf=" + cpf
				+ ", codigoRecrutador=" + codigoRecrutador + "]";
	}

		
}
