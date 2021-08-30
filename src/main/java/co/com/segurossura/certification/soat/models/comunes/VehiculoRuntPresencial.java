package co.com.segurossura.certification.soat.models.comunes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import lombok.Builder;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "placa",
  "idLinea",
  "linea",
  "idMarca",
  "marca",
  "idClaseVehiculo",
  "tipoServicio",
  "servicio",
  "modelo",
  "cilindraje",
  "numeroPasajeros",
  "capacidadCarga",
  "numeroChasis",
  "numeroMotor",
  "paisOrigenId",
  "idTipoCombustible",
  "tipoCombustible"
})
@Builder
@Getter
public class VehiculoRuntPresencial implements Serializable {
  @JsonProperty("placa")
  public String placa;

  @JsonProperty("idLinea")
  public String idLinea;

  @JsonProperty("linea")
  public String linea;

  @JsonProperty("idMarca")
  public String idMarca;

  @JsonProperty("marca")
  public String marca;

  @JsonProperty("idClaseVehiculo")
  public String idClaseVehiculo;

  @JsonProperty("tipoServicio")
  public String tipoServicio;

  @JsonProperty("servicio")
  public String servicio;

  @JsonProperty("modelo")
  public String modelo;

  @JsonProperty("cilindraje")
  public String cilindraje;

  @JsonProperty("numeroPasajeros")
  public String numeroPasajeros;

  @JsonProperty("capacidadCarga")
  public String capacidadCarga;

  @JsonProperty("numeroChasis")
  public String numeroChasis;

  @JsonProperty("numeroMotor")
  public String numeroMotor;

  @JsonProperty("paisOrigenId")
  public String paisOrigenId;

  @JsonProperty("idTipoCombustible")
  public String idTipoCombustible;

  @JsonProperty("tipoCombustible")
  public String tipoCombustible;

  private static final long serialVersionUID = 8309807414984342419L;
}
