public class FreteExpresso implements CalculadoraFrete {
    private static final double MULTIPLICADOR_PESO = 1.5;
    private static final double TAXA_FIXA = 10.0;

    public double calcular(Entrega entrega) {
        return entrega.getPeso() * MULTIPLICADOR_PESO + TAXA_FIXA;
    }
}
