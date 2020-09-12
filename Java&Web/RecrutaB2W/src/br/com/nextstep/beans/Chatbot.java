package br.com.nextstep.beans;

import java.io.Serializable;
import java.util.ArrayList;

public class Chatbot implements Serializable {

    private int conversaId;
    private ArrayList<String> respostas = new ArrayList<String>();
    

    public int getConversaId() {return conversaId;}
    public void setConversaId(int conversaId) {this.conversaId = conversaId;}
	public ArrayList<String> getRespostas() {return respostas;}
	public void setRespostas(ArrayList<String> resposta) {this.respostas = resposta;}
	public void addRespostas(String resposta) {respostas.add(resposta);}
    
	//CONSTRUTORES
	public Chatbot() {}
	
	@Override
	public String toString() {
		return "Chatbot [conversaId=" + conversaId + ", respostas=" + respostas + "]";
	}
	public Chatbot(int conversaId) {this.conversaId = conversaId;}
	
}
	

	
