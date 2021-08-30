package co.com.segurossura.certification.soat.interactions.soatpresencial;

import static co.com.segurossura.certification.soat.exceptions.MensajeAlertaError.MENSAJE_ALERTA_ERRADO;
import static co.com.segurossura.certification.soat.models.comunes.MensajesAlertas.LISTA_MENSAJES;
import static co.com.segurossura.certification.soat.models.comunes.MensajesAlertas.llenarListaMensajes;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.hamcrest.Matchers.containsString;

import co.com.segurossura.certification.soat.exceptions.MensajeAlertaError;
import co.com.segurossura.certification.soat.models.comunes.MensajesAlertas;
import co.com.segurossura.certification.soat.questions.CapturarMensajeCampos;
import java.util.Map;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.thucydides.core.annotations.Step;

public class ValidarMensajesAlertas implements Interaction {

  private final Map<String, String> camposPendientes;

  public ValidarMensajesAlertas(Map<String, String> camposPendientes) {
    this.camposPendientes = camposPendientes;
  }

  @Step("{0} valida los mensajes de alerta")
  @Override
  public <T extends Actor> void performAs(T actor) {
    llenarListaMensajes();
    for (MensajesAlertas mensajesAlertas : LISTA_MENSAJES) {
      String valor;
      valor = camposPendientes.get(mensajesAlertas.getCampo());
      if (valor != null) {
        actor.should(
            seeThat(
                    CapturarMensajeCampos.pendientes(),
                    containsString(mensajesAlertas.getEnumMensajeAlerta().getMensaje()))
                .orComplainWith(MensajeAlertaError.class, MENSAJE_ALERTA_ERRADO));
      }
    }
    LISTA_MENSAJES.clear();
  }

  public static ValidarMensajesAlertas campos(Map<String, String> camposPendientes) {
    return instrumented(ValidarMensajesAlertas.class, camposPendientes);
  }
}
