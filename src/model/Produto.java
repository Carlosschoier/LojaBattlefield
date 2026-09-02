// aluno @carlos eduardo schoier
package model;

public class Produto {

    private int id;
    private String nome;
    private double preco;
    private int quantidade;
    private String categoria;
    private String observacoes;
    private int idFornecedor;

    // ================= CONSTRUTOR =================

    public Produto(String nome, double preco, int quantidade) {

    this.nome = nome;
    this.preco = preco;
    this.quantidade = quantidade;
    this.categoria = categoria;
    this.observacoes = observacoes;
    this.idFornecedor = idFornecedor;
}

    public Produto(String nome, double preco, int quantidade, String categoria, String observacoes, int idFornecedor) {
    this.nome = nome;
    this.preco = preco;
    this.quantidade = quantidade;
    this.categoria = categoria;
    this.observacoes = observacoes;
    this.idFornecedor = idFornecedor;
}

    // ================= GETTERS E SETTERS =================

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    // ================= EXIBIR PRODUTO =================

    public void exibirProduto() {

        System.out.println("ID: " + id);
        System.out.println("Produto: " + nome);
        System.out.println("Preço: " + preco);
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Categoria: " + categoria);
        System.out.println("Observações: " + observacoes);
        System.out.println("ID Fornecedor: " + idFornecedor);
    }
}