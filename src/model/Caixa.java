package model;
/**
 *
 * @author cadu
 */
public class Caixa {

    private Pedido pedido;

    public Caixa() {
        pedido = new Pedido(1);
    }

    public void adicionarProduto(Produto produto) {
        pedido.adicionarProduto(produto);
    }

    public double getTotal() {
        return pedido.getValorTotal();
    }
}
