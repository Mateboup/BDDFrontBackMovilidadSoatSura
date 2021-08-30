package co.com.segurossura.certification.soat.tasks.menus;

import static co.com.segurossura.certification.soat.userinterfaces.MenuPrincipalPage.FRM_CONTENIDO;
import static co.com.segurossura.certification.soat.userinterfaces.MenuPrincipalPage.FRM_MENU;
import static co.com.segurossura.certification.soat.userinterfaces.MenuPrincipalPage.MNM_SOAT;
import static co.com.segurossura.certification.soat.utils.enums.EnumMenuPrincipalSoat.CONSULTA;
import static co.com.segurossura.certification.soat.utils.enums.EnumMenuPrincipalSoat.GESTION_POLIZAS;
import static co.com.segurossura.certification.soat.utils.enums.EnumMenuPrincipalSoat.MENU_EXPEDICION;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public final class MenuExpedicion {

  private MenuExpedicion() {}

  public static void ingresarGestionPoliza() {
    theActorInTheSpotlight()
        .attemptsTo(
            IngresarMenu.al(MENU_EXPEDICION, GESTION_POLIZAS, MNM_SOAT, FRM_MENU, FRM_CONTENIDO));
  }

  public static void ingresarConsulta() {
    theActorInTheSpotlight()
        .attemptsTo(IngresarMenu.al(MENU_EXPEDICION, CONSULTA, MNM_SOAT, FRM_MENU, FRM_CONTENIDO));
  }
}
