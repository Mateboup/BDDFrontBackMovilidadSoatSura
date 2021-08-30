package co.com.segurossura.certification.soat.tasks.basedatos;

import static co.com.segurossura.certification.soat.utils.enums.EnumVariablesSesion.PLACA_VEHICULO;
import static co.com.segurossura.certification.soat.utils.enums.EnumVariablesSesion.RESULTADO_CONSULTA_OBTENIDO;
import static co.com.segurossura.certification.soat.utils.enums.basedatos.EnumColumna.NUMERO_PLACA;
import static co.com.segurossura.certification.soat.utils.enums.basedatos.EnumSentenciasSQL.CONSULTAR_NUMERO_COTIZACION;
import static co.com.segurossura.certification.soat.utils.enums.basedatos.EnumSentenciasSQL.CONSULTAR_REGISTRO_NUMERO_POLIZA;
import static co.com.segurossura.certification.soat.utils.enums.basedatos.EnumTabla.TABLA_SOAT_COTIZACIONES;
import static co.com.segurossura.certification.soat.utils.enums.basedatos.EnumTabla.TABLA_SOAT_POLIZAS;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import co.com.segurossura.certification.soat.interactions.basedatos.RetornoConsultaBD;

public final class ConsultarRegistro {

  private ConsultarRegistro() {}

  public static void numeroPoliza() {
    theActorInTheSpotlight()
        .attemptsTo(
            ConsultarRegistroBaseDatos.conLosDatos(
                CONSULTAR_REGISTRO_NUMERO_POLIZA.getSentencia(),
                TABLA_SOAT_POLIZAS.getTabla(),
                NUMERO_PLACA.getColumna(),
                theActorInTheSpotlight().recall(PLACA_VEHICULO.getVariableSesion())));
    theActorInTheSpotlight().attemptsTo(RetornoConsultaBD.conLosDatos(0, "NMPOLIZA"));
  }

  public static void cotizacion(String llave) {
    String valor;
    theActorInTheSpotlight()
        .attemptsTo(
            ConsultarRegistroBaseDatos.conLosDatos(
                CONSULTAR_NUMERO_COTIZACION.getSentencia(),
                TABLA_SOAT_COTIZACIONES.getTabla(),
                NUMERO_PLACA.getColumna(),
                theActorInTheSpotlight().recall(PLACA_VEHICULO.getVariableSesion())));
    theActorInTheSpotlight().attemptsTo(RetornoConsultaBD.conLosDatos(0, llave));
    valor = theActorInTheSpotlight().recall(RESULTADO_CONSULTA_OBTENIDO.getVariableSesion());
    theActorInTheSpotlight().remember(llave, valor);
  }
}
