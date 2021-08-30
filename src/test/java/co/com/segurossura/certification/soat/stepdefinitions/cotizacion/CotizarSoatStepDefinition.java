package co.com.segurossura.certification.soat.stepdefinitions.cotizacion;

import static co.com.segurossura.certification.soat.exceptions.ValorTarifaError.VALOR_TARIFA_ERRADO;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

import co.com.segurossura.certification.soat.exceptions.ValorTarifaError;
import co.com.segurossura.certification.soat.interactions.soatpresencial.AccederVentanaCotizacion;
import co.com.segurossura.certification.soat.questions.ValorTotalCotizacion;
import co.com.segurossura.certification.soat.tasks.basedatos.EliminarRegistroRuntPoliza;
import co.com.segurossura.certification.soat.tasks.basedatos.InsertarRegistro;
import co.com.segurossura.certification.soat.tasks.comunes.CotizarTarifaSoat;
import co.com.segurossura.certification.soat.tasks.comunes.IniciarSesion;
import co.com.segurossura.certification.soat.tasks.comunes.ObtenerCaracteristicasVehiculo;
import co.com.segurossura.certification.soat.tasks.cotizacion.CotizarSoat;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import java.util.Map;

public class CotizarSoatStepDefinition {

  @Dado("que un cliente desea realizar una cotizacion de un vehiculo por el canal {string}")
  public void iniciarSesion(String canal, Map<String, String> mapCaracteristicasVehiculo) {
    theActorInTheSpotlight()
        .attemptsTo(ObtenerCaracteristicasVehiculo.conLosDatos(mapCaracteristicasVehiculo));
    theActorInTheSpotlight().attemptsTo(EliminarRegistroRuntPoliza.conLosDatos());
    InsertarRegistro.vehiculoRuntConsultas();
    theActorInTheSpotlight().attemptsTo(IniciarSesion.conEl(canal));
    theActorInTheSpotlight().attemptsTo(AccederVentanaCotizacion.porElCanal(canal));
  }

  @Cuando("cotice el SOAT del vehiculo con fecha de inicio de vigencia {string}")
  public void cotizarSoatConFechaDeInicioDeVigencia(String fechaInicioVigencia) {
    theActorInTheSpotlight().attemptsTo(CotizarTarifaSoat.paraElVehiculo(fechaInicioVigencia));
  }

  @Cuando("cotice el SOAT del vehiculo diligenciando los siguientes campos")
  public void cotizarSoatCamposPendientes(Map<String, String> camposPendientes) {
    theActorInTheSpotlight().attemptsTo(CotizarSoat.diligenciandoLosCampos(camposPendientes));
  }

  @Entonces("debería ver que la tarifa total es igual a {double}")
  public void validarTarifa(Double tarifaSoat) {
    theActorInTheSpotlight()
        .should(
            seeThat(ValorTotalCotizacion.delSoat(), equalTo(tarifaSoat))
                .orComplainWith(ValorTarifaError.class, VALOR_TARIFA_ERRADO));
  }
}
