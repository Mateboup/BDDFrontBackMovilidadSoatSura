package co.com.segurossura.certification.soat.stepdefinitions.expedicion;

import static co.com.segurossura.certification.soat.exceptions.NumeroPolizaErrada.NUMERO_POLIZA_ERRADO;
import static co.com.segurossura.certification.soat.utils.enums.EnumVariablesSesion.RESULTADO_CONSULTA_OBTENIDO;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

import co.com.segurossura.certification.soat.exceptions.NumeroPolizaErrada;
import co.com.segurossura.certification.soat.interactions.soatpresencial.AccederVentanaCotizacion;
import co.com.segurossura.certification.soat.interactions.soatpresencial.ExpedirSegunCanal;
import co.com.segurossura.certification.soat.interactions.soatpresencial.GestionarAlertasSoat;
import co.com.segurossura.certification.soat.questions.expedicion.VerificarSoat;
import co.com.segurossura.certification.soat.tasks.basedatos.ConsultarRegistro;
import co.com.segurossura.certification.soat.tasks.basedatos.EliminarRegistroRuntPoliza;
import co.com.segurossura.certification.soat.tasks.basedatos.InsertarRegistro;
import co.com.segurossura.certification.soat.tasks.comunes.ConsultarSoat;
import co.com.segurossura.certification.soat.tasks.comunes.IniciarSesion;
import co.com.segurossura.certification.soat.tasks.comunes.ObtenerCaracteristicasVehiculo;
import co.com.segurossura.certification.soat.tasks.expedicion.IngresarDatosFaltantes;
import co.com.segurossura.certification.soat.userinterfaces.ConsultasSoatPage;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

public class ExpedirSoatStepDefinition {

  @Dado(
      "que un cliente desea realizar una expedicion de un {string} en el aplicativo SOAT por el canal {string}")
  public void queUnClienteDeseaRealizarUnaExpedicionDeUnEnElAplicativoSOATPorElCanal(
      String claseVehiculo, String canal) {
    theActorInTheSpotlight().attemptsTo(ObtenerCaracteristicasVehiculo.conElFiltro(claseVehiculo));
    theActorInTheSpotlight().attemptsTo(EliminarRegistroRuntPoliza.conLosDatos());
    InsertarRegistro.vehiculoRuntConsultas();
    InsertarRegistro.vehiculoRuntConsumo();
    theActorInTheSpotlight().attemptsTo(IniciarSesion.conEl(canal));
    theActorInTheSpotlight().attemptsTo(AccederVentanaCotizacion.porElCanal(canal));
  }

  @Cuando("el cliente expida el SOAT del vehiculo {string}")
  public void elClienteExpidaElSOATDelVehiculo(String canal) {
    theActorInTheSpotlight().attemptsTo(IngresarDatosFaltantes.paraExpedir());
    theActorInTheSpotlight().attemptsTo(ExpedirSegunCanal.delegadoSoat(canal));
    theActorInTheSpotlight().attemptsTo(GestionarAlertasSoat.segunElCanal(canal));
    theActorInTheSpotlight().attemptsTo(ConsultarSoat.conLaPlaca(ConsultasSoatPage.RDB_POLIZA));
    ConsultarRegistro.numeroPoliza();
  }

  @Entonces("deberia ver que el SOAT se expide de manera exitosa")
  public void deberiaVerQueElSOATSeExpideDeManeraExitosa() {
    theActorInTheSpotlight()
        .should(
            seeThat(
                    VerificarSoat.numeroPoliza(),
                    equalTo(
                        theActorInTheSpotlight()
                            .recall(RESULTADO_CONSULTA_OBTENIDO.getVariableSesion())))
                .orComplainWith(NumeroPolizaErrada.class, NUMERO_POLIZA_ERRADO));
  }
}
