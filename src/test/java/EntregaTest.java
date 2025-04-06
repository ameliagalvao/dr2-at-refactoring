import org.junit.Test;

import static org.junit.Assert.*;

public class EntregaTest {

    @Test
    public void deveCriarEntregaValida() {
        Resultado<Entrega> resultado = Entrega.criar("Rua X", 3.0, "João");
        assertFalse(resultado.isErro());
        assertNotNull(resultado.getValor());
    }

    @Test
    public void deveRetornarErroSePesoForNegativo() {
        Resultado<Entrega> resultado = Entrega.criar("Rua X", -1.0, "João");
        assertTrue(resultado.isErro());
        assertEquals("Peso deve ser positivo", resultado.getErro());
    }
}
