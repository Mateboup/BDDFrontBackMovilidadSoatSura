package co.com.segurossura.certification.soat.tasks.basedatos;

import static co.com.segurossura.certification.soat.utils.enums.EnumVariablesSesion.CARACTERISTICAS_VEHICULO_JSON_DIGITAL;
import static co.com.segurossura.certification.soat.utils.enums.EnumVariablesSesion.CARACTERISTICAS_VEHICULO_JSON_PRESENCIAL;
import static co.com.segurossura.certification.soat.utils.enums.EnumVariablesSesion.PLACA_VEHICULO;
import static co.com.segurossura.certification.soat.utils.enums.basedatos.EnumColumna.VEHICULO_RUNT_CONSULTAS;
import static co.com.segurossura.certification.soat.utils.enums.basedatos.EnumColumna.VEHICULO_RUNT_CONSUMO;
import static co.com.segurossura.certification.soat.utils.enums.basedatos.EnumDatos.CONSULTA;
import static co.com.segurossura.certification.soat.utils.enums.basedatos.EnumDatos.CONSUMO;
import static co.com.segurossura.certification.soat.utils.enums.basedatos.EnumDatos.FECHA_SISTEMA;
import static co.com.segurossura.certification.soat.utils.enums.basedatos.EnumSentenciasSQL.INSERTAR_REGISTRO;
import static co.com.segurossura.certification.soat.utils.enums.basedatos.EnumTabla.TABLA_CONSULTAS_RUNT;
import static co.com.segurossura.certification.soat.utils.enums.basedatos.EnumTabla.TABLA_CONSUMO_RUNT;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import co.com.segurossura.certification.soat.utils.Cadenas;

public final class InsertarRegistro {

  private InsertarRegistro() {}

  public static void vehiculoRuntConsumo() {
    theActorInTheSpotlight()
        .attemptsTo(
            InsertarRegistroBaseDatos.conLosDatos(
                INSERTAR_REGISTRO.getSentencia(),
                TABLA_CONSUMO_RUNT.getTabla(),
                VEHICULO_RUNT_CONSUMO.getColumna(),
                Cadenas.concatenarCadenas(
                    CONSUMO.getdato(),
                    theActorInTheSpotlight().recall(PLACA_VEHICULO.getVariableSesion()),
                    FECHA_SISTEMA.getdato(),
                    theActorInTheSpotlight()
                        .recall(CARACTERISTICAS_VEHICULO_JSON_DIGITAL.getVariableSesion()),
                    "'")));
  }

  public static void vehiculoRuntConsultas() {
    theActorInTheSpotlight()
        .attemptsTo(
            InsertarRegistroBaseDatos.conLosDatos(
                INSERTAR_REGISTRO.getSentencia(),
                TABLA_CONSULTAS_RUNT.getTabla(),
                VEHICULO_RUNT_CONSULTAS.getColumna(),
                Cadenas.concatenarCadenas(
                    CONSULTA.getdato(),
                    theActorInTheSpotlight().recall(PLACA_VEHICULO.getVariableSesion()),
                    FECHA_SISTEMA.getdato(),
                    theActorInTheSpotlight()
                        .recall(CARACTERISTICAS_VEHICULO_JSON_PRESENCIAL.getVariableSesion()),
                    "','N'",
                    ",null,",
                    "SYSDATE+7,",
                    "null")));
  }
}
