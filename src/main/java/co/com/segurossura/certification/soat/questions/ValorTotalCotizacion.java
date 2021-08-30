package co.com.segurossura.certification.soat.questions;

import static co.com.segurossura.certification.soat.userinterfaces.MenuPrincipalPage.TXT_COTIZACION;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValorTotalCotizacion implements Question<Double> {

  public static ValorTotalCotizacion delSoat() {
    return new ValorTotalCotizacion();
  }

  @Override
  public Double answeredBy(Actor actor) {
    return Double.parseDouble(TXT_COTIZACION.resolveFor(actor).getValue().replaceAll("[,.]", ""));
  }
}
