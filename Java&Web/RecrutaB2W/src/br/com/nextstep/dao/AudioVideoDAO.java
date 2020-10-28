package br.com.nextstep.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import br.com.nextstep.beans.AudioVideo;
import br.com.nextstep.conexao.ConectaBanco;
import br.com.nextstep.util.PadraoDAO;

public class AudioVideoDAO implements PadraoDAO<AudioVideo> {
	
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	
	public AudioVideoDAO() throws Exception {
		super();
		
		con =  ConectaBanco.conectar();
	}
	
	@Override
	public void fechar() throws Exception{
		con.close();
	}
	
	@Override
	public int add(AudioVideo objeto) throws Exception{
		
		con = ConectaBanco.conectar();
		
		stmt = con.prepareStatement("INSERT INTO T_RBW_AUDIO_VIDEO (FL_VIDEO, FL_AUDIO, ) VALUES (?, ?)");
		
		FileInputStream video = new FileInputStream(objeto.getPathVideo());
		FileInputStream audio = new FileInputStream(objeto.getPathAudio());
		
		stmt.setBinaryStream(1, video);
		stmt.setBinaryStream(2, audio);
		
		return stmt.executeUpdate();
	}
	
	@Override
	public int deleteById(int id) throws Exception{
		Connection con = ConectaBanco.conectar();
		
		PreparedStatement stmt = con.prepareStatement("DELETE FROM T_RBW_AUDIO_VIDEO WHERE CD_ENVIO=?");
		stmt.setInt(1, id);
		
		return stmt.executeUpdate();
		
	}
	
	public int modifyVideo(int id,AudioVideo objeto) throws Exception {
		stmt = con.prepareStatement("UPDATE T_RBW_AUDIO_VIDEO SET FL_VIDEO=? WHERE CD_ENVIO=?");
		
		FileInputStream video = new FileInputStream(objeto.getPathVideo());
		
		stmt.setBinaryStream(1, video);
		stmt.setInt(2, id);
		
		return stmt.executeUpdate();
	}
	
	public int modifyAudio(int id,AudioVideo objeto) throws Exception {
		stmt = con.prepareStatement("UPDATE T_RBW_AUDIO_VIDEO SET FL_AUDIO=? WHERE CD_ENVIO=?");
		
		FileInputStream audio = new FileInputStream(objeto.getPathAudio());
		
		stmt.setBinaryStream(1, audio);
		stmt.setInt(2, id);
		
		return stmt.executeUpdate();
	}
	
	@Override
	public AudioVideo getById(int id) throws Exception{
		stmt = con.prepareStatement("SELECT * FROM T_RBW_AUDIO_VIDEO WHERE CD_ENVIO=?");
		stmt.setInt(1, id);
		
		rs = stmt.executeQuery();
		
		if(rs.next()) {
			
			return new AudioVideo(
					
					rs.getString("FL_AUDIO"),
					rs.getString("FL_VIDEO")
					
					);
		}
		
		return new AudioVideo();
	}

	@Override
	public List<AudioVideo> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
