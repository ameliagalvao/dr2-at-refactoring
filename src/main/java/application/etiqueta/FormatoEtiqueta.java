package application.etiqueta;

import domain.model.Pedido;

public interface FormatoEtiqueta {
    String gerar(Pedido pedido, double valorFrete);
}