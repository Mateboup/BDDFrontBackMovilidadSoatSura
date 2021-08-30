package co.com.segurossura.certification.soat.interactions.soatpresencial;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class CambiarContenidoDefecto implements Interaction {

  @Override
  public <T extends Actor> void performAs(T actor) {
    BrowseTheWeb.as(actor).getDriver().switchTo().defaultContent();
  }

  public static CambiarContenidoDefecto al() {
    return instrumented(CambiarContenidoDefecto.class);
  }
}
