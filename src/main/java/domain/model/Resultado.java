package domain.model;

public class Resultado<T> {
    private final T valor;
    private final String erro;

    private Resultado(T valor, String erro) {
        this.valor = valor;
        this.erro = erro;
    }

    public static <T> Resultado<T> sucesso(T valor) {
        return new Resultado<>(valor, null);
    }

    public static <T> Resultado<T> erro(String mensagem) {
        return new Resultado<>(null, mensagem);
    }

    public boolean isErro() {
        return erro != null;
    }

    public T getValor() {
        return valor;
    }

    public String getErro() {
        return erro;
    }
}
