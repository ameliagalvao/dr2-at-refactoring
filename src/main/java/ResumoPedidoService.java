public class ResumoPedidoService {
    public String gerarResumo(Pedido pedido, double valorFrete) {
        return "Pedido para " + pedido.getEntrega().getDestinatario() +
                " com frete tipo " + pedido.getTipoFrete() +
                " no valor de R$" + valorFrete;
    }
}