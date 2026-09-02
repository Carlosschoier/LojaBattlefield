package dao;
//@cadu
import conexao.Conexao;
import model.Fornecedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO {

    // ================= CADASTRAR =================

    public void cadastrar(Fornecedor fornecedor) throws SQLException {

        String sql = """
                INSERT INTO fornecedor
                (nome, cnpj, telefone, email)
                VALUES (?, ?, ?, ?)
                """;

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getCnpj());
            stmt.setString(3, fornecedor.getTelefone());
            stmt.setString(4, fornecedor.getEmail());

            stmt.executeUpdate();
        }
    }

    // ================= LISTAR =================

    public List<Fornecedor> listarTodos() throws SQLException {

        List<Fornecedor> fornecedores = new ArrayList<>();

        String sql = """
                SELECT id_fornecedor,
                       nome,
                       cnpj,
                       telefone,
                       email
                FROM fornecedor
                """;

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Fornecedor fornecedor = new Fornecedor(
                        rs.getInt("id_fornecedor"),
                        rs.getString("nome"),
                        rs.getString("cnpj"),
                        rs.getString("telefone"),
                        rs.getString("email")
                );

                fornecedores.add(fornecedor);
            }
        }

        return fornecedores;
    }

    // ================= ALTERAR =================

    public void alterar(Fornecedor fornecedor) throws SQLException {

        String sql = """
                UPDATE fornecedor
                SET nome = ?,
                    cnpj = ?,
                    telefone = ?,
                    email = ?
                WHERE id_fornecedor = ?
                """;

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getCnpj());
            stmt.setString(3, fornecedor.getTelefone());
            stmt.setString(4, fornecedor.getEmail());
            stmt.setInt(5, fornecedor.getId());

            stmt.executeUpdate();
        }
    }

    // ================= EXCLUIR =================

    public void excluir(int id) throws SQLException {

        String sql = """
                DELETE FROM fornecedor
                WHERE id_fornecedor = ?
                """;

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);

            stmt.executeUpdate();
        }
    }   
}
