package co.com.segurossura.certification.soat.questions;

import co.com.segurossura.certification.soat.tasks.comunes.ManejoAlertas;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CapturarMensaje implements Question<String> {

  public static CapturarMensaje alertaDesplegada() {
    return new CapturarMensaje();
  }

  @Override
  public String answeredBy(Actor actor) {
    String msgAlerta = ManejoAlertas.obtenerTexto();
    ManejoAlertas.aceptarAlerta();
    return msgAlerta;
  }
}
