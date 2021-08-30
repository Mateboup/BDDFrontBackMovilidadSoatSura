package co.com.segurossura.certification.soat.models.comunes;

import static co.com.segurossura.certification.soat.utils.enums.EnumMensajeAlerta.CILINDRAJE;
import static co.com.segurossura.certification.soat.utils.enums.EnumMensajeAlerta.CLASE;
import static co.com.segurossura.certification.soat.utils.enums.EnumMensajeAlerta.LINEA;
import static co.com.segurossura.certification.soat.utils.enums.EnumMensajeAlerta.MARCA;
import static co.com.segurossura.certification.soat.utils.enums.EnumMensajeAlerta.MODELO;
import static co.com.segurossura.certification.soat.utils.enums.EnumMensajeAlerta.TIPO_COMBUSTIBLE;
import static co.com.segurossura.certification.soat.utils.enums.EnumMensajeAlerta.TIPO_SERVICIO;

import co.com.segurossura.certification.soat.utils.enums.EnumMensajeAlerta;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class MensajesAlertas {

  public final String campo;
  public final EnumMensajeAlerta enumMensajeAlerta;
  public static final List<MensajesAlertas> LISTA_MENSAJES = new ArrayList<>();

  public MensajesAlertas(String campo, EnumMensajeAlerta enumMensajeAlerta) {
    this.campo = campo;
    this.enumMensajeAlerta = enumMensajeAlerta;
  }

  public static void llenarListaMensajes() {
    LISTA_MENSAJES.add(new MensajesAlertas("Id ClaseVehiculo", CLASE));
    LISTA_MENSAJES.add(new MensajesAlertas("Tipo Combustible", TIPO_COMBUSTIBLE));
    LISTA_MENSAJES.add(new MensajesAlertas("Tipo Servicio", TIPO_SERVICIO));
    LISTA_MENSAJES.add(new MensajesAlertas("Marca", MARCA));
    LISTA_MENSAJES.add(new MensajesAlertas("Linea", LINEA));
    LISTA_MENSAJES.add(new MensajesAlertas("Modelo", MODELO));
    LISTA_MENSAJES.add(new MensajesAlertas("Cilindraje", CILINDRAJE));
  }
}
