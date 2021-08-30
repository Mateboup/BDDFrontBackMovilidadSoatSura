package co.com.segurossura.certification.soat.tasks.comunes;

import static co.com.segurossura.certification.soat.userinterfaces.MenuPrincipalPage.TXT_FECHA_INICIO_VIGENCIA;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import co.com.segurossura.certification.soat.interactions.soatpresencial.EsperarTiempo;
import co.com.segurossura.certification.soat.utils.Fechas;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

public class IngresarFecha implements Task {

  private final String fechaInicioVigencia;

  public IngresarFecha(String fechaInicioVigencia) {
    this.fechaInicioVigencia = fechaInicioVigencia;
  }

  @Step("{0} ingresa la fecha de inicio de vigencia")
  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Enter.theValue(Fechas.fechaVigenciaConFormato(fechaInicioVigencia))
            .into(TXT_FECHA_INICIO_VIGENCIA)
            .thenHit(Keys.TAB),
        EsperarTiempo.explicito(5000));
  }

  public static IngresarFecha inicioVigencia(String fechaInicioVigencia) {
    return instrumented(IngresarFecha.class, fechaInicioVigencia);
  }
}
