package co.com.segurossura.certification.soat.utils.enums.basedatos;

public enum EnumColumna {
  PLACA_RUNT_DIGITAL("DSPLACAOVIN"),
  PLACA_RUNT_PRESENCIAL("DS_PLACA_O_VIN"),
  NUMERO_POLIZA("NMPOLIZA"),
  NUMERO_PLACA("CDPLACA"),
  VEHICULO_RUNT_CONSUMO("CDCONSULTA,DSPLACAOVIN,FECONSULTA,CDCANAL,DSRESPUESTARUNT"),
  VEHICULO_RUNT_CONSULTAS(
      "NMCONSULTA, DS_PLACA_O_VIN, FECHACONSULTA, CDCANAL, DS_DATOS_RETORNADOS_JSON, SNERROR, DSERROR, FEBAJA, TIPO_ERROR"),
  NUMERO_COTIZACION("nmcotizacion");

  private final String columna;

  EnumColumna(String columna) {
    this.columna = columna;
  }

  public String getColumna() {
    return columna;
  }
}
