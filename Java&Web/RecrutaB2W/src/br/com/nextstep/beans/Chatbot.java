package br.com.nextstep.beans;

import java.io.Serializable;
import java.util.ArrayList;

public class Chatbot implements Serializable {

	private static final long serialVersionUID = 1L;
	private int conversaId;
    private ArrayList<String> respostas = new ArrayList<String>();
    private String resposta;
    

    public int getConversaId() {return conversaId;}
    public void setConversaId(int conversaId) {this.conversaId = conversaId;}
	public ArrayList<String> getRespostas() {return respostas;}
	public void setRespostas(ArrayList<String> resposta) {this.respostas = resposta;}
	public void addRespostas(String resposta) {respostas.add(resposta);}
	public String getresposta() {return resposta;}
	public void setresposta(String resposta) {this.resposta = resposta;}
    
	//CONSTRUTORES
	public Chatbot() {}
	public Chatbot(int conversaId) {this.conversaId = conversaId;}
	
	
	@Override
	public String toString() {
		return "Chatbot [conversaId=" + conversaId + ", respostas=" + respostas + ", resposta" + resposta + "]";
	}
	
}
	

	
