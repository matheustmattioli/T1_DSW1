package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.domain.Proposta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class PropostaDAO extends GenericDAO{

    public void insert(Proposta proposta) {
        String sql = "INSERT INTO Proposta(idUsuario, idPacote, dataProposta, valor) VALUES (?, ?, ?, ?)";
        
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);;

            statement = conn.prepareStatement(sql);
            statement.setLong(1, proposta.getIdUsuario());
            statement.setLong(2, proposta.getIdPacote());
            statement.setDate(3, (java.sql.Date) proposta.getDataProposta());
            statement.setFloat(4, proposta.getValor());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Proposta proposta) {
        String sql = "UPDATE Proposta SET idUsuario = ?, idPacote = ?, dataProposta = ?, valor = ? WHERE id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, proposta.getIdUsuario());
            statement.setLong(2, proposta.getIdPacote());
            statement.setDate(3, (java.sql.Date) proposta.getDataProposta());
            statement.setFloat(4, proposta.getValor());
            statement.setLong(5, proposta.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Proposta> getAll() {

        List<Proposta> listaPropostas = new ArrayList<>();

        String sql = "SELECT * from Proposta u";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                long idUsuario = resultSet.getLong("idUsuario");
                long idPacote = resultSet.getLong("idPacote");
                Date dataProposta = resultSet.getDate("dataProposta");
                Float valor = resultSet.getFloat("valor");

                
                Proposta proposta = new Proposta(id, idUsuario, idPacote, dataProposta, valor);
                listaPropostas.add(proposta);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPropostas;
    }

    public void delete(Proposta proposta) {
        String sql = "DELETE FROM Proposta where id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, proposta.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
        }
    }

    public Proposta getbyID(Long id) {
        Proposta proposta = null;

        String sql = "SELECT * from Proposta WHERE id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                long idUsuario = resultSet.getLong("idUsuario");
                long idPacote = resultSet.getLong("idPacote");
                Date dataProposta = resultSet.getDate("dataProposta");
                Float valor = resultSet.getFloat("valor");

                proposta = new Proposta(id, idUsuario, idPacote, dataProposta, valor);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return proposta;
    }
        
    
    public Proposta getbyIDUsuario(Long idUsuario) {
		Proposta proposta = null;

		String sql = "SELECT * from Proposta WHERE id = ?";

		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setLong(1, idUsuario);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				long id = resultSet.getLong("id");
                long idPacote = resultSet.getLong("idPacote");
                Date dataProposta = resultSet.getDate("dataProposta");
                Float valor = resultSet.getFloat("valor");
                proposta = new Proposta(id, idUsuario, idPacote, dataProposta, valor);
			}

			resultSet.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return proposta;
	}

    // LISTAR PROPOSTAS USUARIO
    public List<Proposta> getAllbyIDUsuario(Long idUsuario) {

        List<Proposta> listaPropostasUsuario = new ArrayList<>();

        String sql = "SELECT * from Proposta u";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Long idUsuario_db = resultSet.getLong("idUsuario");
                if (idUsuario == idUsuario_db) {
                    long id = resultSet.getLong("id");
                    long idPacote = resultSet.getLong("idPacote");
                    Date dataProposta = resultSet.getDate("dataProposta");
                    Float valor = resultSet.getFloat("valor");
                    
                    Proposta proposta = new Proposta(id, idUsuario_db, idPacote, dataProposta, valor);
                    listaPropostasUsuario.add(proposta);
                }
                
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPropostasUsuario;
    }


    public Proposta getbyIDPacote(Long idPacote) {
		Proposta proposta = null;

		String sql = "SELECT * from Proposta WHERE id = ?";

		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setLong(1, idPacote);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				Long id = resultSet.getLong("id");
                Long idUsuario = resultSet.getLong("idUsuario");
                Date dataProposta = resultSet.getDate("dataPartida");
                Float valor = resultSet.getFloat("valor");
                proposta = new Proposta(id, idUsuario, idPacote, dataProposta, valor);
			}

			resultSet.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return proposta;
	}
    
    // LISTAR PROPOSTAS DO PACOTE
    public List<Proposta> getAllbyIDPacote(Long idPacote) {

        List<Proposta> listaPropostasPacotes = new ArrayList<>();

        String sql = "SELECT * from Proposta u";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Long idPacote_db = resultSet.getLong("idPacote");
                if (idPacote == idPacote_db) {
                    Long id = resultSet.getLong("id");
                    Long idUsuario = resultSet.getLong("idUsuario");
                    Date dataProposta = resultSet.getDate("dataPartida");
                    Float valor = resultSet.getFloat("valor");
                    Proposta proposta = new Proposta(id, idUsuario, idPacote_db, dataProposta, valor);
                    listaPropostasPacotes.add(proposta);
                }
                
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPropostasPacotes;
    }

}
