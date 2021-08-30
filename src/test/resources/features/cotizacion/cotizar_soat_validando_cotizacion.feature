#language:es

Característica: Cotizar SOAT por el canal retail validando la cotizacion
  Yo como usuario
  Quiero cotizar el SOAT de un vehiculo
  Para validar que la cotizacion se guarde de manera correcta

  @CotizarSoatPorRetailValidandoCotizacion
  Escenario: Cotizar el SOAT de un vehiculo por canal retail validando que se guarde la cotizacion
    Dado que un cliente desea realizar una cotizacion de un "Auto familiar con mas de 1500 c.c y modelo 2019" por el canal "retail"
    Cuando cotice el SOAT del vehiculo por el canal "retail" con fecha de inicio de vigencia "anticipada 1 mes" y guarde la cotizacion
    Entonces deberia validar que se guarde la cotizacion de forma correcta