package br.com.nextstep.beans;

import java.io.Serializable;

public class AudioVideo  implements Serializable{

	private static final long serialVersionUID = 1L;
    private byte videoFl;
    private byte audioFl;
    
    public byte getVideoFl() {return videoFl;}
    public void setVideoFl(byte videoFl) {this.videoFl = videoFl;}
    public byte getAudioFl() {return audioFl;}
    public void setAudioFl(byte audioFl) {this.audioFl = audioFl;}

	//CONSTRUTORES
    public AudioVideo(){}
    public AudioVideo(int envioId, byte videoFl, byte audioFl){
       this.videoFl = videoFl;
       this.audioFl = audioFl;
    }
	
    @Override
	public String toString() {
		return "AudioVideo [videoFl=" + videoFl + ", audioFl=" + audioFl + "]";
	}
 
}
