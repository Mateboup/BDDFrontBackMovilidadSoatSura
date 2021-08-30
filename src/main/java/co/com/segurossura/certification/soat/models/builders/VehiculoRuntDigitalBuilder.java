package co.com.segurossura.certification.soat.models.builders;

import co.com.segurossura.certification.soat.models.comunes.VehiculoRuntDigital;
import co.com.segurossura.certification.soat.utils.UtilidadesCsv;
import co.com.segurossura.certification.soat.utils.enums.EnumNombresCsv;
import java.util.Map;

public final class VehiculoRuntDigitalBuilder {

  private VehiculoRuntDigitalBuilder() {}

  public static VehiculoRuntDigital construirVehiculoRuntBD(String idFiltro) {
    Map<String, String> mapCaracteristicasVehiculoDigital =
        UtilidadesCsv.obtenerPrimerDatoPrueba(
            EnumNombresCsv.CARACTERISTICAS_VEHICULO_DIGITAL.getNombre(), idFiltro);
    return VehiculoRuntDigital.builder()
        .idTipoServicio(mapCaracteristicasVehiculoDigital.get("idTipoServicio"))
        .idClaseVehiculo(mapCaracteristicasVehiculoDigital.get("idClaseVehiculo"))
        .idMarca(mapCaracteristicasVehiculoDigital.get("idMarca"))
        .idLinea(mapCaracteristicasVehiculoDigital.get("idLinea"))
        .modelo(mapCaracteristicasVehiculoDigital.get("modelo"))
        .noMotor(mapCaracteristicasVehiculoDigital.get("noMotor"))
        .noChasis(mapCaracteristicasVehiculoDigital.get("noChasis"))
        .noVin(mapCaracteristicasVehiculoDigital.get("noVin"))
        .cilindraje(mapCaracteristicasVehiculoDigital.get("cilindraje"))
        .noPlaca(mapCaracteristicasVehiculoDigital.get("noPlaca"))
        .capacidadPasajerosSentados(
            mapCaracteristicasVehiculoDigital.get("capacidadPasajerosSentados"))
        .datosTecnicos(
            DatosTecnicosBuilder.construirDatosTecnicosVehiculo(
                mapCaracteristicasVehiculoDigital.get("datosTecnicos")))
        .build();
  }
}
