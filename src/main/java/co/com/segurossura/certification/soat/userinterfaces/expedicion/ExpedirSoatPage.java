package co.com.segurossura.certification.soat.userinterfaces.expedicion;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public final class ExpedirSoatPage {

  public static final Target TXT_COD_VIN =
      Target.the("Digitar codigo VIN").locatedBy(".columnaContenido>input[id='campo_Vin']");
  public static final Target TXT_FECHA_INICIO_VIGENCIA =
      Target.the("Digitar codigo VIN").locatedBy(".columnaContenido>input[id='campo_Vin']");
  public static final Target LST_TIPO_DOCUMENTO =
      Target.the("Tipo de documento")
          .locatedBy(".columnaContenido>select[id=lista_TipoDocTomador]>option[value=C]");
  public static final Target TXT_NUMERO_DOCUMENTO =
      Target.the("Numero documento").located(By.id("campo_NumIdTomador"));
  public static final Target TXT_NUMERO_CELULAR =
      Target.the("Numero celular")
          .locatedBy(".columnaContenido>input[id=campo_TelefonoMovilTomador]");
  public static final Target RDB_AUTORIZACION_DATOS =
      Target.the("Autorizacion datos")
          .locatedBy("//*[@id='radioSNMensajeHabeasData']//input[@value='S']");
  public static final Target TXT_OBERSVACIONES =
      Target.the("Observaciones ").located(By.id("formExpedicion:j_id_id383"));
  public static final Target RDB_EXPEDIR =
      Target.the("Seleccionar Expedir ")
          .locatedBy("#radio_Accion > tbody > tr > td > label > input");
  public static final Target BTN_EXPEDIR =
      Target.the("Boton paraExpedir ").located(By.id("formExpedicion:boton_Enviar"));
  public static final Target BTN_EXPEDIR_IMPRIMIR =
      Target.the("Boton Expedir Imprimir").locatedBy("//input[@value='Expedir']");
  public static final Target BTN_GUARDAR_COTIZACION =
      Target.the("Boton para guardar cotizacion")
          .located(By.id("formExpedicion:boton_GuardarCotizacion"));
  public static final Target BTN_IMPRIMIR_COTIZACION =
      Target.the("Boton para imprimir cotizacion").located(By.id("boton_imprimir_cotizacion"));
  public static final Target BTN_OK = Target.the("Boton OK").located(By.id("alertify-ok"));
  public static final Target BTN_IMPRIMIR =
      Target.the("Boton Imprimir").located(By.xpath("//*[text()='Imprimir']"));
  public static final Target BTN_FINALIZAR =
      Target.the("Boton Finalizar").locatedBy("//input[@value='Finalizar']");

  private ExpedirSoatPage() {}
}
