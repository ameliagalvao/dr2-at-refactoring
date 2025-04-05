public class FretePadrao implements CalculadoraFrete {
    public double calcular(Entrega entrega) {
        return entrega.getPeso() * 1.2;
    }
}