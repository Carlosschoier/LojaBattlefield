package model;

import java.util.ArrayList;

public class Pedido {

    /**
     * @return the Preco
     */
    public double getPreco() {
        return Preco;
    }

    /**
     * @param Preco the Preco to set
     */
    public void setPreco(double Preco) {
        this.Preco = Preco;
    }

    private int id;
    private ArrayList<Produto> produtos;
    private double valorTotal;
    private double Preco;
    
    
    public Pedido(int id) {
        this.id = id;
        this.produtos = new ArrayList<>();
        this.valorTotal = 0;
    }

    // Adicionar produto ao pedido
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    // Listar produtos do pedido
    public void listarPedido() {
        System.out.println("Pedido ID: " + id);
        System.out.println("Produtos:");

        for (Produto p : produtos) {
            System.out.println("- " + p.getNome() + " | R$ " + p.getPreco());
        }

        System.out.println("Total: R$ " + valorTotal);
    }

    // Getter
    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public double getValorTotal() {
        return valorTotal;
    }
}