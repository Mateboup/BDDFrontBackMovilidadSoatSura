package co.com.segurossura.certification.soat.models.builders;

import co.com.segurossura.certification.soat.models.comunes.VehiculoRuntPresencial;
import co.com.segurossura.certification.soat.utils.UtilidadesCsv;
import co.com.segurossura.certification.soat.utils.enums.EnumNombresCsv;
import java.util.Map;

public final class VehiculoRuntPresencialBuilder {

  private VehiculoRuntPresencialBuilder() {}

  public static VehiculoRuntPresencial construirVehiculoRuntPresencial(String idFiltro) {
    Map<String, String> mapCaracteristicasVehiculoPresencial =
        UtilidadesCsv.obtenerPrimerDatoPrueba(
            EnumNombresCsv.CARACTERISTICAS_VEHICULO_PRESENCIAL.getNombre(), idFiltro);
    return VehiculoRuntPresencial.builder()
        .placa(mapCaracteristicasVehiculoPresencial.get("placa"))
        .idLinea(mapCaracteristicasVehiculoPresencial.get("idLinea"))
        .linea(mapCaracteristicasVehiculoPresencial.get("linea"))
        .idMarca(mapCaracteristicasVehiculoPresencial.get("idMarca"))
        .marca(mapCaracteristicasVehiculoPresencial.get("marca"))
        .idClaseVehiculo(mapCaracteristicasVehiculoPresencial.get("idClaseVehiculo"))
        .tipoServicio(mapCaracteristicasVehiculoPresencial.get("tipoServicio"))
        .servicio(mapCaracteristicasVehiculoPresencial.get("servicio"))
        .modelo(mapCaracteristicasVehiculoPresencial.get("modelo"))
        .cilindraje(mapCaracteristicasVehiculoPresencial.get("cilindraje"))
        .numeroPasajeros(mapCaracteristicasVehiculoPresencial.get("numeroPasajeros"))
        .capacidadCarga(mapCaracteristicasVehiculoPresencial.get("capacidadCarga"))
        .numeroChasis(mapCaracteristicasVehiculoPresencial.get("numeroChasis"))
        .numeroMotor(mapCaracteristicasVehiculoPresencial.get("numeroMotor"))
        .paisOrigenId(mapCaracteristicasVehiculoPresencial.get("paisOrigenId"))
        .idTipoCombustible(mapCaracteristicasVehiculoPresencial.get("idTipoCombustible"))
        .tipoCombustible(mapCaracteristicasVehiculoPresencial.get("tipoCombustible"))
        .build();
  }
}
