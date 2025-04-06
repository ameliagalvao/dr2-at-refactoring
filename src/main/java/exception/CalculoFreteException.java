package exception;

public class CalculoFreteException extends RuntimeException {
    public CalculoFreteException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
