package co.com.segurossura.certification.soat.tasks.basedatos;

import static co.com.segurossura.certification.soat.utils.enums.EnumVariablesSesion.PLACA_VEHICULO;
import static co.com.segurossura.certification.soat.utils.enums.EnumVariablesSesion.RESULTADO_CONSULTA_OBTENIDO;
import static co.com.segurossura.certification.soat.utils.enums.basedatos.EnumColumna.NUMERO_COTIZACION;
import static co.com.segurossura.certification.soat.utils.enums.basedatos.EnumColumna.NUMERO_POLIZA;
import static co.com.segurossura.certification.soat.utils.enums.basedatos.EnumColumna.PLACA_RUNT_DIGITAL;
import static co.com.segurossura.certification.soat.utils.enums.basedatos.EnumColumna.PLACA_RUNT_PRESENCIAL;
import static co.com.segurossura.certification.soat.utils.enums.basedatos.EnumSentenciasSQL.ELIMINAR_REGISTRO;
import static co.com.segurossura.certification.soat.utils.enums.basedatos.EnumTabla.TABLA_CONSULTAS_RUNT;
import static co.com.segurossura.certification.soat.utils.enums.basedatos.EnumTabla.TABLA_CONSUMO_RUNT;
import static co.com.segurossura.certification.soat.utils.enums.basedatos.EnumTabla.TABLA_SOAT_COTIZACIONES;
import static co.com.segurossura.certification.soat.utils.enums.basedatos.EnumTabla.TABLA_SOAT_POLIZAS;
import static co.com.segurossura.certification.soat.utils.enums.basedatos.EnumTabla.TABLA_SOAT_SIIS;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public final class EliminarRegistro {

  private EliminarRegistro() {}

  public static void vehiculoRuntDigital() {
    theActorInTheSpotlight()
        .attemptsTo(
            EliminarRegistroBaseDatos.conLosDatos(
                ELIMINAR_REGISTRO.getSentencia(),
                TABLA_CONSUMO_RUNT.getTabla(),
                PLACA_RUNT_DIGITAL.getColumna(),
                theActorInTheSpotlight().recall(PLACA_VEHICULO.getVariableSesion())));
  }

  public static void vehiculoRuntPresencial() {
    theActorInTheSpotlight()
        .attemptsTo(
            EliminarRegistroBaseDatos.conLosDatos(
                ELIMINAR_REGISTRO.getSentencia(),
                TABLA_CONSULTAS_RUNT.getTabla(),
                PLACA_RUNT_PRESENCIAL.getColumna(),
                theActorInTheSpotlight().recall(PLACA_VEHICULO.getVariableSesion())));
  }

  public static void polizaSoat() {
    theActorInTheSpotlight()
        .attemptsTo(
            EliminarRegistroBaseDatos.conLosDatos(
                ELIMINAR_REGISTRO.getSentencia(),
                TABLA_SOAT_POLIZAS.getTabla(),
                NUMERO_POLIZA.getColumna(),
                theActorInTheSpotlight().recall(RESULTADO_CONSULTA_OBTENIDO.getVariableSesion())));
  }

  public static void polizaSiis() {
    theActorInTheSpotlight()
        .attemptsTo(
            EliminarRegistroBaseDatos.conLosDatos(
                ELIMINAR_REGISTRO.getSentencia(),
                TABLA_SOAT_SIIS.getTabla(),
                NUMERO_POLIZA.getColumna(),
                theActorInTheSpotlight().recall(RESULTADO_CONSULTA_OBTENIDO.getVariableSesion())));
  }

  public static void cotizacionSoat(String llave) {
    theActorInTheSpotlight()
        .attemptsTo(
            EliminarRegistroBaseDatos.conLosDatos(
                ELIMINAR_REGISTRO.getSentencia(),
                TABLA_SOAT_COTIZACIONES.getTabla(),
                NUMERO_COTIZACION.getColumna(),
                theActorInTheSpotlight().recall(llave)));
  }
}
