package co.com.segurossura.certification.soat.questions.expedicion;

import static co.com.segurossura.certification.soat.userinterfaces.ConsultasSoatPage.LBL_NUMERO_POLIZA;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class VerificarSoat implements Question<String> {

  @Override
  public String answeredBy(Actor actor) {
    return Text.of(LBL_NUMERO_POLIZA).viewedBy(actor).asString();
  }

  public static VerificarSoat numeroPoliza() {
    return new VerificarSoat();
  }
}
