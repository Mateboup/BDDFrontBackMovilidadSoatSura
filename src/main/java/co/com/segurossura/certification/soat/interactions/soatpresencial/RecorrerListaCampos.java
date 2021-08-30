package co.com.segurossura.certification.soat.interactions.soatpresencial;

import static co.com.segurossura.certification.soat.models.comunes.CamposCotizacion.LISTA_CAMPOS;
import static co.com.segurossura.certification.soat.userinterfaces.MenuPrincipalPage.FILTRO_LINEA;
import static co.com.segurossura.certification.soat.userinterfaces.MenuPrincipalPage.FILTRO_MARCA;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import co.com.segurossura.certification.soat.models.comunes.CamposCotizacion;
import co.com.segurossura.certification.soat.utils.Logger;
import java.util.Map;
import net.serenitybdd.markers.CanBeSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

public class RecorrerListaCampos implements Interaction, CanBeSilent {

  private final Map<String, String> camposPendientes;

  public RecorrerListaCampos(Map<String, String> camposPendientes) {
    this.camposPendientes = camposPendientes;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    CamposCotizacion.llenarListaCampos();
    for (CamposCotizacion camposCotizacion : LISTA_CAMPOS) {
      String valor;
      valor = camposPendientes.get(camposCotizacion.getNombre());
      if (valor != null) {
        switch (camposCotizacion.getTipoCampo()) {
          case TEXTO:
            actor.attemptsTo(
                Click.on(camposCotizacion.getTarget()),
                Enter.theValue(valor).into(camposCotizacion.getTarget()));
            break;
          case SELECTOR:
            actor.attemptsTo(
                SelectFromOptions.byVisibleText(valor).from(camposCotizacion.getTarget()));
            break;
          case SELECTOR_FILTRO_MARCA:
            actor.attemptsTo(Click.on(FILTRO_MARCA));
            actor.attemptsTo(EsperarTiempo.explicito(2000));
            actor.attemptsTo(
                SelectFromOptions.byVisibleText(valor).from(camposCotizacion.getTarget()));
            break;
          case SELECTOR_FILTRO_LINEA:
            actor.attemptsTo(Click.on(FILTRO_LINEA));
            actor.attemptsTo(EsperarTiempo.explicito(2000));
            actor.attemptsTo(
                SelectFromOptions.byVisibleText(valor).from(camposCotizacion.getTarget()));
            break;
          default:
            Logger.info(RecorrerListaCampos.class.getName(), "El campo ingresado no existe");
        }
      }
    }
    LISTA_CAMPOS.clear();
  }

  @Override
  public boolean isSilent() {
    return true;
  }

  public static RecorrerListaCampos pendientes(Map<String, String> camposPendientes) {
    return instrumented(RecorrerListaCampos.class, camposPendientes);
  }
}
