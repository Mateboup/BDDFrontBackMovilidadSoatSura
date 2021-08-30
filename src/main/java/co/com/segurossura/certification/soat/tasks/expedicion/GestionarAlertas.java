package co.com.segurossura.certification.soat.tasks.expedicion;

import static co.com.segurossura.certification.soat.userinterfaces.expedicion.ExpedirSoatPage.BTN_EXPEDIR_IMPRIMIR;
import static co.com.segurossura.certification.soat.utils.enums.EnumPaginas.EXPEDICION;
import static co.com.segurossura.certification.soat.utils.enums.EnumPaginas.PRINCIPAL;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

import co.com.segurossura.certification.soat.interactions.soatpresencial.CambiarFoco;
import co.com.segurossura.certification.soat.interactions.soatpresencial.EsperarTiempo;
import co.com.segurossura.certification.soat.tasks.comunes.ManejoAlertas;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

public class GestionarAlertas implements Task {

  @SneakyThrows
  @Override
  public <T extends Actor> void performAs(T actor) {
    ManejoAlertas.aceptarAlertaConTiempo(10);
    actor.attemptsTo(EsperarTiempo.explicito(12000));
    actor.attemptsTo(CambiarFoco.aLaPagina(PRINCIPAL.getpagina()));
    actor.attemptsTo(
        CambiarFoco.aLaPagina(EXPEDICION.getpagina()), Hit.the(Keys.ENTER).into("/html/body"));
    actor.attemptsTo(
        WaitUntil.the(BTN_EXPEDIR_IMPRIMIR, isClickable()).forNoMoreThan(20).seconds(),
        Click.on(BTN_EXPEDIR_IMPRIMIR));
    ManejoAlertas.aceptarAlertaConTiempo(10);
    ManejoAlertas.aceptarAlertaConTiempo(10);
    actor.attemptsTo(CambiarFoco.aLaPagina(PRINCIPAL.getpagina()));
  }

  public static GestionarAlertas paraExpedirTradicional() {
    return instrumented(GestionarAlertas.class);
  }
}
