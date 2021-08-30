#language:es

@CotizarSoatConFechaInicioMayor6Meses
Característica: Cotizar SOAT de vehiculo con fecha de inicio de vigencia mayor a 6 meses
  Yo como usuario
  Quiero cotizar el SOAT de un vehículo con fecha inicio de vigencia mayor a 6 meses
  Para validar que no sea posible cotizar el SOAT

  Escenario: Cotizar el SOAT de un vehiculo con fecha inicio de vigencia mayor a 6 meses por el canal tradicional
    Dado que una persona desea expedir el soat de un "Automóvil modelo 2018 con menos de 1500 c.c" por el canal "tradicional"
    Cuando el cliente cotice el SOAT del vehiculo con fecha de inicio de vigencia "anticipada 7 mes"
    Entonces debería ver un mensaje indicando que no es posible cotizar el soat

  Escenario: Cotizar el SOAT de un vehiculo con fecha inicio de vigencia mayor a 6 meses por el canal retail
    Dado que una persona desea expedir el soat de un "Automóvil modelo 2015 con menos de 1500 c.c" por el canal "retail"
    Cuando el cliente cotice el SOAT del vehiculo con fecha de inicio de vigencia "anticipada 7 mes"
    Entonces debería ver un mensaje indicando que no es posible cotizar el soat