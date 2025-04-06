package domain.frete;

import domain.model.Entrega;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculadoraFreteTest {

    @Test
    public void deveCalcularFretePadraoCorretamente() {
        Entrega entrega = Entrega.criar("Rua A", 2.0, "Maria").getValor();
        CalculadoraFrete frete = new FretePadrao();
        assertEquals(2.4, frete.calcular(entrega), 0.01);
    }

    @Test
    public void deveCalcularFreteExpressoCorretamente() {
        Entrega entrega = Entrega.criar("Rua A", 2.0, "Maria").getValor();
        CalculadoraFrete frete = new FreteExpresso();
        assertEquals(13.0, frete.calcular(entrega), 0.01);
    }
}