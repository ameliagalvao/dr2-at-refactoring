package domain.model;

import domain.frete.CalculadoraFrete;
import domain.frete.FreteEconomico;
import domain.frete.FreteExpresso;
import domain.frete.FretePadrao;

public enum TipoFrete {
    EXPRESSO(new FreteExpresso()),
    PADRAO(new FretePadrao()),
    ECONOMICO(new FreteEconomico());

    private final CalculadoraFrete calculadora;

    TipoFrete(CalculadoraFrete calculadora) {
        this.calculadora = calculadora;
    }

    public CalculadoraFrete getCalculadora() {
        return calculadora;
    }
}