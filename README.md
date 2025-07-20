# PriceService

API REST para obtener precios de productos.

## Descripción

PriceService es una API REST que permite consultar el precio aplicable de un producto en función de la fecha, el identificador del producto y el identificador de la marca. La API devuelve el precio con la mayor prioridad dentro del rango de fechas especificado.

## Características

- Consulta de precios por fecha, producto y marca.
- Manejo de prioridades para determinar el precio aplicable.
- Respuesta en formato JSON con detalles del precio.

## Tecnologías utilizadas

- **Java 17**
- **Spring Boot**
- **Maven**
- **H2 Database** (base de datos en memoria para pruebas)
- **JPA/Hibernate** (para el acceso a datos)
- **Lombok** (para reducir código repetitivo)
- **Swagger** (para documentación de la API)

## Requisitos previos

- Java 17 o superior
- Maven 3.8 o superior

## Configuración y ejecución

1. Clona este repositorio:
   ```bash
   git clone https://github.com/x357496-sgt_sangroup/PriceService.git
   cd PriceService
   
2. Compila el proyecto:
    ```bash
    mvn clean install
   
3. Ejecuta la aplicación:
    ```bash
    mvn spring-boot:run

4. Accede a la API mediante Swagger `http://localhost:8081/swagger-ui.html`.
5. Realiza peticiones GET a la API con los parámetros necesarios:
    - `productId`: ID del producto.
    - `brandId`: ID de la marca.
    - `date`: Fecha en formato `yyyy-MM-dd HH:mm:ss`.

## Ejemplo de petición

```http
curl -X GET "http://localhost:8081/api/prices?applicationDate=2020-06-14T10:00:00&productId=35455&brandId=1"
