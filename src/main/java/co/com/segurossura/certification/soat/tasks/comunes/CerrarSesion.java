package co.com.segurossura.certification.soat.tasks.comunes;

import static co.com.segurossura.certification.soat.userinterfaces.MenuPrincipalPage.BTN_CERRAR_SESION;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import co.com.segurossura.certification.soat.interactions.soatpresencial.CambiarContenidoDefecto;
import net.serenitybdd.markers.CanBeSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class CerrarSesion implements Task, CanBeSilent {

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(CambiarContenidoDefecto.al());
    actor.attemptsTo(Click.on(BTN_CERRAR_SESION));
    ManejoAlertas.aceptarAlerta();
  }

  @Override
  public boolean isSilent() {
    return true;
  }

  public static CerrarSesion aplicativoSoat() {
    return instrumented(CerrarSesion.class);
  }
}
