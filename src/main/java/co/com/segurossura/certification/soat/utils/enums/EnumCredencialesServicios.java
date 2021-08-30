package co.com.segurossura.certification.soat.utils.enums;

public enum EnumCredencialesServicios {
  SERVICIOS_SOAT("APISOATEXITO", "Suramericana2020*");

  private final String usuario;
  private final String contrasena;

  EnumCredencialesServicios(String usuario, String contrasena) {
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
