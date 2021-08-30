package co.com.segurossura.certification.soat.tasks.comunes;

import static co.com.segurossura.certification.soat.userinterfaces.MenuPrincipalPage.BTN_CAMPO_PLACA;
import static co.com.segurossura.certification.soat.userinterfaces.MenuPrincipalPage.BTN_CONSULTA_PLACA;
import static co.com.segurossura.certification.soat.utils.enums.EnumVariablesSesion.PLACA_VEHICULO;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

public class ConsultarPlaca implements Task {

  @Step("{0} consulta la placa de un vehiculo correctamente")
  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        WaitUntil.the(BTN_CAMPO_PLACA, isPresent()), WaitUntil.the(BTN_CAMPO_PLACA, isVisible()));
    actor.attemptsTo(
        Enter.theValue(
                theActorInTheSpotlight().recall(PLACA_VEHICULO.getVariableSesion()).toString())
            .into(BTN_CAMPO_PLACA),
        Click.on(BTN_CONSULTA_PLACA));
  }

  public static ConsultarPlaca delVehiculo() {
    return instrumented(ConsultarPlaca.class);
  }
}
