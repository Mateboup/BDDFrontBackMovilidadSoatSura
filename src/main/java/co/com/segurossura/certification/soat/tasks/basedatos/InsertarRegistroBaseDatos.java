package co.com.segurossura.certification.soat.tasks.basedatos;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import co.com.segurossura.certification.soat.interactions.basedatos.InsertarDatos;
import co.com.segurossura.certification.soat.models.comunes.Parametros;
import net.serenitybdd.markers.CanBeSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class InsertarRegistroBaseDatos implements Task, CanBeSilent {

  Parametros parametros = new Parametros();

  public InsertarRegistroBaseDatos(String bundle, String tabla, String columna, String datos) {
    parametros.setBundle(bundle);
    parametros.setTabla(tabla);
    parametros.setColumna(columna);
    parametros.setDato(datos);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(InsertarDatos.conLosParametros(parametros));
  }

  public static InsertarRegistroBaseDatos conLosDatos(
      String bundle, String tabla, String columna, String datos) {
    return instrumented(InsertarRegistroBaseDatos.class, bundle, tabla, columna, datos);
  }

  @Override
  public boolean isSilent() {
    return true;
  }
}
