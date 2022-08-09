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
        String sql = "INSERT INTO Proposta(idUsuario, idPacote, dataProposta, valor, statusProposta) VALUES (?, ?, ?, ?, ?)";
        
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);;

            statement = conn.prepareStatement(sql);
            statement.setLong(1, proposta.getIdUsuario());
            statement.setLong(2, proposta.getIdPacote());
            statement.setDate(3, (java.sql.Date) proposta.getDataProposta());
            statement.setFloat(4, proposta.getValor());
            statement.setInt(5, proposta.getStatusProposta());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Proposta proposta) {
        String sql = "UPDATE Proposta SET idUsuario = ?, idPacote = ?, dataProposta = ?, valor = ?, statusProposta = ? WHERE id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, proposta.getIdUsuario());
            statement.setLong(2, proposta.getIdPacote());
            statement.setDate(3, (java.sql.Date) proposta.getDataProposta());
            statement.setFloat(4, proposta.getValor());
            statement.setInt(5, proposta.getStatusProposta());
            statement.setLong(6, proposta.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateStatus(Proposta proposta, int statusProposta) {
        String sql = "UPDATE Proposta SET statusProposta = ? WHERE id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1, statusProposta);
            statement.setLong(2, proposta.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Proposta> getAll() {

        List<Proposta> listaPropostas = new ArrayList<>();

        String sql = "SELECT * from Proposta";

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
                int statusProposta = resultSet.getInt("statusProposta");
                
                Proposta proposta = new Proposta(id, idUsuario, idPacote, dataProposta, valor, statusProposta);
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
                int statusProposta = resultSet.getInt("statusProposta");

                proposta = new Proposta(id, idUsuario, idPacote, dataProposta, valor, statusProposta);
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
    public List<Proposta> getAllActivebyIDUsuario(Long idUsuario) {

        List<Proposta> listaPropostasUsuario = new ArrayList<>();

        String sql = "SELECT * from Proposta u";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Long idUsuario_db = resultSet.getLong("idUsuario");
                if (idUsuario == idUsuario_db && resultSet.getInt("statusProposta") == 1) {
                    long id = resultSet.getLong("id");
                    long idPacote = resultSet.getLong("idPacote");
                    Date dataProposta = resultSet.getDate("dataProposta");
                    Float valor = resultSet.getFloat("valor");
                    int statusProposta = resultSet.getInt("statusProposta");

                    Proposta proposta = new Proposta(id, idUsuario_db, idPacote, dataProposta, valor, statusProposta);
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

    public List<Proposta> getAllCancelledbyIDUsuario(Long idUsuario) {

        List<Proposta> listaPropostasUsuario = new ArrayList<>();

        String sql = "SELECT * from Proposta u";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Long idUsuario_db = resultSet.getLong("idUsuario");
                if (idUsuario == idUsuario_db && resultSet.getInt("statusProposta") == 0) {
                    long id = resultSet.getLong("id");
                    long idPacote = resultSet.getLong("idPacote");
                    Date dataProposta = resultSet.getDate("dataProposta");
                    Float valor = resultSet.getFloat("valor");
                    int statusProposta = resultSet.getInt("statusProposta");

                    Proposta proposta = new Proposta(id, idUsuario_db, idPacote, dataProposta, valor, statusProposta);
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
                    Date dataProposta = resultSet.getDate("dataProposta");
                    Float valor = resultSet.getFloat("valor");
                    int statusProposta = resultSet.getInt("statusProposta");
                    Proposta proposta = new Proposta(id, idUsuario, idPacote_db, dataProposta, valor, statusProposta);
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
