package co.com.segurossura.certification.soat.interactions.soatpresencial;

import static co.com.segurossura.certification.soat.tasks.menus.MenuExpedicion.ingresarGestionPoliza;
import static co.com.segurossura.certification.soat.userinterfaces.MenuPrincipalPage.RDB_TIPO_EXPEDICION;
import static co.com.segurossura.certification.soat.userinterfaces.MenuPrincipalPage.RDB_VEHICULO_SERVICIO_DIPLOMATICO;
import static co.com.segurossura.certification.soat.utils.enums.EnumTipoExpedicion.NACIONALES;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import co.com.segurossura.certification.soat.utils.Logger;
import lombok.SneakyThrows;
import net.serenitybdd.markers.CanBeSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class AccederVentanaCotizacion implements Interaction, CanBeSilent {

  private final String canal;
  private static final String TRADICIONAL = "tradicional";
  private static final String RETAIL = "retail";

  public AccederVentanaCotizacion(String canal) {
    this.canal = canal;
  }

  @SneakyThrows
  @Override
  public <T extends Actor> void performAs(T actor) {

    if (canal.equals(TRADICIONAL)) {
      ingresarGestionPoliza();
    } else if (canal.equals(RETAIL)) {
      ingresarGestionPoliza();
      actor.attemptsTo(
          WaitUntil.the(RDB_TIPO_EXPEDICION.of(NACIONALES.gettipoExpedicion()), isPresent()),
          WaitUntil.the(RDB_TIPO_EXPEDICION.of(NACIONALES.gettipoExpedicion()), isVisible()));
      actor.attemptsTo(
          Click.on(RDB_TIPO_EXPEDICION.of(NACIONALES.gettipoExpedicion())),
          EsperarTiempo.explicito(3000),
          Click.on(RDB_VEHICULO_SERVICIO_DIPLOMATICO));
    } else {
      Logger.error(
          IngresarCredenciales.class.getName(), "No se encontró canal para realizar la cotización");
    }
  }

  @Override
  public boolean isSilent() {
    return true;
  }

  public static AccederVentanaCotizacion porElCanal(String canal) {
    return instrumented(AccederVentanaCotizacion.class, canal);
  }
}
