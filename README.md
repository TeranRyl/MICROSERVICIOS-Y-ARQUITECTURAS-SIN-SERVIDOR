# MICROSERVICIOS-Y-ARQUITECTURAS-SIN-SERVIDOR

Creación de un sistema de microservicios y arquitecturas sin servidor utilizando Quarkus y AWS. El taller se divide en varias etapas, desde la implementación de un servicio de publicaciones similar a Twitter (como Monolito) hasta su separación en tres microservicios diferentes (Usuarios, Publicaciones, Hilos), independientes incluyendo seguridad utilizando JWT con el servicio Cognito.


## Evaluacion

### Pruebas de la aplicacion web

Se realizan pruebas exhaustivas en la aplicación web para garantizar su funcionamiento adecuado y su interacción con el servicio.

### Pruebas de Seguridad con JWT y Amazon Cognito

Se verifican las funcionalidades de autenticación y autorización implementadas con Amazon Cognito utilizando pruebas de acceso y permisos.

### Pruebas de Microservicios Independientes

Se llevan a cabo pruebas específicas para cada microservicio después de la separación. Esto incluye pruebas de Usuarios, Hilos y Publicaciones.

### Pruebas de Despliegue en AWS

Se realizan pruebas para verificar el correcto despliegue y escalabilidad de los microservicios en AWS.

### Video de Demostración

Para visualizar una demostración del funcionamiento y configuración adecuada de este taller, puede ver el siguiente video:


## Implementacion

### Diseño del API

El taller comienza diseñando un API que permite a los usuarios realizar publicaciones de 140 caracteres y registrarlas en un flujo único de publicaciones, similar a Twitter. El diseño incluye tres entidades clave: Usuario, Hilo (Stream), y Publicaciones (Posts). El API se desarrolla utilizando Quarkus.


### Aplicacion web y Despliegue

Una aplicación web en JavaScript se crea para interactuar con el servicio. La aplicación web se implementa en Amazon S3 para que esté disponible en Internet.

### Seguridad con JWT y Amazon Cognito

Se agrega seguridad al servicio utilizando tokens JWT (JSON Web Tokens) con el servicio Amazon Cognito de AWS para la autenticación y autorización de usuarios.

### Separacion en Microservicios

El monolito inicial se divide en tres microservicios independientes para mejorar la escalabilidad y el mantenimiento. Estos microservicios abordan las funcionalidades de Usuarios, Hilos y Publicaciones por separado.

### Despliegue en AWS

Los microservicios se despliegan en AWS utilizando EC2 o contenedores Docker en AWS, lo que permite realizar pruebas y demostrar la escalabilidad de la arquitectura.

## Autores

* **Juan Francisco Teran** - *Trabajo total* - [TeranRyl](https://github.com/TeranRyl)
* **Daniel Esteban Perez** - *Trabajo total* - [danielsperezb](https://github.com/danielsperezb)

## Licencia

Este proyecto tiene la licencia GNU General Public License v3.0; consulte el archivo [LICENSE](LICENSE.txt) para obtener más información.

## Reconocimientos

* PurpleBooth - Plantilla para hacer un buen README
* Luis Daniel Benavides - Preparacion para el taller e introduccion al tema


