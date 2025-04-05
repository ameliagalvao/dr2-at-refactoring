import java.util.UUID;

public final class Entrega {
    private final String id;
    private final String endereco;
    private final double peso;
    private final String destinatario;

    public Entrega(String endereco, double peso, String destinatario) {
        if (endereco == null || endereco.isBlank()) {
            throw new EntregaInvalidaException("Endereço não pode ser vazio");
        }
        if (peso <= 0) {
            throw new EntregaInvalidaException("Peso deve ser positivo");
        }
        if (destinatario == null || destinatario.isBlank()) {
            throw new EntregaInvalidaException("Destinatário não pode ser vazio");
        }
        this.id = UUID.randomUUID().toString();
        this.endereco = endereco;
        this.peso = peso;
        this.destinatario = destinatario;
    }

    public String getEndereco() { return endereco; }
    public double getPeso() { return peso; }
    public String getDestinatario() { return destinatario; }
    public String getId() {
        return id;
    }
}
