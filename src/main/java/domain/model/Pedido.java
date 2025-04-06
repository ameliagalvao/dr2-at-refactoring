package domain.model;

import java.util.UUID;

public class Pedido {
    private final String id;
    private final Entrega entrega;
    private final TipoFrete tipoFrete;

    private Pedido(Entrega entrega, TipoFrete tipoFrete) {
        this.id = UUID.randomUUID().toString();
        this.entrega = entrega;
        this.tipoFrete = tipoFrete;
    }

    public static Resultado<Pedido> criar(Entrega entrega, TipoFrete tipoFrete) {
        if (entrega == null) {
            return Resultado.erro("domain.model.Entrega não pode ser nula");
        }
        if (tipoFrete == null) {
            return Resultado.erro("Tipo de frete inválido");
        }
        return Resultado.sucesso(new Pedido(entrega, tipoFrete));
    }

    public String getId() { return id; }
    public Entrega getEntrega() { return entrega; }
    public TipoFrete getTipoFrete() { return tipoFrete; }
    public String getEntregaId() { return entrega.getId(); }
}
