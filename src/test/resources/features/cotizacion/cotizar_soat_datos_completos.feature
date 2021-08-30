#language:es

  @CotizarSoatConDatosCompletos
Característica: Cotizar SOAT validando la tarifa para cada clase de vehiculos
  Yo como usuario
  Quiero cotizar el SOAT de un vehículo
  Para validar que la tarifa mostrada se la correcta

  Esquema del escenario: Cotizar exitosamente el valor del SOAT con tarifas que dependen de clase de vehiculos y cilindraje
    Dado que un cliente desea realizar una cotizacion de un vehiculo por el canal "tradicional"
      | Clase de vehiculo | <Clase de vehiculo> |
      | Cilindraje        | <Cilindraje>        |
    Cuando cotice el SOAT del vehiculo con fecha de inicio de vigencia "anticipada 1 mes"
    Entonces debería ver que la tarifa total es igual a <Tarifa total>

    Ejemplos:
      | Clase de vehiculo                          | Cilindraje                           | Tarifa total |
      | Motos                                      | Ciclomotor                           | 178500       |
      | Motos                                      | Menos de 100 c.c.                    | 369750       |
      | Motos                                      | Entre 100 - 200 c.c                  | 495900       |
      | Motos                                      | Mas de 200 c.c                       | 559050       |
      | Motos                                      | Motocarros Tricimotos y Cuadriciclos | 559050       |
      | Vehículos oficiales especiales ambulancias | Menos de 1500 c.c                    | 733950       |
      | Vehículos oficiales especiales ambulancias | Entre 1500  -  2500 c.c              | 925200       |
      | Vehículos oficiales especiales ambulancias | Más de 2500 c.c                      | 1109250      |

  Esquema del escenario: Cotizar exitosamente el valor del SOAT con tarifas que dependen de clase de vehiculos, cilindraje y modelo
    Dado que un cliente desea realizar una cotizacion de un vehiculo por el canal "retail"
      | Clase de vehiculo | <Clase de vehiculo> |
      | Cilindraje        | <Cilindraje>        |
      | Modelo            | <Modelo>            |
    Cuando cotice el SOAT del vehiculo con fecha de inicio de vigencia "anticipada 1 mes"
    Entonces debería ver que la tarifa total es igual a <Tarifa total>

    Ejemplos:
      | Clase de vehiculo                              | Cilindraje             | Modelo | Tarifa total |
      | Camperos y camionetas                          | Menos de 1500 c.c      | 2015   | 582300       |
      | Camperos y camionetas                          | Menos de 1500 c.c      | 2010   | 699900       |
      | Camperos y camionetas                          | Entre 1500 -  2500 c.c | 2015   | 695400       |
      | Camperos y camionetas                          | Entre 1500 -  2500 c.c | 2009   | 823500       |
      | Camperos y camionetas                          | Más de 2500 c.c        | 2015   | 815250       |
      | Camperos y camionetas                          | Más de 2500 c.c        | 2008   | 935700       |
      | Autos familiares                               | Menos de 1500 c.c      | 2015   | 328800       |
      | Autos familiares                               | Menos de 1500 c.c      | 2010   | 435600       |
      | Autos familiares                               | Entre 1500 -  2500 c.c | 2015   | 400050       |
      | Autos familiares                               | Entre 1500 -  2500 c.c | 2009   | 497850       |
      | Autos familiares                               | Más de 2500 c.c        | 2015   | 467400       |
      | Autos familiares                               | Más de 2500 c.c        | 2008   | 554100       |
      | Vehículos con capacidad para 6 ó mas pasajeros | Menos de 2500 c.c      | 2015   | 585900       |
      | Vehículos con capacidad para 6 ó mas pasajeros | Menos de 2500 c.c      | 2010   | 747600       |
      | Vehículos con capacidad para 6 ó mas pasajeros | 2500 o más c.c         | 2015   | 783900       |
      | Vehículos con capacidad para 6 ó mas pasajeros | 2500 o más c.c         | 2009   | 941100       |

  Esquema del escenario: Cotizar exitosamente el valor del SOAT con tarifas que dependen de clase de vehiculos y toneladas
    Dado que un cliente desea realizar una cotizacion de un vehiculo por el canal "tradicional"
      | Clase de vehiculo | <Clase de vehiculo> |
      | Toneladas         | <Toneladas>         |
    Cuando cotice el SOAT del vehiculo con fecha de inicio de vigencia "anticipada 1 mes"
    Entonces debería ver que la tarifa total es igual a <Tarifa total>

    Ejemplos:
      | Clase de vehiculo         | Toneladas          | Tarifa total |
      | Vehículo de carga o mixto | Menos de 5 Tons.   | 652200       |
      | Vehículo de carga o mixto | Entre 5 y 15 Tons. | 942000       |
      | Vehículo de carga o mixto | Más de 15 Tons.    | 1191000      |

