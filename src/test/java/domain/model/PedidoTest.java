package domain.model;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PedidoTest {

    @Test
    public void deveCriarPedidoValido() {
        Entrega entrega = Entrega.criar("Rua A", 2.0, "Maria").getValor();
        Resultado<Pedido> resultado = Pedido.criar(entrega, TipoFrete.PADRAO);
        assertFalse(resultado.isErro());
    }

    @Test
    public void deveRetornarErroSeTipoFreteForNulo() {
        Entrega entrega = Entrega.criar("Rua A", 2.0, "Maria").getValor();
        Resultado<Pedido> resultado = Pedido.criar(entrega, null);
        assertTrue(resultado.isErro());
    }
}
