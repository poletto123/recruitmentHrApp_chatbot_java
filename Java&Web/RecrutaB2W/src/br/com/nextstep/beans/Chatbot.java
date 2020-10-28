package br.com.nextstep.beans;

import java.io.Serializable;
import java.util.ArrayList;

public class Chatbot implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
    private ArrayList<String> respostas = new ArrayList<String>();

	public ArrayList<String> getRespostas() {return respostas;}
	public void setRespostas(ArrayList<String> resposta) {this.respostas = resposta;}
	public void addRespostas(String resposta) {respostas.add(resposta);}
    
	//CONSTRUTORES
	public Chatbot() {}
	
	public Chatbot(int id, ArrayList<String> respostas) {
		super();
		this.id = id;
		this.respostas = respostas;
	}
	
	@Override
	public String toString() {
		return "Chatbot [id=" + id + ", respostas=" + respostas + "]";
	}
	
}	
