package co.com.segurossura.certification.soat.tasks.expedicion;

import static co.com.segurossura.certification.soat.userinterfaces.expedicion.ExpedirSoatPage.LST_TIPO_DOCUMENTO;
import static co.com.segurossura.certification.soat.userinterfaces.expedicion.ExpedirSoatPage.RDB_AUTORIZACION_DATOS;
import static co.com.segurossura.certification.soat.userinterfaces.expedicion.ExpedirSoatPage.TXT_COD_VIN;
import static co.com.segurossura.certification.soat.userinterfaces.expedicion.ExpedirSoatPage.TXT_NUMERO_CELULAR;
import static co.com.segurossura.certification.soat.userinterfaces.expedicion.ExpedirSoatPage.TXT_NUMERO_DOCUMENTO;
import static co.com.segurossura.certification.soat.userinterfaces.expedicion.ExpedirSoatPage.TXT_OBERSVACIONES;
import static co.com.segurossura.certification.soat.utils.enums.EnumDatosTomador.CEDULA_TOMADOR;
import static co.com.segurossura.certification.soat.utils.enums.EnumDatosTomador.CELULAR_TOMADOR;
import static co.com.segurossura.certification.soat.utils.enums.EnumDatosTomador.CODIGO_VIN;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import co.com.segurossura.certification.soat.interactions.soatpresencial.EsperarTiempo;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

public class IngresarDatosFaltantes implements Task {

  @SneakyThrows
  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Enter.theValue(CODIGO_VIN.getDatosTomador()).into(TXT_COD_VIN),
        Click.on(LST_TIPO_DOCUMENTO),
        Enter.theValue(CEDULA_TOMADOR.getDatosTomador())
            .into(TXT_NUMERO_DOCUMENTO)
            .thenHit(Keys.TAB),
        Enter.theValue(CELULAR_TOMADOR.getDatosTomador()).into(TXT_NUMERO_CELULAR),
        Scroll.to(TXT_OBERSVACIONES),
        WaitUntil.the(RDB_AUTORIZACION_DATOS, isVisible()),
        Click.on(RDB_AUTORIZACION_DATOS),
        EsperarTiempo.explicito(5000));
  }

  public static IngresarDatosFaltantes paraExpedir() {
    return instrumented(IngresarDatosFaltantes.class);
  }
}
