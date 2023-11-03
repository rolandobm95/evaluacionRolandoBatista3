# Microservicio-1.0
Este proyecto utiliza Spring Boot.\
Si desea obtener más información sobre Spring Boot, visite su sitio web: https://spring.io/projects/spring-boot.

Este proyecto consume el servicio: http://jsonplaceholder.typicode.com/posts y almacenar el resultado
en una BD.

## Ejecutando la aplicacion en modo dev
Puede ejecutar su aplicación en modo de desarrollo que permite la codificación en vivo usando:
```shell script
mvn spring-boot:run
```
## Empaquetar y ejecutar la aplicación.
La aplicación se puede empaquetar usando:
```shell script
mvn clean package
```
Produce el archivo Microservisio-1.0.jar en el directorio target. 
Luego, puedes ejecutar el JAR usando:
```shell script
java -jar target/Microservicio-1.0.jar
```


## Iniciar el proceso de almacenamiento de datos
Para iniciar el proceso de almacenamiento de datos en la
base de datos H2 se puede acceder a la URL
> http://localhost:8080/posts/store 

Para realizar búsquedas en la base de datos utilice la 
siguiete URL y agregue el Id o Título a buscar
>http://localhost:8080/posts/find

Ejemplo de busqueda:
>http://localhost:8080/posts/find?id=34

Para acceder a la base de datos utilice la siguiente URL:
> http://localhost:8080/h2-console

Utilice las siguientes credenciales:
>URL: jdbc:h2:mem:testdb\
Driver Class: org.h2.Driver\
User Name: sa\
Password: password

Para validar que se grabaron los datos satisfactoriamente puede ejecutar la siguiente consulta SQL:
>SELECT * FROM POST;
