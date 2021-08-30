package co.com.segurossura.certification.soat.interactions.soatpresencial;

import static co.com.segurossura.certification.soat.userinterfaces.IniciarSesionPage.BTN_ACEPTAR;
import static co.com.segurossura.certification.soat.userinterfaces.IniciarSesionPage.BTN_CANAL;
import static co.com.segurossura.certification.soat.utils.enums.EnumNombreCanal.NOMBRE_CANAL;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import co.com.segurossura.certification.soat.utils.Logger;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

public class SeleccionarCanal implements Interaction {

  private final String canal;
  private static final String TRADICIONAL = "tradicional";
  private static final String RETAIL = "retail";

  public SeleccionarCanal(String canal) {
    this.canal = canal;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    switch (canal) {
      case TRADICIONAL:
        actor.attemptsTo(Click.on(BTN_CANAL.of(NOMBRE_CANAL.get("MARCELIANO ESCOLAR Y CIA LTDA"))));
        actor.attemptsTo(Click.on(BTN_ACEPTAR));
        break;
      case RETAIL:
        actor.attemptsTo(Click.on(BTN_CANAL.of(NOMBRE_CANAL.get("EXITO LAURELES"))));
        actor.attemptsTo(Click.on(BTN_ACEPTAR));
        break;
      default:
        Logger.error(SeleccionarCanal.class.getName(), "No se encontró el canal ingresado");
    }
  }

  public static SeleccionarCanal delegadoSoat(String canal) {
    return instrumented(SeleccionarCanal.class, canal);
  }
}
