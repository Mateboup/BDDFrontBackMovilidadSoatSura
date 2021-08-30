package co.com.segurossura.certification.soat.stepdefinitions.comunes;

import static co.com.segurossura.certification.soat.abilities.ConectarseALaBaseDeDatos.configurarBaseDeDatosConLosParametros;
import static co.com.segurossura.certification.soat.utils.enums.EnumCredencialesBaseDatos.BASE_DATOS_SOAT;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import co.com.segurossura.certification.soat.abilities.ConectarseALaBaseDeDatos;
import io.cucumber.java.Before;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;
import org.openqa.selenium.WebDriver;

public class Setup {

  EnvironmentVariables environmentVariable;
  String urlBaseApi;
  String urlBaseFront;

  @Managed(driver = "chrome")
  public WebDriver driver;

  @Before(order = 0)
  public void configurarUrlBase() {
    final String RUTA_URL = "restapi.baseurl";
    environmentVariable = Injectors.getInjector().getInstance(EnvironmentVariables.class);
    urlBaseApi = EnvironmentSpecificConfiguration.from(environmentVariable).getProperty(RUTA_URL);
  }

  @Before(order = 0)
  public void configurarUrlFront() {
    final String RUTA_URL_FRONT = "url.baseurl";
    environmentVariable = Injectors.getInjector().getInstance(EnvironmentVariables.class);
    urlBaseFront =
        EnvironmentSpecificConfiguration.from(environmentVariable).getProperty(RUTA_URL_FRONT);
  }

  @Before(order = 1)
  public void configurarActor() {
    OnStage.setTheStage(new OnlineCast());
    theActorCalled("René").whoCan(CallAnApi.at(urlBaseApi));
    theActorCalled("René").can(BrowseTheWeb.with(driver));
    theActorInTheSpotlight().wasAbleTo(Open.url(urlBaseFront));
  }

  @Before
  public void inicializacionBaseDatos() {
    ConectarseALaBaseDeDatos.as(
            theActorInTheSpotlight()
                .whoCan(
                    configurarBaseDeDatosConLosParametros(
                        BASE_DATOS_SOAT.getUrlBaseDatos(),
                        BASE_DATOS_SOAT.getUsuario(),
                        BASE_DATOS_SOAT.getContrasena())))
        .realizarConexionBaseDatos();
  }
}
