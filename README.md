# Store API

Para el correcto funcionamiento de los microservicios se deben ejecutar de la siguiente manera:

1. EurekaService
2. GatewayService
3. UserService
4. VehicleService
5. OrderService


# Consideraciones

* Se recomienda el entorno de desarrollo IntelliJ IDEA para el despliegue de los servicios.
* Se creó un usuario para realizar pruebas, las credenciales de este se encuentran en el microservicio UserService dentro de la clase utils > InitialData.java
* Se deden cambiar las credenciales de la base de datos en los archivos properties de los siguientes microservicios: UserService, VehicleService, OrderService.