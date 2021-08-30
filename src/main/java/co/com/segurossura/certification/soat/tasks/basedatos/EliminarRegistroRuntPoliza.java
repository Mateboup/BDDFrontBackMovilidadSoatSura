package co.com.segurossura.certification.soat.tasks.basedatos;

import static co.com.segurossura.certification.soat.utils.enums.EnumVariablesSesion.CD_TOMADOR;
import static co.com.segurossura.certification.soat.utils.enums.EnumVariablesSesion.CD_VEHICULO;
import static co.com.segurossura.certification.soat.utils.enums.EnumVariablesSesion.NUMERO_COTIZACION;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.markers.CanBeSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class EliminarRegistroRuntPoliza implements Task, CanBeSilent {

  @Override
  public <T extends Actor> void performAs(T actor) {
    ConsultarRegistro.numeroPoliza();
    EliminarRegistro.polizaSoat();
    EliminarRegistro.polizaSiis();
    ConsultarRegistro.cotizacion(CD_TOMADOR.getVariableSesion());
    ConsultarRegistro.cotizacion(CD_VEHICULO.getVariableSesion());
    ConsultarRegistro.cotizacion(NUMERO_COTIZACION.getVariableSesion());
    EliminarRegistro.vehiculoRuntDigital();
    EliminarRegistro.vehiculoRuntPresencial();
    EliminarRegistro.cotizacionSoat(CD_TOMADOR.getVariableSesion());
    EliminarRegistro.cotizacionSoat(CD_VEHICULO.getVariableSesion());
    EliminarRegistro.cotizacionSoat(NUMERO_COTIZACION.getVariableSesion());
  }

  @Override
  public boolean isSilent() {
    return true;
  }

  public static EliminarRegistroRuntPoliza conLosDatos() {
    return instrumented(EliminarRegistroRuntPoliza.class);
  }
}
