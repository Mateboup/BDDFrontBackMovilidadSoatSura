package co.com.segurossura.certification.soat.tasks.comunes;

import static co.com.segurossura.certification.soat.tasks.menus.MenuExpedicion.ingresarConsulta;
import static co.com.segurossura.certification.soat.userinterfaces.ConsultasSoatPage.BTN_BUSCAR;
import static co.com.segurossura.certification.soat.userinterfaces.ConsultasSoatPage.TXT_CONSULTA_SOAT_PLACA;
import static co.com.segurossura.certification.soat.utils.enums.EnumVariablesSesion.PLACA_VEHICULO;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;

public class ConsultarSoat implements Task {

  private Target radioButon;

  public ConsultarSoat(Target radioButon) {
    this.radioButon = radioButon;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    ingresarConsulta();
    actor.attemptsTo(
        Click.on(radioButon),
        Enter.theValue(
                theActorInTheSpotlight().recall(PLACA_VEHICULO.getVariableSesion()).toString())
            .into(TXT_CONSULTA_SOAT_PLACA));
    actor.attemptsTo(Click.on(BTN_BUSCAR));
  }

  public static ConsultarSoat conLaPlaca(Target radioButon) {
    return instrumented(ConsultarSoat.class, radioButon);
  }
}
