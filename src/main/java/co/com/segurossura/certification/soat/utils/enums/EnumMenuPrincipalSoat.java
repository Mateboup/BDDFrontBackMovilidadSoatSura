package co.com.segurossura.certification.soat.utils.enums;

public enum EnumMenuPrincipalSoat {
  GESTION_POLIZAS("Gestión pólizas"),
  MENU_EXPEDICION("Expedición"),
  CONSULTA("Consulta");

  private final String dato;

  EnumMenuPrincipalSoat(String dato) {
    this.dato = dato;
  }

  public String getdato() {
    return dato;
  }
}
