public class EtiquetaService {
    private final CalculadoraFrete calculadoraFrete;
    private final PromocaoFrete promocaoFrete;

    public EtiquetaService(CalculadoraFrete calculadoraFrete, PromocaoFrete promocaoFrete) {
        if (calculadoraFrete == null) {
            throw new IllegalArgumentException("Calculadora de frete não pode ser nula");
        }
        this.calculadoraFrete = calculadoraFrete;
        this.promocaoFrete = (promocaoFrete != null) ? promocaoFrete : new PromocaoFreteSemDesconto();
    }

    public String gerarEtiqueta(Pedido pedido) {
        double valorFrete = calcularComPromocao(pedido);
        Entrega entrega = pedido.getEntrega();
        return "Destinatário: " + entrega.getDestinatario() +
                "\nEndereço: " + entrega.getEndereco() +
                "\nValor do Frete: R$" + valorFrete;
    }

    public String gerarResumo(Pedido pedido) {
        double valorFrete = calcularComPromocao(pedido);
        return "Pedido para " + pedido.getEntrega().getDestinatario() +
                " com frete tipo " + pedido.getTipoFrete() +
                " no valor de R$" + valorFrete;
    }

    private double calcularComPromocao(Pedido pedido) {
        try {
            double valorOriginal = calculadoraFrete.calcular(pedido.getEntrega());
            return promocaoFrete.aplicarDesconto(valorOriginal, pedido);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao calcular frete: " + e.getMessage(), e);
        }
    }
}