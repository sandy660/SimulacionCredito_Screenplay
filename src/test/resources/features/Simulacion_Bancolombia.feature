#language: es

Característica: Simulador de Crédito de Libre Inversión de Bancolombia
Como un cliente interesado en obtener un crédito de libre inversión,
Quiero utilizar la pagina https://www.bancolombia.com/personas/creditos/consumo/credito-libre-inversion/simulador-libre-inversion
Para simular diferentes escenarios de crédito, con el fin de conocer las condiciones y detalles de la solicitud.

Escenario: Simulación exitosa de crédito
  Dado que el cliente quiere hacer una simulacion en la pagina de Bancolombia
  Cuando hace clic en continuar
  Entonces deberia ver la pregunta "¿Sabes cuánto dinero necesitas?"
  Dado selecciona la opcion Si
  Y ingresa un monto aleatorio entre 1.000.000 y 500.000.000
  Y ingresa un plazo en meses aleatorio entre 48 y 84
  Y selecciona su fecha de nacimiento "21/12/1988"
  Cuando hace clic en simular
  Entonces deberia ver la información de la simulacion del credito

