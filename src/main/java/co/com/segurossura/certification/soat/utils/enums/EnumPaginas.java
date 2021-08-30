package co.com.segurossura.certification.soat.utils.enums;

public enum EnumPaginas {
  PRINCIPAL(1),
  EXPEDICION(2);

  private final int pagina;

  EnumPaginas(int pagina) {
    this.pagina = pagina;
  }

  public int getpagina() {
    return pagina;
  }
}
