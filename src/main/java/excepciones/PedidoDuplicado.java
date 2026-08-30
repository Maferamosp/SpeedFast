package excepciones;

public class PedidoDuplicado extends RuntimeException {
    public PedidoDuplicado(String message) {
        super(message);
    }
}
