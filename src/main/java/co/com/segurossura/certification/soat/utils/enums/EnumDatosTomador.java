package co.com.segurossura.certification.soat.utils.enums;

public enum EnumDatosTomador {
  CEDULA_TOMADOR("71271978"),
  CELULAR_TOMADOR("3122124978"),
  CODIGO_VIN("01234567891011121");

  private final String datosTomador;

  EnumDatosTomador(String datosTomador) {
    this.datosTomador = datosTomador;
  }

  public String getDatosTomador() {
    return datosTomador;
  }
}
