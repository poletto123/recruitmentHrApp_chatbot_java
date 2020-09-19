package br.com.nextstep.beans;

import java.io.Serializable;
import java.sql.Blob;

public class AudioVideo  implements Serializable{

	private static final long serialVersionUID = 1L;
    private Blob videoFl;
    private Blob audioFl;
    private String pathAudio;
    private String pathVideo;
    
    public Blob getVideoFl() {return videoFl;}
    public void setVideoFl(Blob videoFl) {this.videoFl = videoFl;}
    public Blob getAudioFl() {return audioFl;}
    public void setAudioFl(Blob audioFl) {this.audioFl = audioFl;}

	//CONSTRUTORES
    public AudioVideo(){}
    public AudioVideo(Blob videoFl, Blob audioFl){
       this.videoFl = videoFl;
       this.audioFl = audioFl;
    }
    	
    public String getPathAudio() {
		return pathAudio;
	}
	public void setPathAudio(String pathAudio) {
		this.pathAudio = pathAudio;
	}
	public String getPathVideo() {
		return pathVideo;
	}
	public void setPathVideo(String pathVideo) {
		this.pathVideo = pathVideo;
	}
	@Override
	public String toString() {
		return "AudioVideo [videoFl=" + videoFl + ", audioFl=" + audioFl + "]";
	}
 
}
