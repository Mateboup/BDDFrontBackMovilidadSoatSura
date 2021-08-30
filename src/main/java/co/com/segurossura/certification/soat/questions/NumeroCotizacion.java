package co.com.segurossura.certification.soat.questions;

import static co.com.segurossura.certification.soat.userinterfaces.ConsultasSoatPage.LBL_NUMERO_COTIZACION;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class NumeroCotizacion implements Question<String> {

  @Override
  public String answeredBy(Actor actor) {
    return LBL_NUMERO_COTIZACION.resolveFor(actor).getText();
  }

  public static NumeroCotizacion guardado() {
    return new NumeroCotizacion();
  }
}
