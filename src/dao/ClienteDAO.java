package dao;

import conexao.Conexao;
import model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    // ================= CADASTRAR =================

    public void cadastrar(Cliente cliente) throws SQLException {

        String sql = """
                INSERT INTO cliente
                (nome, email, senha)
                VALUES (?, ?, ?)
                """;

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getSenha());

            stmt.executeUpdate();
        }
    }

    // ================= LISTAR =================

    public List<Cliente> listarTodos() throws SQLException {

        List<Cliente> clientes = new ArrayList<>();

        String sql = """
                SELECT id_cliente,
                       nome,
                       email,
                       senha
                FROM cliente
                """;

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Cliente cliente = new Cliente(
                        rs.getInt("id_cliente"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha")
                );

                clientes.add(cliente);
            }
        }

        return clientes;
    }

    // ================= ALTERAR =================

    public void alterar(Cliente cliente) throws SQLException {

        String sql = """
                UPDATE cliente
                SET nome = ?,
                    email = ?,
                    senha = ?
                WHERE id_cliente = ?
                """;

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getSenha());
            stmt.setInt(4, cliente.getId());

            stmt.executeUpdate();
        }
    }

    // ================= EXCLUIR =================

    public void excluir(int id) throws SQLException {

        String sql = "DELETE FROM cliente WHERE id_cliente = ?";

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);

            stmt.executeUpdate();
        }
    }
}