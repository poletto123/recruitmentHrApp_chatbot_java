package br.com.nextstep.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.nextstep.beans.Vaga;
import br.com.nextstep.conexao.ConectaBanco;

public class VagaDAO {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public VagaDAO() throws Exception{

		con =  ConectaBanco.conectar();
	}
	
	public void fecharConexao() throws Exception{

		con.close();
	}
	
	public int add(Vaga objeto) throws Exception{

		con = ConectaBanco.conectar();

		stmt = con.prepareStatement("INSERT INTO T_RBW_VAGA (NR_VAGA, NM_VAGA, DS_VAGA, VL_SALARIO) VALUES (?, ?, ?, ?)");

		stmt.setInt(1, objeto.getNumeroVaga());
		stmt.setString(2, objeto.getNomeVaga());
		stmt.setString(3, objeto.getDescVaga());
		stmt.setDouble(4, objeto.getSalario());

		return stmt.executeUpdate();
	}
	
	public int delete(int id) throws Exception{
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
	
	public Vaga mostrar(int id) throws Exception{
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
	
}
