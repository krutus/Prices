# Price Query Service

Este servicio proporciona un endpoint REST (/prices) para consultar precios de productos en una base de datos de comercio electrónico. La tabla `PRICES` refleja el precio final (PVP) y la tarifa que aplica a un producto de una cadena entre unas fechas determinadas. En caso de tener varios precios en ese rango de fechas, se elegirá el que tenga mayor prioridad.
Además, se proporciona un segundo endpoint REST(/prices/all) para consultar todos los precios de la base de datos, utilizado principalmente para poder tener una mejor visión del contenido de la base de datos.

## Parámetros de entrada para el primer endpoint:

- `fechaAplicacion`: Fecha para la cual se desea consultar el precio.
- `idProducto`: Identificador del producto.
- `idCadena`: Identificador de la cadena de tiendas.

## El segundo endpoint no requiere de parámetros de entrada.

## Datos de salida del primer endpoint:

La consulta devuelve los siguientes datos:

- `idProducto`: Identificador del producto consultado.
- `idCadena`: Identificador de la cadena de tiendas.
- `tarifaAplicada`: Identificador de la tarifa de precios aplicable.
- `fechaInicio`: Fecha de inicio de aplicación de la tarifa.
- `fechaFin`: Fecha de fin de aplicación de la tarifa.
- `precioFinal`: Precio final a aplicar.

## Datos de salida del segundo endpoint:

La consulta devuelve una lista de precios, teniendo cada uno de estos los siguientes datos:

- `idProducto`: Identificador del producto consultado.
- `idCadena`: Identificador de la cadena de tiendas.
- `tarifaAplicada`: Identificador de la tarifa de precios aplicable.
- `fechaInicio`: Fecha de inicio de aplicación de la tarifa.
- `fechaFin`: Fecha de fin de aplicación de la tarifa.
- `precioFinal`: Precio final a aplicar.
- `currency`: Iso de la moneda.


## Tecnologías utilizadas:

- Spring Boot: Framework para desarrollo de aplicaciones Java.
- H2 Database: Base de datos en memoria para almacenamiento de datos de prueba.
- JUnit: Framework para pruebas unitarias en Java.

## Instrucciones para ejecutar:

1. Clona este repositorio en tu entorno de desarrollo local.
2. Abre el proyecto en tu IDE preferido.
3. Ejecuta la aplicación Spring Boot.
4. Realiza consultas al endpoint REST con los parámetros especificados.

## Pruebas:

El código tiene pruebas unitarias para probar y cubrir el código. 
Además, se han realizado pruebas de integración mediante postman para los siguientes casos:

- **Test 1:** Petición a las 10:00 del día 14 del producto 35455 para la marca 1 (ZARA).
- **Test 2:** Petición a las 16:00 del día 14 del producto 35455 para la marca 1 (ZARA).
- **Test 3:** Petición a las 21:00 del día 14 del producto 35455 para la marca 1 (ZARA).
- **Test 4:** Petición a las 10:00 del día 15 del producto 35455 para la marca 1 (ZARA).
- **Test 5:** Petición a las 21:00 del día 16 del producto 35455 para la marca 1 (ZARA).


## Contribución:

¡Se aceptan contribuciones! Si deseas mejorar este servicio, por favor envía un pull request.
