package dao;

import model.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UsuarioDAO {

    public UsuarioDAO() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:derby://localhost:1527/cadastro", "root", "root");
    }

    public int insert(Usuario usuario) {
        String sql = "INSERT INTO Usuario (email, senha, ativo) VALUES (?, ?, ?)";
        
        int ID;
        
        try {
            Connection conn = this.getConnection();
            //PreparedStatement statement = conn.prepareStatement(sql));
            PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);            
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            statement.setString(1, usuario.getEmail());
            statement.setString(2, encoder.encode(usuario.getSenha()));
            statement.setInt(3, usuario.getAtivo());
            statement.executeUpdate();
            
            ResultSet result = statement.getGeneratedKeys();
            result.next();
            ID = result.getInt(1);
            //VER AQUI
            
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ID;
    }

    public List<Usuario> getAll() {
        List<Usuario> listaUsuarios = new ArrayList<>();
        String sql = "SELECT * FROM Usuario";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int ID = resultSet.getInt("ID");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                int ativo = resultSet.getInt("ativo");
                Usuario usuario = new Usuario(ID, email, senha, ativo);
                listaUsuarios.add(usuario);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaUsuarios;
    }

    public void delete(Usuario usuario) {
        String sql = "DELETE FROM Usuario where ID = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, usuario.getID());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Usuario usuario) {
        String sql = "UPDATE Usuario SET email = ?, senha = ?, ativo = ?";
        sql += " WHERE ID = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            statement.setInt(1, usuario.getID());
            statement.setString(2, usuario.getEmail());
            statement.setString(3, encoder.encode(usuario.getSenha()));
            statement.setInt(4, usuario.getAtivo());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Usuario get(int ID) {
        Usuario usuario = null;
        String sql = "SELECT * FROM Usuario WHERE ID = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1, ID);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                int ativo = resultSet.getInt("ativo");
                usuario = new Usuario(ID, email, senha, ativo);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuario;
    }

    public Usuario getByEmail(String email) {
        Usuario usuario = null;
        String sql = "SELECT * FROM Usuario where email = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int ID = resultSet.getInt("ID");
                String senha = resultSet.getString("senha");
                int ativo = resultSet.getInt("ativo");                
                usuario = new Usuario(ID, email, senha, ativo);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuario;
    }
}
