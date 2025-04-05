public class EtiquetaService {
    private final CalculadoraFrete calculadoraFrete;

    public EtiquetaService(CalculadoraFrete calculadoraFrete) {
        if (calculadoraFrete == null) {
            throw new IllegalArgumentException("Calculadora de frete não pode ser nula");
        }
        this.calculadoraFrete = calculadoraFrete;
    }

    public String gerarEtiqueta(Entrega entrega) {
        double valorFrete = calcularComValidacao(entrega);
        return "Destinatário: " + entrega.getDestinatario() +
                "\nEndereço: " + entrega.getEndereco() +
                "\nValor do Frete: R$" + valorFrete;
    }

    public String gerarResumo(Entrega entrega, String tipoFrete) {
        double valorFrete = calcularComValidacao(entrega);
        return "Pedido para " + entrega.getDestinatario() +
                " com frete tipo " + tipoFrete +
                " no valor de R$" + valorFrete;
    }

    private double calcularComValidacao(Entrega entrega) {
        try {
            return calculadoraFrete.calcular(entrega);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao calcular frete: " + e.getMessage(), e);
        }
    }
}
