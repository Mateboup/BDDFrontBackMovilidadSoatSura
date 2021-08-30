package co.com.segurossura.certification.soat.utils.enums;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class EnumNombreCanal {

  public static final Map<String, String> NOMBRE_CANAL;

  private EnumNombreCanal() {}

  static {
    Map<String, String> map = new HashMap<>();

    map.put("MARCELIANO ESCOLAR Y CIA LTDA", "73");
    map.put("REPUESTOS GOMEZ Y CIA LTDA", "80");
    map.put("DELIMA MARSH", "141");
    map.put("TERPEL EL POBLADO", "230");
    map.put("JAIME ENRIQUE VELASCO ACEVEDO", "271");
    map.put("EXITO BELLO", "190");
    map.put("EXITO LAURELES", "269");
    map.put("EXITO LAS AMERICAS", "270");
    map.put("SEGUROS EXITO COM", "295");
    map.put("DOMICILIOS EXITO", "297");
    map.put("CEDICEN EXITO OVIEDO", "298");
    map.put("CEDICEN EXITO CENTRO OVIEDO", "299");
    map.put("CORBETA ALKOMPRAR BELLO", "223");

    NOMBRE_CANAL = Collections.unmodifiableMap(map);
  }
}
