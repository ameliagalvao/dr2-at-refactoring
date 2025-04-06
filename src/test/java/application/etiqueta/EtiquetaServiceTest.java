package application.etiqueta;

import application.promocao.PromocaoFreteSemDesconto;
import domain.frete.FretePadrao;
import domain.model.Entrega;
import domain.model.Pedido;
import domain.model.TipoFrete;
import exception.CalculoFreteException;
import org.junit.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class EtiquetaServiceTest {

    @Test
    public void deveGerarEtiquetaTextoPadrao() {
        Entrega entrega = Entrega.criar("Rua 123", 2.0, "Ana").getValor();
        Pedido pedido = Pedido.criar(entrega, TipoFrete.PADRAO).getValor();

        EtiquetaService service = new EtiquetaService(
                new FretePadrao(),
                new PromocaoFreteSemDesconto(),
                new EtiquetaPadrao()
        );

        String etiqueta = service.gerarEtiqueta(pedido);
        assertTrue(etiqueta.contains("Destinatário: Ana"));
        assertTrue(etiqueta.contains("Valor do Frete: R$"));
    }

    @Test
    public void deveLancarExcecaoEspecificaEmErroDeFrete() {
        Pedido pedido = Pedido.criar(Entrega.criar("Rua", 1.0, "A").getValor(), TipoFrete.PADRAO).getValor();

        EtiquetaService service = new EtiquetaService(
                entrega -> { throw new RuntimeException("falha"); },
                new PromocaoFreteSemDesconto(),
                new EtiquetaPadrao()
        );

        assertThrows(CalculoFreteException.class, () -> service.gerarEtiqueta(pedido));
    }
}