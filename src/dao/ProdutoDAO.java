package dao;

/**
 *
 * @author cadu
 */
import conexao.Conexao;
import model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    // ================= CADASTRAR =================

    public void cadastrar(Produto produto) throws SQLException {

        String sql = """
                INSERT INTO produto
                (nome, preco, quantidade_estoque, categoria, observacoes, id_fornecedor)
                VALUES (?, ?, ?, ?, ?, ?)
                """;

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setString(4, produto.getCategoria());
            stmt.setString(5, produto.getObservacoes());
            stmt.setNull(6, java.sql.Types.INTEGER);

            stmt.executeUpdate();
        }
    }

    // ================= LISTAR =================

    public List<Produto> listarTodos() throws SQLException {

List<Produto> produtos = new ArrayList<>();

    String sql = """
            SELECT id_produto,
                   nome,
                   preco,
                   quantidade_estoque,
                   categoria,
                   observacoes,
                   id_fornecedor
            FROM produto
            """;

    try (Connection conexao = Conexao.conectar();
         PreparedStatement stmt = conexao.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {

            Produto produto = new Produto(
                    rs.getString("nome"),
                    rs.getDouble("preco"),
                    rs.getInt("quantidade_estoque"),
                    rs.getString("categoria"),
                    rs.getString("observacoes"),
                    rs.getInt("id_fornecedor")
            );

            produto.setId(rs.getInt("id_produto"));

            produtos.add(produto);
        }
    }

    return produtos;
    }

    // ================= ALTERAR =================

    public void alterar(Produto produto) throws SQLException {

        String sql = """
            UPDATE produto
            SET nome = ?,
                preco = ?,
                quantidade_estoque = ?,
                categoria = ?,
                observacoes = ?,
                id_fornecedor = ?
            WHERE id_produto = ?
            """;

    try (Connection conexao = Conexao.conectar();
         PreparedStatement stmt = conexao.prepareStatement(sql)) {

        stmt.setString(1, produto.getNome());
        stmt.setDouble(2, produto.getPreco());
        stmt.setInt(3, produto.getQuantidade());
        stmt.setString(4, produto.getCategoria());
        stmt.setString(5, produto.getObservacoes());

        // Por enquanto ainda não estamos trabalhando com fornecedores
        stmt.setNull(6, java.sql.Types.INTEGER);

        // ID do produto que será alterado
        stmt.setInt(7, produto.getId());

        stmt.executeUpdate();
    }
    }

    // ================= EXCLUIR =================

    public void excluir(int id) throws SQLException {

        String sql = "DELETE FROM produto WHERE id_produto = ?";

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);

            stmt.executeUpdate();
        }
    }
}
