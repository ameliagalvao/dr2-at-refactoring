package application.promocao;

import domain.model.Pedido;

public interface PromocaoFrete {
    double aplicarDesconto(double valorOriginal, Pedido pedido);
}
