package co.com.segurossura.certification.soat.exceptions;

public class MensajeAlertaError extends AssertionError {

  public static final String MENSAJE_ALERTA_ERRADO =
      "El mensaje de la alerta obtenido no es igual al esperado";

  public MensajeAlertaError(String mensaje, Throwable causa) {
    super(mensaje, causa);
  }
}
