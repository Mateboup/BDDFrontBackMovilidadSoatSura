package co.com.segurossura.certification.soat.tasks.comunes;

import static co.com.segurossura.certification.soat.utils.enums.EnumVariablesSesion.CARACTERISTICAS_VEHICULO_JSON_DIGITAL;
import static co.com.segurossura.certification.soat.utils.enums.EnumVariablesSesion.CARACTERISTICAS_VEHICULO_JSON_PRESENCIAL;
import static co.com.segurossura.certification.soat.utils.enums.EnumVariablesSesion.PLACA_VEHICULO;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import co.com.segurossura.certification.soat.models.builders.VehiculoRuntDigitalBuilder;
import co.com.segurossura.certification.soat.models.builders.VehiculoRuntPresencialBuilder;
import co.com.segurossura.certification.soat.models.comunes.VehiculoRuntDigital;
import co.com.segurossura.certification.soat.models.comunes.VehiculoRuntPresencial;
import co.com.segurossura.certification.soat.utils.Cadenas;
import co.com.segurossura.certification.soat.utils.enums.EnumSeparadores;
import java.util.ArrayList;
import java.util.Map;
import net.serenitybdd.markers.CanBeSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

public class ObtenerCaracteristicasVehiculo implements Task, CanBeSilent {

  private final String idFiltroCaracteristicasVehiculo;

  public ObtenerCaracteristicasVehiculo(Map<String, String> mapCaracteristicasVehiculo) {
    idFiltroCaracteristicasVehiculo =
        Cadenas.concatenarCadenas(
            EnumSeparadores.SEPARADOR_VIRGULILLA,
            new ArrayList<>(mapCaracteristicasVehiculo.values()));
  }

  public ObtenerCaracteristicasVehiculo(String idFiltroCaracteristicasVehiculo) {
    this.idFiltroCaracteristicasVehiculo = idFiltroCaracteristicasVehiculo;
  }

  public static Performable conLosDatos(Map<String, String> mapCaracteristicasVehiculo) {
    return instrumented(ObtenerCaracteristicasVehiculo.class, mapCaracteristicasVehiculo);
  }

  public static Performable conElFiltro(String idFiltroCaracteristicasVehiculo) {
    return instrumented(ObtenerCaracteristicasVehiculo.class, idFiltroCaracteristicasVehiculo);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    VehiculoRuntDigital vehiculoRuntDigital =
        VehiculoRuntDigitalBuilder.construirVehiculoRuntBD(idFiltroCaracteristicasVehiculo);
    VehiculoRuntPresencial vehiculoRuntPresencial =
        VehiculoRuntPresencialBuilder.construirVehiculoRuntPresencial(
            idFiltroCaracteristicasVehiculo);
    actor.remember(
        CARACTERISTICAS_VEHICULO_JSON_PRESENCIAL.getVariableSesion(),
        Cadenas.convertirObjetoJsonString(vehiculoRuntPresencial));
    actor.remember(
        CARACTERISTICAS_VEHICULO_JSON_DIGITAL.getVariableSesion(),
        Cadenas.convertirObjetoJsonString(vehiculoRuntDigital));
    actor.remember(PLACA_VEHICULO.getVariableSesion(), vehiculoRuntDigital.getNoPlaca());
  }

  @Override
  public boolean isSilent() {
    return true;
  }
}
