package co.com.segurossura.certification.soat.interactions.soatpresencial;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import java.util.concurrent.TimeUnit;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class EsperarTiempo implements Interaction {

  private final int tiempo;

  public EsperarTiempo(int tiempo) {
    this.tiempo = tiempo;
  }

  @SneakyThrows
  @Override
  public <T extends Actor> void performAs(T actor) {
    TimeUnit.MILLISECONDS.sleep(tiempo);
  }

  public static EsperarTiempo explicito(int tiempo) {
    return instrumented(EsperarTiempo.class, tiempo);
  }
}
