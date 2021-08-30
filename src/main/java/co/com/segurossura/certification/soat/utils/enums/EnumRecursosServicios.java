package co.com.segurossura.certification.soat.utils.enums;

public enum EnumRecursosServicios {
  EXPEDICION("/polizas");

  private final String recurso;

  EnumRecursosServicios(String recurso) {
    this.recurso = recurso;
  }

  public String getRecurso() {
    return recurso;
  }
}
