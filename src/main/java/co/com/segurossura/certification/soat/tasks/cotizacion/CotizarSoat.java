package co.com.segurossura.certification.soat.tasks.cotizacion;

import static co.com.segurossura.certification.soat.userinterfaces.MenuPrincipalPage.BTN_COTIZAR;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import co.com.segurossura.certification.soat.interactions.soatpresencial.EsperarTiempo;
import co.com.segurossura.certification.soat.interactions.soatpresencial.RecorrerListaCampos;
import co.com.segurossura.certification.soat.interactions.soatpresencial.ValidarMensajesAlertas;
import co.com.segurossura.certification.soat.tasks.comunes.ConsultarPlaca;
import co.com.segurossura.certification.soat.tasks.comunes.ManejoAlertas;
import java.util.Map;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class CotizarSoat implements Task {

  private final Map<String, String> camposPendientes;

  public CotizarSoat(Map<String, String> camposPendientes) {
    this.camposPendientes = camposPendientes;
  }

  @Step("{0} cotiza el SOAT de un vehiculo diligenciando los campos correctamente")
  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(ConsultarPlaca.delVehiculo(), ValidarMensajesAlertas.campos(camposPendientes));
    ManejoAlertas.aceptarAlerta();
    actor.attemptsTo(
        RecorrerListaCampos.pendientes(camposPendientes),
        Click.on(BTN_COTIZAR),
        EsperarTiempo.explicito(5000));
  }

  public static CotizarSoat diligenciandoLosCampos(Map<String, String> camposPendientes) {
    return instrumented(CotizarSoat.class, camposPendientes);
  }
}
