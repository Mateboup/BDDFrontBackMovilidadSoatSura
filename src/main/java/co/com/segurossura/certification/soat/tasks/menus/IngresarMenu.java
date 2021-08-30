package co.com.segurossura.certification.soat.tasks.menus;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import co.com.segurossura.certification.soat.interactions.soatpresencial.CambiarFrame;
import co.com.segurossura.certification.soat.interactions.soatpresencial.EsperarTiempo;
import co.com.segurossura.certification.soat.utils.enums.EnumMenuPrincipalSoat;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class IngresarMenu implements Task {

  private final EnumMenuPrincipalSoat enumMenuPrincipal;
  private final EnumMenuPrincipalSoat enumSubMenuPrincipal;
  private final Target frameItem;
  private final Target frameContenido;
  private final Target item;

  public IngresarMenu(
      EnumMenuPrincipalSoat enumMenuPrincipal,
      EnumMenuPrincipalSoat enumSubMenuPrincipal,
      Target item,
      Target frameItem,
      Target frameContenido) {
    this.enumMenuPrincipal = enumMenuPrincipal;
    this.enumSubMenuPrincipal = enumSubMenuPrincipal;
    this.item = item;
    this.frameItem = frameItem;
    this.frameContenido = frameContenido;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(CambiarFrame.al(frameItem));
    actor.attemptsTo(Click.on(item.of(enumMenuPrincipal.getdato())));
    actor.attemptsTo(EsperarTiempo.explicito(1000));
    actor.attemptsTo(Click.on(item.of(enumSubMenuPrincipal.getdato())));
    actor.attemptsTo(CambiarFrame.al(frameContenido));
  }

  public static IngresarMenu al(
      EnumMenuPrincipalSoat enumMenuPrincipal,
      EnumMenuPrincipalSoat enumSubMenuPrincipal,
      Target item,
      Target frameItem,
      Target frameContenido) {
    return instrumented(
        IngresarMenu.class,
        enumMenuPrincipal,
        enumSubMenuPrincipal,
        item,
        frameItem,
        frameContenido);
  }
}
