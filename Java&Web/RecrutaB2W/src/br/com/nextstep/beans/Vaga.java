package br.com.nextstep.beans;

public class Vaga {
	
	private String nomeVaga;
	private String descVaga;
	private double salario;

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
		this.nomeVaga = nomeVaga;
		this.descVaga = descVaga;
		this.salario = salario;
	}

	
	@Override
	public String toString() {
		return "Vaga [nomeVaga=" + nomeVaga + ", descVaga=" + descVaga + ", salario=" + salario + "]";
	}
		
}
