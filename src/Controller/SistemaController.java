//@ aluno: Carlos Eduardo Schoier
package Controller;

import model.Cliente;
import model.Produto;
import model.Pedido;

public class SistemaController {

    private Cliente cliente;
    private Pedido pedido;

    public SistemaController() {
        // cria cliente fixo (simulação)
        cliente = new Cliente(1, "anderson", "anderson@email.com", "1234");
        pedido = new Pedido(1);
    }

    // ================= LOGIN =================
    public boolean fazerLogin(String email, String senha) {
        return cliente.login(email, senha);
    }

    // ================= PRODUTOS =================
    public Produto criarProduto(String nome, double preco, int quantidade) {
        return new Produto(nome, preco, quantidade);
}

    // ================= PEDIDO =================
    public void adicionarProdutoPedido(Produto p) {
        pedido.adicionarProduto(p);
    }

    public void mostrarPedido() {
        pedido.listarPedido();
    }

    public double getTotalPedido() {
        return pedido.getValorTotal();
    }
}