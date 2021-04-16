# SOLUTION LAB-Excepciones
## Parte I - Entendiendo las excepciones 
###¿Cómo se lanza una excepción en JAVA?

Esta se lanza con la palabra reservada `throw` que romperá el código. En este caso, se instancia la 
excepción deseada `new throw Exception (“message”)`

###¿Cómo se propaga una excepción en JAVA?
La excepción se propaga mediante la palabra reservada `throws`. Esta se coloca después de definir los parámetros de un método y sirve para que todos los métodos que lo llamen puedan propagar o controlar esa excepción.

###¿Cómo se captura una excepción en JAVA?
Se captura la excepción utilizando la palabra reservada `catch` seguida de un try, que permite controlar la excepción recibida.
###¿Cuál es la diferencia en la implementación de las pruebas? ¿Validan lo mismo?
La implementación en las pruebas debe cambiar, ya que por lo general se tenía 
en cuenta una devolución de los métodos booleana, es decir si el proceso había 
sido exitoso o no, pero ahora se arrojarán excepciones que deberán ser manejadas 
y comparadas con lo esperado.

## Parte IV - Excepciones integrando
###¿Por qué el compilador muestra estos errores?
El compilador evidencia estos errores debido a que en la clase de SabanaPayroll
existen sistemas que llaman a métodos que implementan, a su vez, métodos de 
la interfaz que ahora lanzan errores, por lo cual, los sistemas de la clase 
SabanaPayroll deben propagar estas excepciones o controlarlas para que se pueda
compilar.

###¿Qué debemos hacer para controlarlos?
Para controlar la excepción debemos agregar un `try-catch` donde try internara 
llamara al método deseado y catch controlara la excepción si es arrojada para completar
la funcionalidad del sistema. 
###¿Deben ser las excepciones en SabanaPayroll controladas o propagadas?
Las excepciones de SabanaPayroll deben ser controladas debido a que no deseamos 
modificar el comportamiento de las pruebas. Además, no es necesario propagar 
la excepción hasta las pruebas ya que el manejo sobre estas se refleja
de manera local y permanece constante.

## Parte V 

Se realizó una nueva excepción llamada `BankAccountException` que tiene como objetivo
informar sobre fallas relacionadas con las cuentas de banco. En este caso particular, 
se creó un mensaje que informara que el saldo que se desea retirar de la cuenta es insuficiente. 
Este comportamiendo se implemento en el método de withdraw en la clase SabanaPayroll donde se propaga 
hasta las pruebas. 