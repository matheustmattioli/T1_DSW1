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
        String sql = "INSERT INTO Proposta(id, idUsuario, idPacote, dataProposta, valor) VALUES (?, ?, ?, ?, ?)";
        
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);;

            statement = conn.prepareStatement(sql);
            statement.setLong(1, proposta.getId());
            statement.setLong(2, proposta.getIdUsuario());
            statement.setLong(3, proposta.getIdPacote());
            statement.setDate(4, (java.sql.Date) proposta.getDataProposta());
            statement.setFloat(5, proposta.getValor());
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
                Long idUsuario = resultSet.getLong("idUsuario");
                Long idPacote = resultSet.getLong("idPacote");
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
        // GET BY USUARIO
        // LISTAR POR USUARIO TB
        // Pegar por pacote
        // Listar por pacote tb
    }

}
