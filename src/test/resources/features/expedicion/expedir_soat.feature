#language:es

Característica: Expedir SOAT de vehiculo
  Yo como usuario
  Quiero expedir el SOAT de un vehiculo por el canal tradicional y canal retail
  Para validar que se expidió exitosamente

 @ExpedicionSoatTradicional
  Escenario: Expedir el SOAT de un vehiculo exitosamente por el canal tradicional
    Dado que un cliente desea realizar una expedicion de un "Auto familiar modelo 2017" en el aplicativo SOAT por el canal "tradicional"
    Y la fecha de inicio de vigencia sea "anticipada 1 mes"
    Cuando el cliente expida el SOAT del vehiculo "tradicional"
    Entonces deberia ver que el SOAT se expide de manera exitosa

  @ExpedicionSoatRetail
  Escenario: Expedir el SOAT de un vehículo exitosamente por el Canal Retail
    Dado que un cliente desea realizar una expedicion de un "Auto familiar modelo 2018" en el aplicativo SOAT por el canal "retail"
    Y la fecha de inicio de vigencia sea "anticipada 1 mes"
    Cuando el cliente expida el SOAT del vehiculo "retail"
    Entonces deberia ver que el SOAT se expide de manera exitosa