import java.util.UUID;

public final class Entrega {
    private final String id;
    private final String endereco;
    private final double peso;
    private final String destinatario;

    private Entrega(String endereco, double peso, String destinatario) {
        this.id = UUID.randomUUID().toString();
        this.endereco = endereco;
        this.peso = peso;
        this.destinatario = destinatario;
    }

    public static Resultado<Entrega> criar(String endereco, double peso, String destinatario) {
        if (endereco == null || endereco.isBlank()) {
            return Resultado.erro("Endereço não pode ser vazio");
        }
        if (peso <= 0) {
            return Resultado.erro("Peso deve ser positivo");
        }
        if (destinatario == null || destinatario.isBlank()) {
            return Resultado.erro("Destinatário não pode ser vazio");
        }
        return Resultado.sucesso(new Entrega(endereco, peso, destinatario));
    }

    public String getId() { return id; }
    public String getEndereco() { return endereco; }
    public double getPeso() { return peso; }
    public String getDestinatario() { return destinatario; }
}
