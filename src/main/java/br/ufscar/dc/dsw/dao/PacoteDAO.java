package br.ufscar.dc.dsw.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.ufscar.dc.dsw.domain.Pacote;

public class PacoteDAO extends GenericDAO {
	
	  public void insert(Pacote pacote) {

	        String sql = "INSERT INTO Pacote(idAgencia, cnpj, cidade, estado, pais, dataPartida, duracaoDias, valor, descricao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

	        try {
	            Connection conn = this.getConnection();
	            PreparedStatement statement = conn.prepareStatement(sql);;

	            statement = conn.prepareStatement(sql);
	            statement.setLong(1, pacote.getIdAgencia());
				statement.setString(2, pacote.getCNPJ());
				statement.setString(3, pacote.getCidade());
				statement.setString(4, pacote.getEstado());
				statement.setString(5, pacote.getPais());
				statement.setDate(6, (java.sql.Date) pacote.getDataPartida());
				statement.setInt(7, pacote.getDuracaoDias());
				statement.setBigDecimal(8, pacote.getValor());
	            statement.setString(9, pacote.getDescricao());
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
	                Long id = resultSet.getLong("id");
					Long idAgencia = resultSet.getLong("idAgencia");
	                String cnpj = resultSet.getString("cnpj");
	                String cidade = resultSet.getString("cidade");
	                String estado = resultSet.getString("estado");
	                String pais = resultSet.getString("pais");

					Date dataPartida = resultSet.getDate("dataPartida");
	                int duracaoDias = resultSet.getInt("duracaoDias");
	                BigDecimal valor = resultSet.getBigDecimal("valor");
					String descricao = resultSet.getString("descricao");
	                Pacote pacote = new Pacote(id, idAgencia, cnpj, cidade, estado, pais, dataPartida, duracaoDias, valor, descricao);
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
	        String sql = "DELETE FROM Pacote where id = ?";

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
	        String sql = "UPDATE Pacote SET idAgencia = ?, cnpj = ?, cidade = ?, estado = ?, pais = ? dataPartida = ?, duracaoDias = ?, descricao = ?, valor = ? WHERE id = ?";

	        try {
	            Connection conn = this.getConnection();
	            PreparedStatement statement = conn.prepareStatement(sql);

				statement.setLong(1, pacote.getIdAgencia());
	            statement.setString(2, pacote.getCNPJ());
	            statement.setString(3, pacote.getCidade());
	            statement.setString(4, pacote.getEstado());
	            statement.setString(5, pacote.getPais());
	            statement.setDate(6, (java.sql.Date) pacote.getDataPartida());
	            statement.setInt(7, pacote.getDuracaoDias());
	            statement.setString(8, pacote.getDescricao());
	            statement.setLong(9, pacote.getId());
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
					Long idAgencia = resultSet.getLong("idAgencia");
					String cnpj = resultSet.getString("cnpj");
					String cidade = resultSet.getString("cidade");
	                String estado = resultSet.getString("estado");
	                String pais = resultSet.getString("pais");
					

					Date dataPartida = resultSet.getDate("dataPartida");
					int duracaoDias = resultSet.getInt("duracaoDias");
					BigDecimal valor = resultSet.getBigDecimal("valor");
					String descricao = resultSet.getString("descricao");

					pacote = new Pacote(id, idAgencia, cnpj, cidade, estado, pais, dataPartida, duracaoDias, valor, descricao);
				}

				resultSet.close();
				statement.close();
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			return pacote;
		}

	// Pegar por idAgencia
	// Listar todas as agencias que tem esse pacote
	
}