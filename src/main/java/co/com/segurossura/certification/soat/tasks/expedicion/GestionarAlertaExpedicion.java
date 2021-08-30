package co.com.segurossura.certification.soat.tasks.expedicion;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import co.com.segurossura.certification.soat.tasks.comunes.ManejoAlertas;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class GestionarAlertaExpedicion implements Interaction {

  private final String canal;

  public GestionarAlertaExpedicion(String canal) {
    this.canal = canal;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {

    if ("retail".equals(canal)) {
      ManejoAlertas.aceptarAlerta();
    }
  }

  public static GestionarAlertaExpedicion paraFechaActual(String canal) {
    return instrumented(GestionarAlertaExpedicion.class, canal);
  }
}
