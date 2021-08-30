package co.com.segurossura.certification.soat.tasks.comunes;

import static co.com.segurossura.certification.soat.userinterfaces.MenuPrincipalPage.BTN_COTIZAR;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import co.com.segurossura.certification.soat.interactions.soatpresencial.EsperarTiempo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class CotizarTarifaSoat implements Task {

  private final String fechaInicioVigencia;

  public CotizarTarifaSoat(String fechaInicioVigencia) {
    this.fechaInicioVigencia = fechaInicioVigencia;
  }

  @Step("{0} cotiza el SOAT de un vehiculo correctamente")
  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        ConsultarPlaca.delVehiculo(),
        IngresarFecha.inicioVigencia(fechaInicioVigencia),
        Click.on(BTN_COTIZAR),
        EsperarTiempo.explicito(5000));
  }

  public static CotizarTarifaSoat paraElVehiculo(String fechaInicioVigencia) {
    return instrumented(CotizarTarifaSoat.class, fechaInicioVigencia);
  }
}
