package co.com.segurossura.certification.soat.interactions.soatpresencial;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.JavascriptExecutor;

public class EjecutarVentanaImprimir implements Interaction {

  public final String script;

  public EjecutarVentanaImprimir(String script) {
    this.script = script;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    JavascriptExecutor habilitarExpedicion =
        (JavascriptExecutor) BrowseTheWeb.as(actor).getDriver();
    habilitarExpedicion.executeScript(script);
  }

  public static EjecutarVentanaImprimir paraHabilitarExpedicion(String script) {
    return instrumented(EjecutarVentanaImprimir.class, script);
  }
}
