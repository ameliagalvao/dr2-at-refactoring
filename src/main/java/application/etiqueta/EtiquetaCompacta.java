package application.etiqueta;

import domain.model.Pedido;

public class EtiquetaCompacta  implements FormatoEtiqueta {
    @Override
    public String gerar(Pedido pedido, double valorFrete) {
        return pedido.getEntrega().getDestinatario() + " - R$" + valorFrete;
    }
}