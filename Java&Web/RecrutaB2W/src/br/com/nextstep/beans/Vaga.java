package br.com.nextstep.beans;

public class Vaga {
	
	private int numeroVaga;
	private String nomeVaga;
	private String descVaga;
	private double salario;
	
	public int getNumeroVaga() {
		return numeroVaga;
	}
	public void setNumeroVaga(int numeroVaga) {
		this.numeroVaga = numeroVaga;
	}
	public String getNomeVaga() {
		return nomeVaga;
	}
	public void setNomeVaga(String nomeVaga) {
		this.nomeVaga = nomeVaga;
	}
	public String getDescVaga() {
		return descVaga;
	}
	public void setDescVaga(String descVaga) {
		this.descVaga = descVaga;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	
	//CONSTRUTORES
	public Vaga() {
		super();
	}
	public Vaga(int numeroVaga, String nomeVaga, String descVaga, double salario) {
		super();
		this.numeroVaga = numeroVaga;
		this.nomeVaga = nomeVaga;
		this.descVaga = descVaga;
		this.salario = salario;
	}
	@Override
	public String toString() {
		return "Vaga [numeroVaga=" + numeroVaga + ", nomeVaga=" + nomeVaga + ", descVaga=" + descVaga + ", salario="
				+ salario + "]";
	}

	
	
	
}
