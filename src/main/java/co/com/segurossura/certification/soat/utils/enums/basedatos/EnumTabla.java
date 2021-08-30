package co.com.segurossura.certification.soat.utils.enums.basedatos;

public enum EnumTabla {
  TABLA_CONSUMO_RUNT("TSOAT_CONSUMOS_RUNT"),
  TABLA_CONSULTAS_RUNT("TSOAT_CONSULTAS_RUNT"),
  TABLA_SOAT_POLIZAS("Tsoat_Polizas"),
  TABLA_SOAT_SIIS("TSOAT_REPORTE_SIIS"),
  TABLA_SOAT_COTIZACIONES("tsoat_cotizacion_poliza");

  private final String tabla;

  EnumTabla(String tabla) {
    this.tabla = tabla;
  }

  public String getTabla() {
    return tabla;
  }
}
