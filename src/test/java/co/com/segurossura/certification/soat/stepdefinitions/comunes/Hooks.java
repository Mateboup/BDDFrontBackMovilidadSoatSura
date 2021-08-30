package co.com.segurossura.certification.soat.stepdefinitions.comunes;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import co.com.segurossura.certification.soat.abilities.ConectarseALaBaseDeDatos;
import co.com.segurossura.certification.soat.tasks.basedatos.EliminarRegistroRuntPoliza;
import co.com.segurossura.certification.soat.tasks.comunes.CerrarSesion;
import io.cucumber.java.After;

public final class Hooks {

  @After(order = 1)
  public void cerrarConexion() {
    ConectarseALaBaseDeDatos.cerrarConexion();
  }

  @After
  public static void eliminarRegistrosPolizaExpedida() {
    EliminarRegistroRuntPoliza.conLosDatos();
  }

  @After
  public static void cerrarSesion() {
    theActorInTheSpotlight().attemptsTo(CerrarSesion.aplicativoSoat());
  }
}
