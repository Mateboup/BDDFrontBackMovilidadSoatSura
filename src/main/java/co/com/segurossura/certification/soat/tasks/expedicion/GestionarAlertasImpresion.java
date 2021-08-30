package co.com.segurossura.certification.soat.tasks.expedicion;


import co.com.segurossura.certification.soat.interactions.soatpresencial.CambiarFoco;
import co.com.segurossura.certification.soat.interactions.soatpresencial.CerrarVentana;
import co.com.segurossura.certification.soat.interactions.soatpresencial.EjecutarVentanaImprimir;
import co.com.segurossura.certification.soat.interactions.soatpresencial.EsperarTiempo;
import co.com.segurossura.certification.soat.interactions.soatpresencial.CambiarFrame;
import co.com.segurossura.certification.soat.tasks.comunes.ManejoAlertas;
import co.com.segurossura.certification.soat.utils.ScriptConstantes;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static co.com.segurossura.certification.soat.userinterfaces.MenuPrincipalPage.FRM_CONTENIDO;
import static co.com.segurossura.certification.soat.userinterfaces.expedicion.ExpedirSoatPage.BTN_IMPRIMIR_COTIZACION;
import static co.com.segurossura.certification.soat.userinterfaces.expedicion.ExpedirSoatPage.RDB_EXPEDIR;
import static co.com.segurossura.certification.soat.userinterfaces.expedicion.ExpedirSoatPage.BTN_EXPEDIR;
import static co.com.segurossura.certification.soat.userinterfaces.expedicion.ExpedirSoatPage.BTN_EXPEDIR_IMPRIMIR;
import static co.com.segurossura.certification.soat.userinterfaces.expedicion.ExpedirSoatPage.BTN_FINALIZAR;
import static co.com.segurossura.certification.soat.utils.enums.EnumPaginas.EXPEDICION;
import static co.com.segurossura.certification.soat.utils.enums.EnumPaginas.PRINCIPAL;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class GestionarAlertasImpresion implements Task {

  @SneakyThrows
  @Override
  public <T extends Actor> void performAs(T actor) {
    ManejoAlertas.aceptarAlerta();
    actor.attemptsTo(
        Click.on(BTN_IMPRIMIR_COTIZACION),
        EsperarTiempo.explicito(12000),
        CambiarFoco.aLaPagina(EXPEDICION.getpagina()));
    actor.attemptsTo(Hit.the(Keys.ENTER).into("/html/body"));
    actor.attemptsTo(
        EjecutarVentanaImprimir.paraHabilitarExpedicion(ScriptConstantes.ACTIVAR_EXPEDIR));
    actor.attemptsTo(CambiarFoco.aLaPagina(EXPEDICION.getpagina()), CerrarVentana.cerrar());
    actor.attemptsTo(
        CambiarFoco.aLaPagina(PRINCIPAL.getpagina()),
        CambiarFrame.al(FRM_CONTENIDO),
        WaitUntil.the(RDB_EXPEDIR, isEnabled()).forNoMoreThan(10).seconds(),
        Click.on(RDB_EXPEDIR),
        Click.on(BTN_EXPEDIR));
    ManejoAlertas.aceptarAlertaConTiempo(10);
    actor.attemptsTo(
        EsperarTiempo.explicito(12000),
        CambiarFoco.aLaPagina(PRINCIPAL.getpagina()),
        CambiarFoco.aLaPagina(EXPEDICION.getpagina()),
        Hit.the(Keys.ENTER).into("/html/body"),
        WaitUntil.the(BTN_EXPEDIR_IMPRIMIR, isClickable()).forNoMoreThan(20).seconds(),
        Click.on(BTN_EXPEDIR_IMPRIMIR));
    ManejoAlertas.aceptarAlertaConTiempo(10);
    ManejoAlertas.aceptarAlertaConTiempo(10);
    actor.attemptsTo(
        CambiarFoco.aLaPagina(EXPEDICION.getpagina()),
        WaitUntil.the(BTN_FINALIZAR, isVisible()).forNoMoreThan(20).seconds(),
        Click.on(BTN_FINALIZAR),
        EsperarTiempo.explicito(500),
        CambiarFoco.aLaPagina(PRINCIPAL.getpagina()));
  }

  public static GestionarAlertasImpresion paraExpedirRetail() {
    return instrumented(GestionarAlertasImpresion.class);
  }
}
