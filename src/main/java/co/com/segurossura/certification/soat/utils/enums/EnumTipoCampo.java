package co.com.segurossura.certification.soat.utils.enums;

public enum EnumTipoCampo {
  TEXTO("texto"),
  SELECTOR("selector"),
  SELECTOR_FILTRO_MARCA("selector filtro marca"),
  SELECTOR_FILTRO_LINEA("selector filtro linea");

  private final String campo;

  EnumTipoCampo(String campo) {
    this.campo = campo;
  }

  public String getcampo() {
    return campo;
  }
}
