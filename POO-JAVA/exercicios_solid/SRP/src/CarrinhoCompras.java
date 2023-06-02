import java.util.HashMap;
import java.util.Map;

public class CarrinhoCompras {
    private Map<Produto, Integer> carrinho;

    public CarrinhoCompras() {
        carrinho = new HashMap<>();
    }

    public void addItem(Produto produto, int quantidade) {
        carrinho.put(produto, carrinho.getOrDefault(produto, 0) + quantidade);
    }

    public void removeItem(Produto produto, int quantidade) {
        int currentQuantity = carrinho.getOrDefault(produto, 0);
        if (currentQuantity <= 0) {
            carrinho.remove(produto);
        } else {
            carrinho.put(produto, currentQuantity - quantidade);
        }
    }

    public double calcularPrecoTotal() {
        double precoTotal = 0.0;
        for (Map.Entry<Produto, Integer> entry : carrinho.entrySet()) {
            Produto produto = entry.getKey();
            int quantidade = entry.getValue();
            double precoItem = produto.getPreco() * quantidade;
            precoTotal += precoItem;
        }
        return precoTotal;
    }
}