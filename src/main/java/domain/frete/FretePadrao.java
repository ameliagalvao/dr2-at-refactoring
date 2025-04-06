package domain.frete;

import domain.model.Entrega;

public class FretePadrao implements CalculadoraFrete {
    private static final double MULTIPLICADOR_PESO = 1.2;

    public double calcular(Entrega entrega) {
        return entrega.getPeso() * MULTIPLICADOR_PESO;
    }
}