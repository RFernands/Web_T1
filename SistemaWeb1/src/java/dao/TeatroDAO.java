package dao;

import model.Teatro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TeatroDAO extends GenericDAO {

    public void insert(Teatro teatro) {
        String sql = "INSERT INTO Teatro (email, senha, CNPJ, nome, cidade) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement = conn.prepareStatement(sql);
            statement.setString(1, teatro.getEmail());
            statement.setString(2, teatro.getSenha());
            statement.setString(3, teatro.getCNPJ());
            statement.setString(4, teatro.getNome());
            statement.setString(5, teatro.getCidade());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Teatro> getAll() {
        List<Teatro> listaTeatros = new ArrayList<>();
        String sql = "SELECT * FROM Teatro";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String CNPJ = resultSet.getString("CNPJ");
                String nome = resultSet.getString("nome");
                String cidade = resultSet.getString("cidade");
                Teatro teatro = new Teatro(email, senha, CNPJ, nome, cidade);
                listaTeatros.add(teatro);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaTeatros;
    }

    public void delete(Teatro teatro) {
        String sql = "DELETE FROM Teatro where CNPJ = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, teatro.getCNPJ());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Teatro teatro) {
        String sql = "UPDATE Teatro SET email = ?, senha = ?, nome = ?, cidade = ?";
        sql += " WHERE CNPJ = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, teatro.getEmail());
            statement.setString(2, teatro.getSenha());
            statement.setString(3, teatro.getNome());
            statement.setString(4, teatro.getCidade());
            statement.setString(5, teatro.getCNPJ());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Teatro get(String CNPJ) {
        Teatro teatro = null;
        String sql = "SELECT * FROM Teatro WHERE CNPJ = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, CNPJ);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String nome = resultSet.getString("nome");
                String cidade = resultSet.getString("cidade");
                teatro = new Teatro(email, senha, CNPJ, nome, cidade);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return teatro;
    }

    public List<Teatro> getByCity(String cidade) {
        List<Teatro> listaTeatros = new ArrayList<>();
        String sql = "SELECT id, email, senha, cnpj, nome, cidade FROM Teatro,Usuario where id = id_usuario and cidade = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, cidade);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String CNPJ = resultSet.getString("CNPJ");
                String nome = resultSet.getString("nome");
                Teatro teatro = new Teatro(email, senha, CNPJ, nome, cidade);
                listaTeatros.add(teatro);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaTeatros;
    }
}
