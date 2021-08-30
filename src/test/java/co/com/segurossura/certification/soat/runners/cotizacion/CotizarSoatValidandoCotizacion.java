package co.com.segurossura.certification.soat.runners.cotizacion;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@CucumberOptions(
    features = "src/test/resources/features/cotizacion/cotizar_soat_validando_cotizacion.feature",
    glue = "co.com.segurossura.certification.soat.stepdefinitions")
@RunWith(CucumberWithSerenity.class)
public class CotizarSoatValidandoCotizacion {}
