#language:es

@CotizarSoatVigenteMenosDe6MesesParaVencerseYFechaMayor
Característica: Cotizar SOAT con Soat vigente y con fecha de inicio de vigencia mayor a la fecha fin
  Yo como usuario
  Quiero cotizar el SOAT de un vehículo con SOAT vigente y con menos de 6 meses para vencerse
  Para validar que se realice la cotización

  Escenario: Cotizar SOAT vigente con menos de 6 meses para vencerse e inicio de vigencia mayor a la fecha fin de la vigencia actual
    Dado que un cliente "riesgo estandar" tiene un "Auto familiar modelo 2017 con menos de 1500 c.c"
    Y tiene un soat con fecha de inicio de vigencia "retroactiva 11 meses"
    Cuando cotice el SOAT del vehiculo por el canal "tradicional" con fecha de inicio de vigencia "anticipada 2 mes"
    Entonces debería ver que la tarifa del SOAT es 328800

  Escenario: Cotizar SOAT vigente con menos de 6 meses para vencerse e inicio de vigencia mayor a la fecha fin de la vigencia actual
    Dado que un cliente "riesgo estandar" tiene un "Auto familiar modelo 2018 con menos de 1500 c.c"
    Y tiene un soat con fecha de inicio de vigencia "retroactiva 11 meses"
    Cuando cotice el SOAT del vehiculo por el canal "retail" con fecha de inicio de vigencia "anticipada 2 mes"
    Entonces debería ver que la tarifa del SOAT es 328800