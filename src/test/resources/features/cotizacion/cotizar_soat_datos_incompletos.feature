#language:es

@CotizarSoatConDatosIncompletos
Característica: Cotizar SOAT de un vehiculo diligenciando los campos incompletos
  Yo como usuario
  Quiero cotizar el SOAT de un vehículo diligenciando los campos incompletos
  Para validar que la tarifa mostrada se la correcta

  Esquema del escenario: Cotizar SOAT exitosamente con los datos id clase vehiculo, tipo de servicio y tipo de combustible incompletos
    Dado que un cliente desea realizar una cotizacion de un vehiculo por el canal "retail"
      | Clase de vehiculo | <Clase de vehiculo> |
      | Cilindraje        | <Cilindraje>        |
      | Modelo            | <Modelo>            |
    Cuando cotice el SOAT del vehiculo diligenciando los siguientes campos
      | Id ClaseVehiculo | <Id ClaseVehiculo> |
      | Tipo Servicio    | <Tipo Servicio>    |
      | Tipo Combustible | <Tipo Combustible> |
    Entonces debería ver que la tarifa total es igual a <Tarifa total>

    Ejemplos:
      | Clase de vehiculo                           | Cilindraje              | Modelo | Id ClaseVehiculo | Tipo Combustible | Tipo Servicio  | Tarifa total |
      | Autos de negocio taxis y microbuses urbanos | Menos de 1500 c.c.      | 2020   | AUTOMOVIL        | GASOLINA         | PUBLICO URBANO | 406950       |
      | Autos de negocio taxis y microbuses urbanos | Menos de 1500 c.c.      | 2010   | AUTOMOVIL        | GASOLINA         | PUBLICO URBANO | 508200       |
      | Autos de negocio taxis y microbuses urbanos | Entre 1500 -  2500 c.c. | 2019   | AUTOMOVIL        | GASOLINA         | PUBLICO URBANO | 505500       |
  Esquema del escenario: Cotizar SOAT exitosamente con los datos marca, linea, y tipo de servicio incompletos
    Dado que un cliente desea realizar una cotizacion de un vehiculo por el canal "tradicional"
      | Clase de vehiculo | <Clase de vehiculo> |
      | Cilindraje        | <Cilindraje>        |
      | Modelo            | <Modelo>            |
    Cuando cotice el SOAT del vehiculo diligenciando los siguientes campos
      | Marca         | <Marca>         |
      | Linea         | <Linea>         |
      | Tipo Servicio | <Tipo Servicio> |
    Entonces debería ver que la tarifa total es igual a <Tarifa total>

    Ejemplos:
      | Clase de vehiculo                           | Cilindraje              | Modelo | Marca | Linea        | Tipo Servicio  | Tarifa total |
      | Autos de negocio taxis y microbuses urbanos | Entre 1500 -  2500 c.c. | 2009   | DODGE | CARAVAN GRAN | PUBLICO URBANO | 624900       |
      | Autos de negocio taxis y microbuses urbanos | Más de 2500 c.c.        | 2018   | DODGE | CENECA       | PUBLICO URBANO | 652200       |
      | Autos de negocio taxis y microbuses urbanos | Más de 2500 c.c.        | 2008   | DODGE | CHALLENGER   | PUBLICO URBANO | 765300       |

  Esquema del escenario: Cotizar SOAT exitosamente con los datos tipo de servicio y tipo de combustible incompletos
    Dado que un cliente desea realizar una cotizacion de un vehiculo por el canal "tradicional"
      | Clase de vehiculo | <Clase de vehiculo> |
    Cuando cotice el SOAT del vehiculo diligenciando los siguientes campos
      | Tipo Servicio    | <Tipo Servicio>    |
      | Tipo Combustible | <Tipo Combustible> |
    Entonces debería ver que la tarifa total es igual a <Tarifa total>

    Ejemplos:
      | Clase de vehiculo                                    | Tipo Combustible | Tipo Servicio  | Tarifa total |
      | Vehículos de servicio público urbano buses y busetas | GASOLINA         | PUBLICO URBANO | 973800       |

  Esquema del escenario: Cotizar SOAT exitosamente con los datos tipo de servicio, modelo, tipo de combustible y cilindraje incompletos
    Dado que un cliente desea realizar una cotizacion de un vehiculo por el canal "retail"
      | Clase de vehiculo   | <Clase de vehiculo>   |
      | Capacidad Pasajeros | <Capacidad Pasajeros> |
    Cuando cotice el SOAT del vehiculo diligenciando los siguientes campos
      | Tipo Servicio    | <Tipo Servicio>    |
      | Modelo           | <Modelo>           |
      | Tipo Combustible | <Tipo Combustible> |
      | Cilindraje       | <Cilindraje>       |
    Entonces debería ver que la tarifa total es igual a <Tarifa total>

    Ejemplos:
      | Clase de vehiculo                   | Capacidad Pasajeros   | Modelo | Cilindraje | Tipo Combustible | Tipo Servicio          | Tarifa total |
      | Vehículo de servicio intermunicipal | Menos de 10 pasajeros | 2015   | 1400       | GASOLINA         | PUBLICO INTERMUNICIPAL | 963000       |
      | Vehículo de servicio intermunicipal | 10  ó  Más pasajeros  | 2015   | 1600       | GASOLINA         | PUBLICO INTERMUNICIPAL | 1397250      |

