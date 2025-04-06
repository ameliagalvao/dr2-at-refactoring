public class PromocaoFreteGratis implements PromocaoFrete {
    private static final double LIMITE_PESO = 2.0;
    private static final double FRETE_GRATIS = 0.0;

    @Override
    public double aplicarDesconto(double valorOriginal, Pedido pedido) {
        if (pedido.getTipoFrete() == TipoFrete.ECONOMICO && pedido.getEntrega().getPeso() < LIMITE_PESO) {
            return FRETE_GRATIS;
        }
        return valorOriginal;
    }
}