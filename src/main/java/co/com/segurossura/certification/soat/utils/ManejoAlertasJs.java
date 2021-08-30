package co.com.segurossura.certification.soat.utils;

import java.util.HashMap;
import java.util.Map;
import net.serenitybdd.core.webdriver.enhancers.BeforeAWebdriverScenario;
import net.thucydides.core.model.TestOutcome;
import net.thucydides.core.model.TestTag;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.webdriver.SupportedWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ManejoAlertasJs implements BeforeAWebdriverScenario {

  private static final Map<String, String> CAPABILITIES_SCENARIO = new HashMap<>();

  static {
    CAPABILITIES_SCENARIO.put("handlesAlerts", "true");
    CAPABILITIES_SCENARIO.put("supportsAlerts", "true");
    CAPABILITIES_SCENARIO.put("unexpectedAlertBehaviour", "accept");
  }

  @Override
  public DesiredCapabilities apply(
      EnvironmentVariables environmentVariables,
      SupportedWebDriver driver,
      TestOutcome testOutcome,
      DesiredCapabilities capabilities) {

    for (TestTag testTag : testOutcome.getAllTags()) {
      if ("CotizarSoatPorRetailValidandoCotizacion".equals(testTag.getName())) {
        return addCapabilities(capabilities);
      }
    }
    return capabilities;
  }

  private DesiredCapabilities addCapabilities(DesiredCapabilities capabilities) {
    CAPABILITIES_SCENARIO
        .entrySet()
        .stream()
        .forEach(key -> capabilities.setCapability(key.getKey(), key.getValue()));
    return capabilities;
  }
}
