package br.com.nextstep.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import br.com.nextstep.beans.Vaga;
import br.com.nextstep.conexao.ConectaBanco;
import br.com.nextstep.util.PadraoDAO;

public class VagaDAO implements PadraoDAO<Vaga> {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public VagaDAO() throws Exception{

		con =  ConectaBanco.conectar();
	}
	
	@Override
	public void fechar() throws Exception{
		con.close();
	}
	
	@Override
	public int add(Vaga objeto) throws Exception{

		con = ConectaBanco.conectar();

		stmt = con.prepareStatement("INSERT INTO T_RBW_VAGA (NM_VAGA, DS_VAGA, VL_SALARIO) VALUES (?, ?, ?)");
		stmt.setString(1, objeto.getNomeVaga());
		stmt.setString(2, objeto.getDescVaga());
		stmt.setDouble(3, objeto.getSalario());

		return stmt.executeUpdate();
	}
	
	@Override
	public int deleteById(int id) throws Exception{
		Connection con = ConectaBanco.conectar();
		
		PreparedStatement stmt = con.prepareStatement("DELETE FROM T_RBW_VAGA WHERE NR_VAGA=?");
		stmt.setInt(1, id);
		
		return stmt.executeUpdate();
		
	}
	
	public int modifyDesc(String desc, int numero) throws Exception {
		stmt = con.prepareStatement("UPDATE T_RBW_VAGA SET DS_VAGA=? WHERE NR_VAGA=?");
		stmt.setString(1, desc);
		stmt.setInt(2, numero);
		
		return stmt.executeUpdate();
	}
	
	@Override
	public Vaga getById(int id) throws Exception{
		stmt = con.prepareStatement("SELECT * FROM T_RBW_VAGA WHERE NR_VAGA=?");
		stmt.setInt(1, id);
		
		rs = stmt.executeQuery();
		
		if(rs.next()) {
			
			return new Vaga(
					
					rs.getInt("NR_VAGA"),
					rs.getString("NM_VAGA"),
					rs.getString("DS_VAGA"),
					rs.getDouble("VL_SALARIO")
					
					);
		}
		
		return new Vaga();
	}

	@Override
	public List<Vaga> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
