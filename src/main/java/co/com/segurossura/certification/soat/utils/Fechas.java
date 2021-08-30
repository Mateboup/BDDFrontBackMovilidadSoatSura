package co.com.segurossura.certification.soat.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class Fechas {

  private Fechas() {
    throw new IllegalStateException();
  }

  public static String adicionarDiasFechaActual(int dias) {
    return LocalDate.now().plusDays(dias).toString();
  }

  public static String fechaVigenciaSoat(String fechaVigencia) {
    final String RETROACTIVA = "retroactiva";
    final String ANTICIPADA = "anticipada";
    final String ACTUAL = "actual";
    if (fechaVigencia.contains(RETROACTIVA)) {
      return LocalDate.now()
          .minusMonths(Integer.parseInt(fechaVigencia.replaceAll("\\D+", "")))
          .toString();
    } else if (fechaVigencia.contains(ANTICIPADA)) {
      return LocalDate.now()
          .plusMonths(Integer.parseInt(fechaVigencia.replaceAll("\\D+", "")))
          .toString();
    } else if (fechaVigencia.contains(ACTUAL)) {
      return LocalDate.now().toString();

    } else {
      Logger.error(Fechas.class.getName(), "El inicio de fecha de vigencia no es correcto");
    }
    return fechaVigencia;
  }

  public static String fechaVigenciaConFormato(String fechaVigencia) {
    DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    String fecha = fechaVigenciaSoat(fechaVigencia);
    LocalDate fechaFormato = LocalDate.parse(fecha);
    return fechaFormato.format(formatoFecha);
  }

  public static String agregarDiasFechaIngresada(String fecha) {
    return LocalDate.parse(fecha).plusDays(365).toString();
  }
}
