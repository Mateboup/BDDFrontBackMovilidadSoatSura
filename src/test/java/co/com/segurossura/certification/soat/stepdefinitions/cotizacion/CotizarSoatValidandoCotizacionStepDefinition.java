package co.com.segurossura.certification.soat.stepdefinitions.cotizacion;

import static co.com.segurossura.certification.soat.exceptions.NumeroCotizacionErrado.NUMERO_COTIZACION_ERRADO;
import static co.com.segurossura.certification.soat.utils.enums.EnumVariablesSesion.NUMERO_COTIZACION;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

import co.com.segurossura.certification.soat.exceptions.NumeroCotizacionErrado;
import co.com.segurossura.certification.soat.interactions.soatpresencial.AccederVentanaCotizacion;
import co.com.segurossura.certification.soat.interactions.soatpresencial.ExpedirSegunCanal;
import co.com.segurossura.certification.soat.questions.NumeroCotizacion;
import co.com.segurossura.certification.soat.tasks.basedatos.ConsultarRegistro;
import co.com.segurossura.certification.soat.tasks.basedatos.EliminarRegistroRuntPoliza;
import co.com.segurossura.certification.soat.tasks.basedatos.InsertarRegistro;
import co.com.segurossura.certification.soat.tasks.comunes.ConsultarSoat;
import co.com.segurossura.certification.soat.tasks.comunes.CotizarTarifaSoat;
import co.com.segurossura.certification.soat.tasks.comunes.IniciarSesion;
import co.com.segurossura.certification.soat.tasks.comunes.ObtenerCaracteristicasVehiculo;
import co.com.segurossura.certification.soat.tasks.expedicion.GestionarAlertaExpedicion;
import co.com.segurossura.certification.soat.tasks.expedicion.IngresarDatosFaltantes;
import co.com.segurossura.certification.soat.userinterfaces.ConsultasSoatPage;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

public class CotizarSoatValidandoCotizacionStepDefinition {

  @Dado("que un cliente desea realizar una cotizacion de un {string} por el canal {string}")
  public void iniciarSesion(String claseVehiculo, String canal) {
    theActorInTheSpotlight().attemptsTo(ObtenerCaracteristicasVehiculo.conElFiltro(claseVehiculo));
    theActorInTheSpotlight().attemptsTo(EliminarRegistroRuntPoliza.conLosDatos());
    InsertarRegistro.vehiculoRuntConsultas();
    theActorInTheSpotlight().attemptsTo(IniciarSesion.conEl(canal));
    theActorInTheSpotlight().attemptsTo(AccederVentanaCotizacion.porElCanal(canal));
    ConsultarRegistro.cotizacion(NUMERO_COTIZACION.getVariableSesion());
  }

  @Cuando(
      "cotice el SOAT del vehiculo por el canal {string} con fecha de inicio de vigencia {string} y guarde la cotizacion")
  public void cotizarSoatPorCanalRetail(String canal, String fechaIniciVigencia) {
    theActorInTheSpotlight().attemptsTo(CotizarTarifaSoat.paraElVehiculo(fechaIniciVigencia));
    theActorInTheSpotlight().attemptsTo(IngresarDatosFaltantes.paraExpedir());
    theActorInTheSpotlight().attemptsTo(ExpedirSegunCanal.delegadoSoat(canal));
    theActorInTheSpotlight().attemptsTo(GestionarAlertaExpedicion.paraFechaActual(canal));
    theActorInTheSpotlight().attemptsTo(ConsultarSoat.conLaPlaca(ConsultasSoatPage.RDB_COTIZACION));
    ConsultarRegistro.cotizacion(NUMERO_COTIZACION.getVariableSesion());
  }

  @Entonces("deberia validar que se guarde la cotizacion de forma correcta")
  public void validarCotizacion() {
    theActorInTheSpotlight()
        .should(
            seeThat(
                    NumeroCotizacion.guardado(),
                    equalTo(theActorInTheSpotlight().recall(NUMERO_COTIZACION.getVariableSesion())))
                .orComplainWith(NumeroCotizacionErrado.class, NUMERO_COTIZACION_ERRADO));
  }
}
