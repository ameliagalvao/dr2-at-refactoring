import java.util.UUID;

public class Pedido {
    private final String id;
    private final Entrega entrega;
    private final TipoFrete tipoFrete;

    public Pedido(Entrega entrega, TipoFrete tipoFrete) {
        if (entrega == null) {
            throw new IllegalArgumentException("Entrega não pode ser nula");
        }
        if (tipoFrete == null) {
            throw new IllegalArgumentException("Tipo de frete inválido");
        }
        this.id = UUID.randomUUID().toString();
        this.entrega = entrega;
        this.tipoFrete = tipoFrete;
    }

    public String getId() {
        return id;
    }

    public Entrega getEntrega() {
        return entrega;
    }

    public TipoFrete getTipoFrete() {
        return tipoFrete;
    }
}
