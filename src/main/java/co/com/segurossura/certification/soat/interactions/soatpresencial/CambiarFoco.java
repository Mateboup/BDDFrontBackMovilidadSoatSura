package co.com.segurossura.certification.soat.interactions.soatpresencial;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class CambiarFoco implements Interaction {

  public final int pagina;

  public CambiarFoco(int pagina) {

    this.pagina = pagina;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {

    for (String winHandle : BrowseTheWeb.as(actor).getDriver().getWindowHandles()) {
      BrowseTheWeb.as(actor).getDriver().switchTo().window(winHandle);
    }
  }

  public static CambiarFoco aLaPagina(int pagina) {
    return instrumented(CambiarFoco.class, pagina);
  }
}
