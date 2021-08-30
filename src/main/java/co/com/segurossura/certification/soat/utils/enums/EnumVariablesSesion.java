package co.com.segurossura.certification.soat.utils.enums;

public enum EnumVariablesSesion {
  REQUEST_EXPEDICION("requestExpedicion"),
  RESULTADO_CONSULTA_OBTENIDO("numeroPoliza"),
  CARACTERISTICAS_VEHICULO_JSON_DIGITAL("caracteristicasVehículoEstructuraJsonDigital"),
  CARACTERISTICAS_VEHICULO_JSON_PRESENCIAL("caracteristicasVehículoEstructuraJsonPresencial"),
  PLACA_VEHICULO("Placa del vehículo"),
  CANAL("canal"),
  RETORNO_CONSULTA_BD("retornoConsultaBaseDatos"),
  NUMERO_COTIZACION("NMCOTIZACION"),
  CD_VEHICULO("CDVEHICULO"),
  CD_TOMADOR("CDTOMADOR");

  private final String variableSesion;

  EnumVariablesSesion(String variableSesion) {
    this.variableSesion = variableSesion;
  }

  public String getVariableSesion() {
    return variableSesion;
  }
}
