package co.com.segurossura.certification.soat.userinterfaces;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public final class IniciarSesionPage {

  public static final Target BTN_EMPLEADO = Target.the("Empleado").located(id("itemTabEmpleado"));
  public static final Target TXT_NOMBRE_DE_USUARIO =
      Target.the("Nombre de usuario").locatedBy(("//*[@id='tabEmpleado']/div[2]/input"));
  public static final Target TXT_CONTRASENIA =
      Target.the("Contraseña").located(xpath("//*[@id='tabEmpleado']/div[3]/input"));
  public static final Target BTN_INICIAR_SESION =
      Target.the("Iniciar sesion").located(xpath("//*[@id='tabEmpleado']//div/div/input"));
  public static final Target BTN_CANAL =
      Target.the("Escoger canal").locatedBy("//div[@class='textoGeneral']//input[@value='{0}']");
  public static final Target BTN_ACEPTAR =
      Target.the("Boton aceptar").located(By.name("areaBoton_r2_c2"));

  private IniciarSesionPage() {}
}
