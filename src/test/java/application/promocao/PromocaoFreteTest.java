package application.promocao;

import domain.model.Entrega;
import domain.model.Pedido;
import domain.model.TipoFrete;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PromocaoFreteTest {

    @Test
    public void deveAplicarFreteGratisQuandoPesoMenorQue2() {
        Entrega entrega = Entrega.criar("Rua A", 1.5, "João").getValor();
        Pedido pedido = Pedido.criar(entrega, TipoFrete.ECONOMICO).getValor();

        PromocaoFrete promocao = new PromocaoFreteGratis();
        double resultado = promocao.aplicarDesconto(10.0, pedido);
        assertEquals(0.0, resultado, 0.0001); // ← corrigido aqui
    }

    @Test
    public void naoDeveAplicarFreteGratisParaOutrosCasos() {
        Entrega entrega = Entrega.criar("Rua A", 3.0, "João").getValor();
        Pedido pedido = Pedido.criar(entrega, TipoFrete.PADRAO).getValor();

        PromocaoFrete promocao = new PromocaoFreteGratis();
        double resultado = promocao.aplicarDesconto(10.0, pedido);
        assertEquals(10.0, resultado, 0.0001); // ← corrigido aqui
    }
}