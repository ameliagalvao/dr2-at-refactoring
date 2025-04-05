public class FreteExpresso implements CalculadoraFrete {
    public double calcular(Entrega entrega) {
        return entrega.getPeso() * 1.5 + 10;
    }
}