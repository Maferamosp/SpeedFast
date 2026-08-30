package excepciones;

public class RepartidorInvalido extends RuntimeException {
  public RepartidorInvalido(String message) {
    super(message);
  }
}
