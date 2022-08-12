package br.ufscar.dc.dsw.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

	public List<Pacote> getAllValid() {
		List<Pacote> listaPacotes = this.getAll();
		Date hoje = Date.from(Instant.now());
		listaPacotes = listaPacotes.stream().filter(x -> x.getDataPartida().after(hoje)).collect(Collectors.toList());

		return listaPacotes;
	}

	public List<Pacote> getAll() {

		List<Pacote> listaPacotes = new ArrayList<>();

		String sql = "SELECT * from Pacote";

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

	public void delete(Long id) throws SQLException {
		String sql = "DELETE FROM Pacote where id = ?";

		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setLong(1, id);
			statement.executeUpdate();

			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw e;
		}
	}

	public void update(Pacote pacote) {
		String sql = "UPDATE Pacote SET idAgencia = ?, cnpj = ?, cidade = ?, estado = ?, pais = ?, dataPartida = ?, duracaoDias = ?, valor = ?, descricao = ? WHERE id = ?";

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
			statement.setBigDecimal(8, pacote.getValor());
			statement.setString(9, pacote.getDescricao());
			statement.setLong(10, pacote.getId());
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
				String cnpj = resultSet.getString("CNPJ");
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

	public List<Pacote> getAllbyIDAgencia(Long idAgencia) {

		List<Pacote> listaPacotesAgencia = new ArrayList<>();

		String sql = "SELECT * from Pacote";

		try {
			Connection conn = this.getConnection();
			Statement statement = conn.createStatement();

			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Long idAgencia_db = resultSet.getLong("idAgencia");
				if (idAgencia == idAgencia_db) {
					// System.out.println(idAgencia_db);
					Long id = resultSet.getLong("id");
					String cnpj = resultSet.getString("cnpj");
					String cidade = resultSet.getString("cidade");
					String estado = resultSet.getString("estado");
					String pais = resultSet.getString("pais");

					Date dataPartida = resultSet.getDate("dataPartida");
					int duracaoDias = resultSet.getInt("duracaoDias");
					BigDecimal valor = resultSet.getBigDecimal("valor");
					String descricao = resultSet.getString("descricao");
					Pacote pacote = new Pacote(id, idAgencia_db, cnpj, cidade, estado, pais, dataPartida, duracaoDias, valor, descricao);
					listaPacotesAgencia.add(pacote);
				}
				
			}
			resultSet.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return listaPacotesAgencia;
	}

	public List<Pacote> getAllbyIDAgenciaValid(Long idAgencia) {
		List<Pacote> listaPacotes = this.getAllbyIDAgencia(idAgencia);
		Date hoje = Date.from(Instant.now());
		listaPacotes = listaPacotes.stream().filter(x -> x.getDataPartida().after(hoje)).collect(Collectors.toList());
		return listaPacotes;
	}
	
	public List<Pacote> getAllDestino(String destino) {

		List<Pacote> pacotes = getAll();
		
		pacotes = pacotes.stream().filter(x -> x.getCidade() == destino).filter(x -> x.getEstado() == destino).filter(x -> x.getPais() == destino).collect(Collectors.toList());
		return pacotes;
	}

	public List<Pacote> getAllAgencia(String cnpj) {

		List<Pacote> pacotes = getAll();
		
		pacotes = pacotes.stream().filter(x -> x.getCNPJ() == cnpj).collect(Collectors.toList());
		return pacotes;
	}

	public List<Pacote> getAllData(Date dataPartida) {

		List<Pacote> pacotes = getAll();
		
		pacotes = pacotes.stream().filter(x -> x.getDataPartida() == dataPartida).collect(Collectors.toList());
		return pacotes;
	}

	public List<Pacote> getApplyFilters(String destino, String cnpj, String dataPartida, String validoStr) {
		List<Pacote> pacotes = this.getAll();

		System.out.println("oioioi " + dataPartida);
		Boolean valido = validoStr.equals("on") ? true : false;
		for (Pacote pacote : pacotes)
			System.out.println(pacote.getDataPartida());
		System.out.println("tchautchautchau " + valido);
		Date hoje = Date.from(Instant.now());
		System.out.println(dataPartida);
		if (!dataPartida.isEmpty())
			pacotes = pacotes.stream().filter(x -> x.getDataPartida().toString().equals(dataPartida)).collect(Collectors.toList());
		if (cnpj != "")
			pacotes = pacotes.stream().filter(x -> x.getCNPJ().equals(cnpj)).collect(Collectors.toList());
		if (destino != "")
			pacotes = pacotes.stream().filter(x -> x.getCidade().equals(destino) || x.getEstado().equals(destino) || x.getPais().equals(destino)).collect(Collectors.toList());
		if (valido == true)
			pacotes = pacotes.stream().filter(x -> x.getDataPartida().after(hoje)).collect(Collectors.toList());

		return pacotes;
	}
	
}