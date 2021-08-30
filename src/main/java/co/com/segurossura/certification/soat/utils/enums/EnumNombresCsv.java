package co.com.segurossura.certification.soat.utils.enums;

public enum EnumNombresCsv {
  DATOS_PERSONA("personas"),
  CARACTERISTICAS_VEHICULO_DIGITAL("caracteristicas_vehiculo_digital"),
  CARACTERISTICAS_VEHICULO_PRESENCIAL("caracteristicas_vehiculo_presencial"),
  DATOS_TECNICOS("datos_tecnicos"),
  DATOS_GENERICOS_REQUEST("genericos_request");

  private final String nombre;

  EnumNombresCsv(String nombre) {
    this.nombre = nombre;
  }

  public String getNombre() {
    return nombre;
  }
}
