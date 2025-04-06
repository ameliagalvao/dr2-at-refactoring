package application.etiqueta;

import domain.model.Pedido;

public class EtiquetaPadrao implements FormatoEtiqueta {
    @Override
    public String gerar(Pedido pedido, double valorFrete) {
        return "Destinatário: " + pedido.getEntrega().getDestinatario() +
                "\nEndereço: " + pedido.getEntrega().getEndereco() +
                "\nValor do Frete: R$" + valorFrete;
    }
}
