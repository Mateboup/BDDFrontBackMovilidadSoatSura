package co.com.segurossura.certification.soat.exceptions;

public class NumeroPolizaErrada extends AssertionError {
  public static final String NUMERO_POLIZA_ERRADO =
      "El numero de la poliza obtenido no es igual al esperado";

  public NumeroPolizaErrada(String mensaje, Throwable causa) {
    super(mensaje, causa);
  }
}
