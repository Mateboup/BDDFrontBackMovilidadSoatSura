package co.com.segurossura.certification.soat.utils.enums;

public enum EnumTipoExpedicion {
  NACIONALES("NACIONALES");

  private final String tipoExpedicion;

  EnumTipoExpedicion(String tipoExpedicion) {
    this.tipoExpedicion = tipoExpedicion;
  }

  public String gettipoExpedicion() {
    return tipoExpedicion;
  }
}
