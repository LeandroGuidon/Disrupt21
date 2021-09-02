package br.com.fiap.disrupt21.dao;

import java.sql.*;
import java.util.ArrayList;

import br.com.fiap.disrupt21.factory.ConnectionFactory;
import br.com.fiap.disrupt21.model.PersonagemBean;

public class PersonagemDAO {
	
	public boolean Inserir (PersonagemBean p1) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		boolean status = false;
		
		try {
			con = new ConnectionFactory().getConnection();
			sql = "INSERT INTO T_DVF_PERSONAGEM (CD_TIPO, NM_PERSONAGEM, NR_ANO, DS_MISSAO) VALUES (?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, p1.getTipo());
			ps.setString(2, p1.getNome());
			ps.setInt(3, p1.getAno());
			ps.setString(4, p1.getMissao());
			
			ps.execute();
			
			System.out.println("Insert executado com sucesso");

			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return status;
	}
	
	public boolean Remover(PersonagemBean p1) {
		
		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		boolean status = false;
		
		try {
			con = new ConnectionFactory().getConnection();
			sql = "DELETE FROM T_DVF_PERSONAGEM WHERE NM_PERSONAGEM = ? AND NR_ANO = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, p1.getNome());
			ps.setInt(2, p1.getAno());
			
			
			status = ps.execute();
			
			System.out.println("Remoção executada com sucesso");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return status;
	}
	
	public boolean Editar (PersonagemBean p1) {
		
		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		boolean status = false;
		
		try {
			
			con = new ConnectionFactory().getConnection();
			sql = "UPDATE FROM T_DVF_PERSONAGEM CD_TIPO = ?, NM_PERSONAGEM = ?, NR_ANO = ?, DS_MISSAO = ?  WHERE NM_PERSONAGEM = ? AND NR_ANO = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, p1.getTipo());
			ps.setString(2, p1.getNome());
			ps.setInt(3, p1.getAno());
			ps.setString(4, p1.getMissao());
			ps.setString(5, p1.getNome());
			ps.setInt(6, p1.getAno());
			
			status = ps.execute();
			
			System.out.println("Edição executada com sucesso");
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return status;
	}
	
	public ArrayList<PersonagemBean> buscaPersonagens(){
		Connection con = null;
		PreparedStatement ps = null;
		ArrayList<PersonagemBean> Lista = new ArrayList<PersonagemBean>();
		String sql = null;
		
		try {
			con = new ConnectionFactory().getConnection();
			sql = "SELECT * FROM T_DVF_PERSONAGEM ORDER BY NM_ANO";
			ps = con.prepareStatement(sql);
			ps.execute();
			
			ResultSet rs = ps.getResultSet();
			
			while (rs.next()){
				PersonagemBean p1 = new PersonagemBean();
				p1.setTipo(rs.getInt("CD_TIPO"));
				p1.setNome(rs.getString("NM_PERSONAGEM"));
				p1.setAno(rs.getInt("NM_ANO"));
				p1.setMissao(rs.getString("DS_MISSAO"));
				Lista.add(p1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return Lista;
	}
	
	public PersonagemBean Selecionar (String nome, int ano) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		ResultSet rs = null;
		PersonagemBean p1 = null;
		
		try {
			con = new ConnectionFactory().getConnection();
			sql = "SELECT * FROM T_DVF_PERSONAGEM WHERE NM_PERSONAGEM = ? AND NR_ANO = ?";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, nome);
			ps.setInt(2, ano);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				p1 = new PersonagemBean();
				p1.setNome(rs.getString("NM_PERSONAGEM"));
				p1.setAno(rs.getInt("NM_ANO"));
				p1.setTipo(rs.getInt("CD_TIPO"));
				p1.setMissao(rs.getString("DS_MISSAO"));
			}
			
			
					
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
				ps.close();
				rs.close();
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return p1;
	}	
}
