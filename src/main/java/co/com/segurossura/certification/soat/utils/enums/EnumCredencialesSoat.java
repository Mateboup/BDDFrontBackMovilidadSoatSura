package co.com.segurossura.certification.soat.utils.enums;

public enum EnumCredencialesSoat {
  CANAL_TRADICIONAL("crm09", "Crm09*Crm09*"),
  CANAL_RETAIL("crm07", "crm07crm07");

  private final String usuario;
  private final String contrasena;

  EnumCredencialesSoat(String usuario, String contrasena) {
    this.usuario = usuario;
    this.contrasena = contrasena;
  }

  public String getUsuario() {
    return usuario;
  }

  public String getContrasena() {
    return contrasena;
  }
}
