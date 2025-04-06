public class PromocaoFreteSemDesconto implements PromocaoFrete {
    @Override
    public double aplicarDesconto(double valorOriginal, Pedido pedido) {
        return valorOriginal;
    }
}
