package co.com.segurossura.certification.soat.interactions.soatpresencial;

import static co.com.segurossura.certification.soat.userinterfaces.expedicion.ExpedirSoatPage.BTN_EXPEDIR;
import static co.com.segurossura.certification.soat.userinterfaces.expedicion.ExpedirSoatPage.BTN_GUARDAR_COTIZACION;
import static co.com.segurossura.certification.soat.userinterfaces.expedicion.ExpedirSoatPage.RDB_EXPEDIR;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import co.com.segurossura.certification.soat.utils.Logger;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

public class ExpedirSegunCanal implements Interaction {

  private final String canal;
  private static final String TRADICIONAL = "tradicional";
  private static final String RETAIL = "retail";

  public ExpedirSegunCanal(String canal) {
    this.canal = canal;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    switch (canal) {
      case TRADICIONAL:
        actor.attemptsTo(Click.on(RDB_EXPEDIR));
        actor.attemptsTo(EsperarTiempo.explicito(5000));
        actor.attemptsTo(Click.on(BTN_EXPEDIR));
        actor.attemptsTo(EsperarTiempo.explicito(5000));
        break;
      case RETAIL:
        actor.attemptsTo(Click.on(BTN_GUARDAR_COTIZACION));
        actor.attemptsTo(EsperarTiempo.explicito(5000));
        break;
      default:
        Logger.error(SeleccionarCanal.class.getName(), "No se encontró el canal ingresado");
    }
  }

  public static ExpedirSegunCanal delegadoSoat(String canal) {
    return instrumented(ExpedirSegunCanal.class, canal);
  }
}
