package application.etiqueta;

import application.promocao.PromocaoFrete;
import application.promocao.PromocaoFreteSemDesconto;
import domain.frete.CalculadoraFrete;
import domain.model.Pedido;
import exception.CalculoFreteException;

import java.util.Objects;

public class EtiquetaService {
    private final CalculadoraFrete calculadoraFrete;
    private final PromocaoFrete promocaoFrete;
    private final FormatoEtiqueta formatoEtiqueta;

    public EtiquetaService(CalculadoraFrete calculadoraFrete,
                           PromocaoFrete promocaoFrete,
                           FormatoEtiqueta formatoEtiqueta) {
        this.calculadoraFrete = Objects.requireNonNull(calculadoraFrete);
        this.promocaoFrete = promocaoFrete != null ? promocaoFrete : new PromocaoFreteSemDesconto();
        this.formatoEtiqueta = Objects.requireNonNull(formatoEtiqueta);
    }

    public String gerarEtiqueta(Pedido pedido) {
        double valorFrete = calcularComPromocao(pedido);
        return formatoEtiqueta.gerar(pedido, valorFrete);
    }

    private double calcularComPromocao(Pedido pedido) {
        try {
            double valorOriginal = calculadoraFrete.calcular(pedido.getEntrega());
            return promocaoFrete.aplicarDesconto(valorOriginal, pedido);
        } catch (Exception e) {
            throw new CalculoFreteException("Erro ao calcular o valor do frete com promoção", e);
        }
    }
}