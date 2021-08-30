package co.com.segurossura.certification.soat.userinterfaces;

import static org.openqa.selenium.By.id;

import net.serenitybdd.screenplay.targets.Target;

public final class MenuPrincipalPage {

  public static final Target FRM_MENU = Target.the("Frame menu").located(id("iframeMenu"));
  public static final Target MNM_SOAT =
      Target.the("Menu para seleccionar funciones expedicion")
          .locatedBy("//div[@class='slideMenuText']//a[@title='{0}']");
  public static final Target BTN_CAMPO_PLACA =
      Target.the("Placa vehículo").located(id("campo_Placa"));
  public static final Target BTN_CONSULTA_PLACA =
      Target.the("Boton consulta placa vehículo").located(id("idConsultaPlaca"));
  public static final Target BTN_COTIZAR =
      Target.the("Boton cotizar").located(id("formExpedicion:boton_Cotizar"));
  public static final Target FRM_CONTENIDO =
      Target.the("Frame contenido").located(id("iframeContenido"));
  public static final Target BTN_CERRAR_SESION =
      Target.the("Cierre de sesion").locatedBy("//table//a[contains(text(),'Cerra Sesión')]");
  public static final Target TXT_COTIZACION =
      Target.the("Valor cotización").located(id("campo_PrimaTotalMasRunt"));
  public static final Target RDB_TIPO_EXPEDICION =
      Target.the("Tipo expedición").locatedBy("//label[contains(text(),'{0}')]//input");
  public static final Target RDB_VEHICULO_SERVICIO_DIPLOMATICO =
      Target.the("Tipo expedición").locatedBy("//input[@name='radioIsDiplomatico'][@value='N']");
  public static final Target FILTRO_MARCA =
      Target.the("Filtro marca").located(id("idBotonFiltroMarca"));
  public static final Target FILTRO_LINEA =
      Target.the("Filtro linea").located(id("idBotonFiltroLinea"));
  public static final Target MARCA = Target.the("Marca").located(id("lista_Marcas"));
  public static final Target LINEA = Target.the("Linea").located(id("lista_Lineas"));
  public static final Target CLASE = Target.the("Clase").located(id("lista_Clases"));
  public static final Target SERVICIO = Target.the("Servicio").located(id("lista_Servicios"));
  public static final Target MODELO = Target.the("Modelo").located(id("campo_Modelo"));
  public static final Target TIPO_COMBUSTIBLE =
      Target.the("Tipo Combustible").located(id("lista_TipoCombustion"));
  public static final Target CILINDRAJE = Target.the("Cilindraje").located(id("campo_Cilindraje"));
  public static final Target CAPACIDAD_CARGA =
      Target.the("Capacidad carga").located(id("campo_CapCarga"));
  public static final Target TXT_FECHA_INICIO_VIGENCIA =
      Target.the("Fecha inicio vigencia").locatedBy("//input[@name='campo_FechaInicioVigencia']");

  private MenuPrincipalPage() {}
}
