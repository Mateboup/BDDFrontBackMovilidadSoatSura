package co.com.segurossura.certification.soat.userinterfaces;

import static org.openqa.selenium.By.id;

import net.serenitybdd.screenplay.targets.Target;

public final class ConsultasSoatPage {

  public static final Target RDB_POLIZA =
      Target.the("Radio buton de consultas").locatedBy("//input[@value='P']");
  public static final Target RDB_COTIZACION =
      Target.the("Radio buton de cotizacion").locatedBy("//input[@value='C']");
  public static final Target TXT_CONSULTA_SOAT_PLACA =
      Target.the("Consulta el Soat por placa").located(id("campo_Placa"));
  public static final Target BTN_BUSCAR =
      Target.the("Buscar el Soat por placa").located(id("boton_Consultar"));
  public static final Target LBL_NUMERO_POLIZA =
      Target.the("Capturar el numero de la poliza")
          .located(id("form_BusquedaPolizas:tabla_Polizas:0:j_id_id95"));

  public static final Target LBL_NUMERO_COTIZACION =
      Target.the("Capturar el numero de la cotizacion")
          .located(id("form_BusquedaPolizas:tabla_Cotizaciones:0:j_id_id178"));

  private ConsultasSoatPage() {}
}
