#language:es

Característica: Expedir SOAT de vehiculo en la fecha actual
  Yo como usuario
  Quiero expedir el SOAT de un vehiculo con fecha del dia actual
  Para validar que se levante un control y no expida

  @ExpedicionSoatConFechaActualTradicional
  Escenario: Expedir el SOAT de un vehiculo con fecha del dia actual
    Dado que una persona desea expedir el soat de un "Auto familiar con menos de 1500 c.c y modelo 2016" por el canal "tradicional"
    Y la fecha de inicio de vigencia sea "actual"
    Cuando el cliente expide el Soat por el canal "tradicional"
    Entonces debería ver un mensaje indicando que no puede expedir el soat en la fecha actual

  @ExpedicionSoatConFechaActualRetail
  Escenario: Expedir el SOAT de un vehículo con fecha del dia actual
    Dado que una persona desea expedir el soat de un "Auto familiar modelo 2019" por el canal "retail"
    Y la fecha de inicio de vigencia sea "actual"
    Cuando el cliente expide el Soat por el canal "retail"
    Entonces debería ver un mensaje indicando que no puede expedir el soat en la fecha actual

