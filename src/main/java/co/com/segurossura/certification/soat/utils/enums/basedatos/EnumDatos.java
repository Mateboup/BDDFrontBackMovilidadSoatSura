package co.com.segurossura.certification.soat.utils.enums.basedatos;

public enum EnumDatos {
  CONSUMO("SEQ_SOAT_CONSUMOS_RUNT.nextval,'"),
  CONSULTA("SEQ_SOAT_CONSULTAS_RUNT.nextval, '"),
  FECHA_SISTEMA("',SYSDATE,287,'");

  private final String dato;

  EnumDatos(String dato) {
    this.dato = dato;
  }

  public String getdato() {
    return dato;
  }
}
