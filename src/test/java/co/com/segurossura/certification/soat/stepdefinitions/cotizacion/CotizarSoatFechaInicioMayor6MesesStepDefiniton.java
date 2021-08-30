package co.com.segurossura.certification.soat.stepdefinitions.cotizacion;

import static co.com.segurossura.certification.soat.utils.enums.EnumMensajeAlerta.ERROR_EXPEDIR_FECHA_INICIO_MAYOR_6_MESES;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.containsString;

import co.com.segurossura.certification.soat.questions.CapturarMensaje;
import co.com.segurossura.certification.soat.tasks.comunes.ConsultarPlaca;
import co.com.segurossura.certification.soat.tasks.comunes.IngresarFecha;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

public class CotizarSoatFechaInicioMayor6MesesStepDefiniton {

  @Cuando("el cliente cotice el SOAT del vehiculo con fecha de inicio de vigencia {string}")
  public void cotizarSoat(String fechaInicioVigencia) {
    theActorInTheSpotlight().attemptsTo(ConsultarPlaca.delVehiculo());
    theActorInTheSpotlight().attemptsTo(IngresarFecha.inicioVigencia(fechaInicioVigencia));
  }

  @Entonces("debería ver un mensaje indicando que no es posible cotizar el soat")
  public void validarMensajeAlerta() {
    theActorInTheSpotlight()
        .should(
            seeThat(
                CapturarMensaje.alertaDesplegada(),
                containsString(ERROR_EXPEDIR_FECHA_INICIO_MAYOR_6_MESES.getMensaje())));
  }
}
