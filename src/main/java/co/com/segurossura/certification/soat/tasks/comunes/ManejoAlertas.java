package co.com.segurossura.certification.soat.tasks.comunes;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class ManejoAlertas {

  private ManejoAlertas() {}

  public static void aceptarAlerta() {
    BrowseTheWeb.as(theActorInTheSpotlight()).getDriver().switchTo().alert().accept();
  }

  public static String obtenerTexto() {
    return BrowseTheWeb.as(theActorInTheSpotlight()).getDriver().switchTo().alert().getText();
  }

  public static void aceptarAlertaConTiempo(long tiempo) {
    WebDriverWait wait =
        new WebDriverWait(BrowseTheWeb.as(theActorInTheSpotlight()).getDriver(), tiempo);
    wait.until(ExpectedConditions.alertIsPresent()).accept();
  }
}
