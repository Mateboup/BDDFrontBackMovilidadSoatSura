package co.com.segurossura.certification.soat.interactions.soatpresencial;

import static co.com.segurossura.certification.soat.userinterfaces.IniciarSesionPage.TXT_CONTRASENIA;
import static co.com.segurossura.certification.soat.userinterfaces.IniciarSesionPage.TXT_NOMBRE_DE_USUARIO;
import static co.com.segurossura.certification.soat.utils.enums.EnumCredencialesSoat.CANAL_RETAIL;
import static co.com.segurossura.certification.soat.utils.enums.EnumCredencialesSoat.CANAL_TRADICIONAL;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import co.com.segurossura.certification.soat.utils.Logger;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Enter;

public class IngresarCredenciales implements Interaction {

  private final String canal;
  private static final String TRADICIONAL = "tradicional";
  private static final String RETAIL = "retail";

  public IngresarCredenciales(String canal) {
    this.canal = canal;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {

    switch (canal) {
      case TRADICIONAL:
        actor.attemptsTo(
            Enter.theValue(CANAL_TRADICIONAL.getUsuario()).into(TXT_NOMBRE_DE_USUARIO),
            Enter.theValue(CANAL_TRADICIONAL.getContrasena()).into(TXT_CONTRASENIA));
        break;
      case RETAIL:
        actor.attemptsTo(
            Enter.theValue(CANAL_RETAIL.getUsuario()).into(TXT_NOMBRE_DE_USUARIO),
            Enter.theValue(CANAL_RETAIL.getContrasena()).into(TXT_CONTRASENIA));
        break;
      default:
        Logger.error(IngresarCredenciales.class.getName(), "Se ingresó un canal inexistente");
    }
  }

  public static IngresarCredenciales conElCanal(String canal) {
    return instrumented(IngresarCredenciales.class, canal);
  }
}
