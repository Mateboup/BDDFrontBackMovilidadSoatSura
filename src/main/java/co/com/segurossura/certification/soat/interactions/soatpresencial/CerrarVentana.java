package co.com.segurossura.certification.soat.interactions.soatpresencial;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class CerrarVentana implements Interaction {

  @Override
  public <T extends Actor> void performAs(T actor) {

    BrowseTheWeb.as(actor).getDriver().close();
  }

  public static CerrarVentana cerrar() {
    return Tasks.instrumented(CerrarVentana.class);
  }
}
