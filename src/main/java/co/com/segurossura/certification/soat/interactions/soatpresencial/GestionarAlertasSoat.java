package co.com.segurossura.certification.soat.interactions.soatpresencial;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import co.com.segurossura.certification.soat.tasks.expedicion.GestionarAlertas;
import co.com.segurossura.certification.soat.tasks.expedicion.GestionarAlertasImpresion;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class GestionarAlertasSoat implements Interaction {

  private final String canal;
  private static final String TRADICIONAL = "tradicional";
  private static final String RETAIL = "retail";

  public GestionarAlertasSoat(String canal) {
    this.canal = canal;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    if (canal.equals(TRADICIONAL)) {
      actor.attemptsTo(GestionarAlertas.paraExpedirTradicional());
    } else if (canal.equals(RETAIL)) {
      actor.attemptsTo(GestionarAlertasImpresion.paraExpedirRetail());
    }
  }

  public static GestionarAlertasSoat segunElCanal(String canal) {
    return instrumented(GestionarAlertasSoat.class, canal);
  }
}
