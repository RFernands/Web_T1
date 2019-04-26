package dao;

import model.Promocao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PromocaoDAO {

    public PromocaoDAO() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:derby://localhost:1527/cadastro", "root", "root");
    }

    public void insert(Promocao promocao) {
        String sql = "INSERT INTO Promocao (URLdoSite, CNPJdoTeatro, nomePeca, precoPeca, dataPeca, horario) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);;
            statement = conn.prepareStatement(sql);
            statement.setString(1, promocao.getURLdoSite());
            statement.setString(2, promocao.getCNPJdoTeatro());
            statement.setString(3, promocao.getNomePeca());
            statement.setFloat(4, promocao.getPrecoPeca());
            statement.setString(5, promocao.getDataPeca());
            statement.setString(6, promocao.getHorario());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Promocao> getAll() {
        List<Promocao> listaPromocoes = new ArrayList<>();
        String sql = "SELECT * FROM Promocao";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String ULRdoSite = resultSet.getString("URLdoSite");
                String CNPJdoTeatro = resultSet.getString("CNPJdoTeatro");
                String nomePeca = resultSet.getString("nomePeca");
                float precoPeca = resultSet.getFloat("precoPeca");
                String dataPeca = resultSet.getString("dataPeca");
                String horario = resultSet.getString("horario");
                Integer ID = resultSet.getInt("ID");
                Promocao promocao = new Promocao(ID, ULRdoSite, CNPJdoTeatro, nomePeca, precoPeca, dataPeca, horario);
                listaPromocoes.add(promocao);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPromocoes;
    }

    public void delete(Promocao promocao) {
        String sql = "DELETE FROM Promocao where ID = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, promocao.getID());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Promocao promocao) {
        String sql = "UPDATE Promocao SET URLdoSite = ?, CNPJdoTeatro = ?, nomePeca = ?, precoPeca = ?, dataPeca = ?, horario =?";
        sql += " WHERE ID = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, promocao.getURLdoSite());
            statement.setString(2, promocao.getCNPJdoTeatro());
            statement.setString(3, promocao.getNomePeca());
            statement.setFloat(4, promocao.getPrecoPeca());
            statement.setString(5, promocao.getDataPeca());
            statement.setString(6, promocao.getHorario());
            statement.setInt(7, promocao.getID());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Promocao get(int ID) {
        Promocao promocao = null;
        String sql = "SELECT * FROM Promocao WHERE ID = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1, ID);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String URLdoSite = resultSet.getString("URLdoSite");
                String CNPJdoTeatro = resultSet.getString("CNPJdoTeatro");
                String nomePeca = resultSet.getString("nomePeca");
                float precoPeca = resultSet.getFloat("precoPeca");
                String dataPeca = resultSet.getString("dataPeca");
                String horario = resultSet.getString("horario");
                promocao = new Promocao(ID, URLdoSite, CNPJdoTeatro, nomePeca, precoPeca, dataPeca, horario);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return promocao;
    }

    public List<Promocao> getByTeatro(String CNPJdoTeatro) {
        List<Promocao> listaPromocoes = new ArrayList<>();
        String sql = "SELECT * FROM Promocao WHERE CNPJdoTeatro = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, CNPJdoTeatro);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int ID = resultSet.getInt("ID");
                String URLdoSite = resultSet.getString("URLdoSite");
                String nomePeca = resultSet.getString("nomePeca");
                float precoPeca = resultSet.getFloat("precoPeca");
                String dataPeca = resultSet.getString("dataPeca");
                String horario = resultSet.getString("horario");
                Promocao promocao = new Promocao(ID, URLdoSite, CNPJdoTeatro, nomePeca, precoPeca, dataPeca, horario);
                listaPromocoes.add(promocao);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPromocoes;
    }

    public List<Promocao> getBySite(String URLdoSite) {
        List<Promocao> listaPromocoes = new ArrayList<>();
        String sql = "SELECT * FROM Promocao WHERE URLdoSite = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, URLdoSite);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int ID = resultSet.getInt("ID");
                String CNPJdoTeatro = resultSet.getString("CNPJdoTeatro");
                String nomePeca = resultSet.getString("nomePeca");
                float precoPeca = resultSet.getFloat("precoPeca");
                String dataPeca = resultSet.getString("dataPeca");
                String horario = resultSet.getString("horario");
                Promocao promocao = new Promocao(ID, URLdoSite, CNPJdoTeatro, nomePeca, precoPeca, dataPeca, horario);
                listaPromocoes.add(promocao);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPromocoes;
    }
}