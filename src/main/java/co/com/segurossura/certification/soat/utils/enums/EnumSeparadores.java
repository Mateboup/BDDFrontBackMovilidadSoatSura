package co.com.segurossura.certification.soat.utils.enums;

public enum EnumSeparadores {
  SEPARADOR_COMA(","),
  SEPARADOR_PUNTO_COMA(";"),
  SEPARADOR_VIRGULILLA("~");

  private final String separador;

  EnumSeparadores(String separador) {
    this.separador = separador;
  }

  public String getSeparador() {
    return separador;
  }
}
