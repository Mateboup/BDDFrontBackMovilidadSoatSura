package co.com.segurossura.certification.soat.utils.enums;

public enum EnumMensajeAlerta {
  CLASE("La clase que vino desde el runt no es valida"),
  TIPO_SERVICIO("El servicio que vino desde el runt no es valido"),
  MARCA("La marca que vino desde el runt no es valida"),
  LINEA("La linea que vino desde el runt no es valida"),
  MODELO("El modelo que vino desde el runt no es valido"),
  CILINDRAJE("El cilindraje que vino desde el runt no es valido"),
  TIPO_COMBUSTIBLE("El Tipo Combustible que vino desde el runt no es valido"),
  ERROR_EXPEDIR_FECHA_ACTUAL(
      "No es posible expedir una póliza con inicio de vigencia anterior o igual al día de hoy"),
  ERROR_EXPEDIR_FECHA_INICIO_MAYOR_6_MESES(
      "No es posible el inicio de vigencia de la póliza más allá de los próximos 6 meses"),
  COTIZAR_SOAT_SOAT_VIGENTE(
      "Atención: la fecha Inicio de Vigencia se ha cambiado para empalmarla con una póliza que el cliente tiene vigente, solo será posible cambiar la fecha a una futura, pero no hacia atrás.");

  private final String mensaje;

  EnumMensajeAlerta(String mensaje) {
    this.mensaje = mensaje;
  }

  public String getMensaje() {
    return mensaje;
  }
}
