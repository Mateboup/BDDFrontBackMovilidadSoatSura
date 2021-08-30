package co.com.segurossura.certification.soat.interactions.soatpresencial;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;

public class CambiarFrame implements Interaction {

  private final Target frame;

  public CambiarFrame(Target frame) {
    this.frame = frame;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    BrowseTheWeb.as(theActorInTheSpotlight())
        .getDriver()
        .switchTo()
        .defaultContent()
        .switchTo()
        .parentFrame()
        .switchTo()
        .frame(frame.resolveFor(theActorInTheSpotlight()));
  }

  public static CambiarFrame al(Target frame) {
    return instrumented(CambiarFrame.class, frame);
  }
}
