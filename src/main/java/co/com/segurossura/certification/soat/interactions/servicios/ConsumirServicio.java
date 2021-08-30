package co.com.segurossura.certification.soat.interactions.servicios;

import co.com.segurossura.certification.soat.utils.enums.EnumCredencialesServicios;
import java.util.Map;

public final class ConsumirServicio {

  private ConsumirServicio() {}

  public static ConsumirServicioPostConHeaders postConHeaders(
      String recurso,
      EnumCredencialesServicios enumCredenciales,
      Object request,
      Map<String, ?> headers) {
    return new ConsumirServicioPostConHeaders(recurso, enumCredenciales, request, headers);
  }
}
