package co.com.segurossura.certification.soat.questions;

import static co.com.segurossura.certification.soat.tasks.comunes.ManejoAlertas.obtenerTexto;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CapturarMensajeCampos implements Question<String> {

  public static CapturarMensajeCampos pendientes() {
    return new CapturarMensajeCampos();
  }

  @Override
  public String answeredBy(Actor actor) {
    return obtenerTexto();
  }
}
