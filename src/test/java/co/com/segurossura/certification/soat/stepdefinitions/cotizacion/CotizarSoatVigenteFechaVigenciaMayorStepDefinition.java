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
import co.com.segurossura.certification.soat.tasks.comunes.AgregarDatosRequestPoliza;
import co.com.segurossura.certification.soat.tasks.comunes.AgregarInicioVigencia;
import co.com.segurossura.certification.soat.tasks.comunes.CotizarTarifaSoat;
import co.com.segurossura.certification.soat.tasks.comunes.IniciarSesion;
import co.com.segurossura.certification.soat.tasks.comunes.ObtenerCaracteristicasVehiculo;
import co.com.segurossura.certification.soat.tasks.expedicion.ExpedirPolizaDigital;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;

public class CotizarSoatVigenteFechaVigenciaMayorStepDefinition {

  @Dado("que un cliente {string} tiene un {string}")
  public void registrarVehiculoRunt(String tipoRiesgo, String claseVehiculo) {
    theActorInTheSpotlight().attemptsTo(ObtenerCaracteristicasVehiculo.conElFiltro(claseVehiculo));
    theActorInTheSpotlight().attemptsTo(EliminarRegistroRuntPoliza.conLosDatos());
    InsertarRegistro.vehiculoRuntConsumo();
    InsertarRegistro.vehiculoRuntConsultas();
    theActorInTheSpotlight().attemptsTo(AgregarDatosRequestPoliza.conTipoRiesgo(tipoRiesgo));
  }

  @Y("tiene un soat con fecha de inicio de vigencia {string}")
  public void expedirSoat(String fechaInicioVigencia) {
    theActorInTheSpotlight().attemptsTo(AgregarInicioVigencia.conFecha(fechaInicioVigencia));
    theActorInTheSpotlight().attemptsTo(ExpedirPolizaDigital.paraElVehiculo());
  }

  @Cuando(
      "cotice el SOAT del vehiculo por el canal {string} con fecha de inicio de vigencia {string}")
  public void cotizarSoat(String canal, String fechaInicioVigencia) {
    theActorInTheSpotlight().attemptsTo(IniciarSesion.conEl(canal));
    theActorInTheSpotlight().attemptsTo(AccederVentanaCotizacion.porElCanal(canal));
    theActorInTheSpotlight().attemptsTo(CotizarTarifaSoat.paraElVehiculo(fechaInicioVigencia));
  }

  @Entonces("debería ver que la tarifa del SOAT es {double}")
  public void validarTarifa(Double tarifaSoat) {
    theActorInTheSpotlight()
        .should(
            seeThat(ValorTotalCotizacion.delSoat(), equalTo(tarifaSoat))
                .orComplainWith(ValorTarifaError.class, VALOR_TARIFA_ERRADO));
  }
}
