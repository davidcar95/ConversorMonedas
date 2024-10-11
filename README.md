# Conversor de Monedas

Este proyecto es un **Conversor de Monedas** desarrollado en Java que permite convertir entre diferentes tipos de divisas utilizando la API de ExchangeRate-API para obtener tasas de conversión en tiempo real. El programa incluye funcionalidades como el historial de conversiones con marcas de tiempo y una interfaz simple e intuitiva que permite al usuario seleccionar las monedas desde un menú predefinido.

## Características

- Conversión de monedas en tiempo real utilizando ExchangeRate-API.
- Selección de monedas a través de un menú con opciones para evitar errores de digitación.
- Historial de conversiones para ver los registros anteriores.
- Marca de tiempo en cada conversión realizada.
- Opción para salir del programa con un mensaje de despedida.

## Monedas Disponibles

El programa permite realizar conversiones entre las siguientes monedas:

1. ARS - Peso argentino
2. BOB - Boliviano
3. BRL - Real brasileño
4. CLP - Peso chileno
5. COP - Peso colombiano
6. USD - Dólar estadounidense
7. EUR - Euro

## Requisitos del Sistema

- **Java 8** o superior.
- Conexión a Internet para obtener las tasas de cambio en tiempo real.
- Librerías externas:
    - GSON para procesar las respuestas JSON de la API.

## Instrucciones de Instalación

1. **Clona este repositorio** o descarga los archivos del proyecto.
   ```bash
   git clone https://github.com/tu-usuario/conversor-de-monedas

## Obtén una API Key de ExchangeRate-API

1. Visita [https://www.exchangerate-api.com/](https://www.exchangerate-api.com/) para obtener una clave API gratuita.
2. Actualiza el valor de la constante `API_URL` en la clase `ExchangeRateApi` con tu clave API.

## Compila y ejecuta el proyecto

- Compila el proyecto en tu entorno de desarrollo preferido (IDE) o desde la terminal.


    javac Main.java
    java Main


## Instrucciones de Uso

### Seleccionar una acción:
Al iniciar el programa, se te pedirá que elijas entre las siguientes opciones:

1. **Convertir moneda**
2. **Mostrar historial de conversiones**
3. **Salir**

### Convertir Moneda:
- Selecciona la **moneda base** y la **moneda objetivo** eligiendo un número de una lista.
- Introduce la **cantidad** que deseas convertir.

### Historial de Conversiones:
- Visualiza todas las conversiones realizadas durante la sesión actual, junto con las **marcas de tiempo**.

### Salir del Programa:
- Elige la opción de **salir** para cerrar el programa con un **mensaje de despedida**.

## Ejemplo de Ejecución:

```plaintext
*********************************
Que te gustaría hacer hoy?

1. Convertir moneda
2. Mostrar historial de conversiones
3. Salir

Selecciona una opción: 1

*********************************
Seleccione la moneda base:

1. ARS - Peso argentino
2. BOB - Boliviano boliviano
3. BRL - Real brasileño
4. CLP - Peso chileno
5. COP - Peso colombiano
6. USD - Dólar estadounidense
7. EUR - Euro

Ingrese el número de la moneda base: 6

*********************************
Seleccione la moneda objetivo:

1. ARS - Peso argentino
2. BOB - Boliviano boliviano
3. BRL - Real brasileño
4. CLP - Peso chileno
5. COP - Peso colombiano
6. USD - Dólar estadounidense
7. EUR - Euro

Ingrese el número de la moneda objetivo: 7

*********************************
Ingrese la cantidad a convertir: 100
*********************************

Resultado: 94.56 EUR

*********************************

```
## Errores Comunes

- **Moneda no encontrada:**  
  Asegúrate de seleccionar solo las monedas de la lista proporcionada.

- **Error en la API:**  
  Verifica que tu clave API sea válida y que tengas acceso a Internet.

## Posibles Mejoras Futuras

- Soporte para más monedas.
- Integración con una interfaz gráfica para mayor usabilidad.
- Guardado del historial en un archivo externo.

## Contribuciones

Las contribuciones son bienvenidas. Siéntete libre de crear issues o enviar pull requests para agregar mejoras o corregir errores.
