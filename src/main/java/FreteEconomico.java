public class FreteEconomico implements CalculadoraFrete {
    private static final double MULTIPLICADOR_PESO = 1.1;
    private static final double DESCONTO_FIXO = 5.0;

    public double calcular(Entrega entrega) {
        return entrega.getPeso() * MULTIPLICADOR_PESO - DESCONTO_FIXO;
    }
}