public class FreteEconomico implements CalculadoraFrete {
    public double calcular(Entrega entrega) {
        return entrega.getPeso() * 1.1 - 5;
    }
}