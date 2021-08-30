package co.com.segurossura.certification.soat.stepdefinitions.cotizacion;

import static co.com.segurossura.certification.soat.utils.enums.EnumMensajeAlerta.COTIZAR_SOAT_SOAT_VIGENTE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;

import co.com.segurossura.certification.soat.questions.CapturarMensaje;
import io.cucumber.java.es.Entonces;

public class CotizarSoatVigenteFechaVigenciaMenorStepDefinition {
  @Entonces(
      "debería ver que un mensaje indicando que la fecha se ha empalmado con la de fin de vigencia")
  public void validarQueLaFechaSeEmpalma() {
    theActorInTheSpotlight()
        .should(
            seeThat(
                CapturarMensaje.alertaDesplegada(),
                containsString(COTIZAR_SOAT_SOAT_VIGENTE.getMensaje())));
  }
}
