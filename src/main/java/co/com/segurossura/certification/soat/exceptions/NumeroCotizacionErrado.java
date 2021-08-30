package co.com.segurossura.certification.soat.exceptions;

public class NumeroCotizacionErrado extends AssertionError {

  public static final String NUMERO_COTIZACION_ERRADO =
      "El numero de la cotizacion obtenido no es igual al esperado";

  public NumeroCotizacionErrado(String mensaje, Throwable causa) {
    super(mensaje, causa);
  }
}
