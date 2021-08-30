package co.com.segurossura.certification.soat.models.comunes;

import static co.com.segurossura.certification.soat.userinterfaces.MenuPrincipalPage.CILINDRAJE;
import static co.com.segurossura.certification.soat.userinterfaces.MenuPrincipalPage.CLASE;
import static co.com.segurossura.certification.soat.userinterfaces.MenuPrincipalPage.LINEA;
import static co.com.segurossura.certification.soat.userinterfaces.MenuPrincipalPage.MARCA;
import static co.com.segurossura.certification.soat.userinterfaces.MenuPrincipalPage.MODELO;
import static co.com.segurossura.certification.soat.userinterfaces.MenuPrincipalPage.SERVICIO;
import static co.com.segurossura.certification.soat.userinterfaces.MenuPrincipalPage.TIPO_COMBUSTIBLE;
import static co.com.segurossura.certification.soat.utils.enums.EnumTipoCampo.SELECTOR;
import static co.com.segurossura.certification.soat.utils.enums.EnumTipoCampo.SELECTOR_FILTRO_LINEA;
import static co.com.segurossura.certification.soat.utils.enums.EnumTipoCampo.SELECTOR_FILTRO_MARCA;
import static co.com.segurossura.certification.soat.utils.enums.EnumTipoCampo.TEXTO;

import co.com.segurossura.certification.soat.utils.enums.EnumTipoCampo;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import net.serenitybdd.screenplay.targets.Target;

@Getter
public class CamposCotizacion {

  public final String nombre;
  public final EnumTipoCampo tipoCampo;
  public final Target target;
  public static final List<CamposCotizacion> LISTA_CAMPOS = new ArrayList<>();

  public CamposCotizacion(String nombre, EnumTipoCampo tipoCampo, Target target) {
    this.nombre = nombre;
    this.tipoCampo = tipoCampo;
    this.target = target;
  }

  public static void llenarListaCampos() {
    LISTA_CAMPOS.add(new CamposCotizacion("Id ClaseVehiculo", SELECTOR, CLASE));
    LISTA_CAMPOS.add(new CamposCotizacion("Tipo Combustible", SELECTOR, TIPO_COMBUSTIBLE));
    LISTA_CAMPOS.add(new CamposCotizacion("Marca", SELECTOR_FILTRO_MARCA, MARCA));
    LISTA_CAMPOS.add(new CamposCotizacion("Linea", SELECTOR_FILTRO_LINEA, LINEA));
    LISTA_CAMPOS.add(new CamposCotizacion("Tipo Servicio", SELECTOR, SERVICIO));
    LISTA_CAMPOS.add(new CamposCotizacion("Modelo", TEXTO, MODELO));
    LISTA_CAMPOS.add(new CamposCotizacion("Cilindraje", TEXTO, CILINDRAJE));
  }
}
