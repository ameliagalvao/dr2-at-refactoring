package application.resumo;

import domain.model.Entrega;
import domain.model.Pedido;
import domain.model.TipoFrete;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ResumoPedidoServiceTest {

    @Test
    public void deveGerarResumoCorreto() {
        Entrega entrega = Entrega.criar("Av. Central", 3.5, "Pedro").getValor();
        Pedido pedido = Pedido.criar(entrega, TipoFrete.EXPRESSO).getValor();

        ResumoPedidoService service = new ResumoPedidoService();
        String resumo = service.gerarResumo(pedido, 15.0);

        assertTrue(resumo.contains("domain.model.Pedido para Pedro"));
        assertTrue(resumo.contains("no valor de R$15.0"));
    }
}