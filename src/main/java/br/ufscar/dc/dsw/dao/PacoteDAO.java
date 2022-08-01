package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.Pacote;

public class PacoteDAO extends GenericDAO {
	
	  public void insert(Pacote pacote) {

	        String sql = "INSERT INTO Pacote(cnpj, nome, email, senha, descricao) VALUES (?, ?, ?, ?, ?)";

	        try {
	            Connection conn = this.getConnection();
	            PreparedStatement statement = conn.prepareStatement(sql);;

	            statement = conn.prepareStatement(sql);
	            statement.setString(1, pacote.getCNPJ());
	            statement.setString(2, pacote.getNome());
	            statement.setString(3, pacote.getEmail());
	            statement.setString(4, pacote.getSenha());
	            statement.setString(5, pacote.getDescricao());
	            statement.executeUpdate();

	            statement.close();
	            conn.close();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	    }

	    public List<Pacote> getAll() {

	        List<Pacote> listaPacotes = new ArrayList<>();

	        String sql = "SELECT * from Pacote u";

	        try {
	            Connection conn = this.getConnection();
	            Statement statement = conn.createStatement();

	            ResultSet resultSet = statement.executeQuery(sql);
	            while (resultSet.next()) {
	                long id = resultSet.getLong("id");
	                String cnpj = resultSet.getString("cnpj");
	                String nome = resultSet.getString("nome");
	                String email = resultSet.getString("email");
	                String senha = resultSet.getString("senha");
	                String descricao = resultSet.getString("descricao");
	                Pacote pacote = new Pacote(id, cnpj ,nome, email, senha, descricao);
	                listaPacotes.add(pacote);
	            }

	            resultSet.close();
	            statement.close();
	            conn.close();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        return listaPacotes;
	    }

	    public void delete(Pacote pacote) {
	        String sql = "DELETE FROM Usuario where id = ?";

	        try {
	            Connection conn = this.getConnection();
	            PreparedStatement statement = conn.prepareStatement(sql);

	            statement.setLong(1, pacote.getId());
	            statement.executeUpdate();

	            statement.close();
	            conn.close();
	        } catch (SQLException e) {
	        }
	    }

	    public void update(Pacote pacote) {
	        String sql = "UPDATE Pacote SET cnpj = ?, nome = ?, email = ?, senha = ?, descricao = ? WHERE id = ?";

	        try {
	            Connection conn = this.getConnection();
	            PreparedStatement statement = conn.prepareStatement(sql);

	            statement.setString(1, pacote.getCNPJ());
	            statement.setString(2, pacote.getNome());
	            statement.setString(3, pacote.getEmail());
	            statement.setString(4, pacote.getSenha());
	            statement.setString(5, pacote.getDescricao());
	            statement.setLong(6, pacote.getId());
	            statement.executeUpdate();

	            statement.close();
	            conn.close();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	    }

	    public Pacote getbyID(Long id) {
	        Pacote pacote = null;

	        String sql = "SELECT * from Pacote WHERE id = ?";

	        try {
	            Connection conn = this.getConnection();
	            PreparedStatement statement = conn.prepareStatement(sql);

	            statement.setLong(1, id);
	            ResultSet resultSet = statement.executeQuery();
	            if (resultSet.next()) {
	                String cnpj = resultSet.getString("cnpj");
	                String nome = resultSet.getString("nome");
	                String email = resultSet.getString("email");
	                String senha = resultSet.getString("senha");
	                String descricao = resultSet.getString("descricao");

	                pacote = new Pacote(id, cnpj, nome, email, senha, descricao);
	            }

	            resultSet.close();
	            statement.close();
	            conn.close();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        return pacote;
	    }
	    
	    public Pacote getbyEmail(String email) {
	        Pacote pacote = null;

	        String sql = "SELECT * from Pacote WHERE email = ?";

	        try {
	            Connection conn = this.getConnection();
	            PreparedStatement statement = conn.prepareStatement(sql);

	            statement.setString(1, email);
	            ResultSet resultSet = statement.executeQuery();
	            if (resultSet.next()) {
	            	Long id = resultSet.getLong("id");
	            	String cnpj = resultSet.getString("cnpj");
	                String nome = resultSet.getString("nome");
	                String senha = resultSet.getString("senha");
	                String descricao = resultSet.getString("descricao");

	                pacote = new Pacote(id, cnpj, nome, email, senha, descricao);
	            }

	            resultSet.close();
	            statement.close();
	            conn.close();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        return pacote;
	    }	
}