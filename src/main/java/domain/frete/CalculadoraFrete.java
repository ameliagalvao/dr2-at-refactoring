package domain.frete;

import domain.model.Entrega;

public interface CalculadoraFrete {
    double calcular(Entrega entrega);
}
