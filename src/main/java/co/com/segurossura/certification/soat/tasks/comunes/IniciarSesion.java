package co.com.segurossura.certification.soat.tasks.comunes;

import static co.com.segurossura.certification.soat.userinterfaces.IniciarSesionPage.BTN_EMPLEADO;
import static co.com.segurossura.certification.soat.userinterfaces.IniciarSesionPage.BTN_INICIAR_SESION;
import static co.com.segurossura.certification.soat.utils.enums.EnumPaginas.PRINCIPAL;
import static co.com.segurossura.certification.soat.utils.enums.EnumVariablesSesion.CANAL;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import co.com.segurossura.certification.soat.interactions.soatpresencial.CambiarFoco;
import co.com.segurossura.certification.soat.interactions.soatpresencial.IngresarCredenciales;
import co.com.segurossura.certification.soat.interactions.soatpresencial.SeleccionarCanal;
import net.serenitybdd.markers.CanBeSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class IniciarSesion implements Task, CanBeSilent {

  private final String canal;

  public IniciarSesion(String canal) {
    this.canal = canal;
  }

  @Step("{0} inicia sesión en el aplicativo SOAT correctamente")
  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Click.on(BTN_EMPLEADO),
        IngresarCredenciales.conElCanal(canal),
        Click.on(BTN_INICIAR_SESION),
        SeleccionarCanal.delegadoSoat(canal),
        CambiarFoco.aLaPagina(PRINCIPAL.getpagina()));
    actor.remember(CANAL.getVariableSesion(), canal);
  }

  @Override
  public boolean isSilent() {
    return true;
  }

  public static IniciarSesion conEl(String canal) {
    return instrumented(IniciarSesion.class, canal);
  }
}
