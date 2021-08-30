package co.com.segurossura.certification.soat.stepdefinitions.expedicion;

import static co.com.segurossura.certification.soat.utils.enums.EnumMensajeAlerta.ERROR_EXPEDIR_FECHA_ACTUAL;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.containsString;

import co.com.segurossura.certification.soat.interactions.soatpresencial.AccederVentanaCotizacion;
import co.com.segurossura.certification.soat.interactions.soatpresencial.ExpedirSegunCanal;
import co.com.segurossura.certification.soat.questions.CapturarMensaje;
import co.com.segurossura.certification.soat.tasks.basedatos.EliminarRegistroRuntPoliza;
import co.com.segurossura.certification.soat.tasks.basedatos.InsertarRegistro;
import co.com.segurossura.certification.soat.tasks.comunes.CotizarTarifaSoat;
import co.com.segurossura.certification.soat.tasks.comunes.IniciarSesion;
import co.com.segurossura.certification.soat.tasks.comunes.ObtenerCaracteristicasVehiculo;
import co.com.segurossura.certification.soat.tasks.expedicion.IngresarDatosFaltantes;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;

public class ExpedirSoatFechaActualStepDefinition {
  @Dado("que una persona desea expedir el soat de un {string} por el canal {string}")
  public void iniciarSesion(String claseVehiculo, String canal) {
    theActorInTheSpotlight().attemptsTo(ObtenerCaracteristicasVehiculo.conElFiltro(claseVehiculo));
    theActorInTheSpotlight().attemptsTo(EliminarRegistroRuntPoliza.conLosDatos());
    InsertarRegistro.vehiculoRuntConsultas();
    theActorInTheSpotlight().attemptsTo(IniciarSesion.conEl(canal));
    theActorInTheSpotlight().attemptsTo(AccederVentanaCotizacion.porElCanal(canal));
  }

  @Y("la fecha de inicio de vigencia sea {string}")
  public void cotizarSoat(String fechaInicioVigencia) {
    theActorInTheSpotlight().attemptsTo(CotizarTarifaSoat.paraElVehiculo(fechaInicioVigencia));
  }

  @Cuando("el cliente expide el Soat por el canal {string}")
  public void expedirSoat(String canal) {
    theActorInTheSpotlight().attemptsTo(IngresarDatosFaltantes.paraExpedir());
    theActorInTheSpotlight().attemptsTo(ExpedirSegunCanal.delegadoSoat(canal));
  }

  @Entonces("debería ver un mensaje indicando que no puede expedir el soat en la fecha actual")
  public void valdidarMensajeErroAlExpedirEnLaFechaActual() {
    theActorInTheSpotlight()
        .should(
            seeThat(
                CapturarMensaje.alertaDesplegada(),
                containsString(ERROR_EXPEDIR_FECHA_ACTUAL.getMensaje())));
  }
}
