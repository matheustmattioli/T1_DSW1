package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.Agencia;

public class AgenciaDAO extends GenericDAO {
	
	public void insert(Agencia agencia) {
		String sql = "INSERT INTO Agencia(cnpj, nome, email, senha, descricao) VALUES (?, ?, ?, ?, ?)";

		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);;

			statement = conn.prepareStatement(sql);
			statement.setString(1, agencia.getCNPJ());
			statement.setString(2, agencia.getNome());
			statement.setString(3, agencia.getEmail());
			statement.setString(4, agencia.getSenha());
			statement.setString(5, agencia.getDescricao());
			statement.executeUpdate();

			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Agencia> getAll() {

		List<Agencia> listaAgencias = new ArrayList<>();

		String sql = "SELECT * from Agencia u";

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
				Agencia agencia = new Agencia(id, cnpj ,nome, email, senha, descricao);
				listaAgencias.add(agencia);
			}

			resultSet.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return listaAgencias;
	}

	public void delete(Agencia agencia) {
		String sql = "DELETE FROM Usuario where id = ?";

		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setLong(1, agencia.getId());
			statement.executeUpdate();

			statement.close();
			conn.close();
		} catch (SQLException e) {
		}
	}

	public void update(Agencia agencia) {
		String sql = "UPDATE Agencia SET cnpj = ?, nome = ?, email = ?, senha = ?, descricao = ? WHERE id = ?";

		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, agencia.getCNPJ());
			statement.setString(2, agencia.getNome());
			statement.setString(3, agencia.getEmail());
			statement.setString(4, agencia.getSenha());
			statement.setString(5, agencia.getDescricao());
			statement.setLong(6, agencia.getId());
			statement.executeUpdate();

			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Agencia getbyID(Long id) {
		Agencia agencia = null;

		String sql = "SELECT * from Agencia WHERE id = ?";

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

				agencia = new Agencia(id, cnpj, nome, email, senha, descricao);
			}

			resultSet.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return agencia;
	}
	
	public Agencia getbyEmail(String email) {
		Agencia agencia = null;

		String sql = "SELECT * from Agencia WHERE email = ?";

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

				agencia = new Agencia(id, cnpj, nome, email, senha, descricao);
			}

			resultSet.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return agencia;
	}	
}