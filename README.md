# MICROSERVICIOS-Y-ARQUITECTURAS-SIN-SERVIDOR

Creación de un sistema de microservicios y arquitecturas sin servidor utilizando Quarkus y AWS. El taller se divide en varias etapas, desde la implementación de un servicio de publicaciones similar a Twitter (como Monolito) hasta su separación en tres microservicios diferentes (Usuarios, Publicaciones, Hilos), independientes incluyendo seguridad utilizando JWT con el servicio Cognito.

## Instrucciones para ejecutar

### Requisitos previos

Para descargar la aplicacion, ya estando aqui, se necesita un equipo de computo con las siguientes caracteristicas:

```
- Java 17 instalado (si cuenta con otra version, probablemente deba hacer la respectiva modificacion en el archivo "pom.xml")

- Maven instalado

- Conexion a internet

- Explorador web

(RECOMENDACION) Tener todo actualizado
```

### Instalacion

Paso a paso

```
1. Clona el repositorio de la aplicación.

2. Importa el proyecto en tu entorno de desarrollo.

3. Empaquetar y compilar el proyecto.
```

`mvn clean install`

```
3. Ejecuta la aplicación en tu servidor local.
```

`quarkus dev`

```
4. Realiza pruebas utilizando el browser, preferiblemente con pestaña en incognito.
```

## Evaluacion

### Pruebas de la aplicacion web

Se realizan pruebas exhaustivas en la aplicación web para garantizar su funcionamiento adecuado y su interacción con el servicio.

#### Ejecucion local

![image](https://github.com/TeranRyl/MICROSERVICIOS-Y-ARQUITECTURAS-SIN-SERVIDOR/assets/81679109/28c31237-0459-470b-a968-8a24c7aed736)

![image](https://github.com/TeranRyl/MICROSERVICIOS-Y-ARQUITECTURAS-SIN-SERVIDOR/assets/81679109/5277eeac-0eda-48c9-88ec-ac465bf1be7c)


### Pruebas de Seguridad con JWT y AWS Cognito

Se verifican las funcionalidades de autenticación y autorización implementadas con Amazon Cognito utilizando pruebas de acceso y permisos.

#### Configuracion

![image](https://github.com/TeranRyl/MICROSERVICIOS-Y-ARQUITECTURAS-SIN-SERVIDOR/assets/81679109/dd7f4d3d-6c4a-4636-8a2b-3ef7ee0bae9f)


### Pruebas de Microservicios Independientes

Se llevan a cabo pruebas específicas para cada microservicio después de la separación. Esto incluye pruebas de Usuarios, Hilos y Publicaciones.

#### Configuracion S3

![image](https://github.com/TeranRyl/MICROSERVICIOS-Y-ARQUITECTURAS-SIN-SERVIDOR/assets/81679109/19015957-63c4-4da6-91b6-563f83d088fd)

`Tutorial:` https://docs.aws.amazon.com/es_es/AmazonS3/latest/userguide/HostingWebsiteOnS3Setup.html#step2-create-bucket-config-as-website/


### Pruebas de Despliegue en AWS

Se realizan pruebas para verificar el correcto despliegue y escalabilidad de los microservicios en AWS.

#### Funcionamiento en la nube

![image](https://github.com/TeranRyl/MICROSERVICIOS-Y-ARQUITECTURAS-SIN-SERVIDOR/assets/81679109/4244670f-d34f-4892-8256-31b7d3e590f7)

![image](https://github.com/TeranRyl/MICROSERVICIOS-Y-ARQUITECTURAS-SIN-SERVIDOR/assets/81679109/4ab7ab94-1eac-4ec2-9eb5-d9352d06a18e)


### Video de Demostración

Para visualizar una demostración del funcionamiento y configuración adecuada de este taller, puede ver el siguiente video:



https://github.com/TeranRyl/MICROSERVICIOS-Y-ARQUITECTURAS-SIN-SERVIDOR/assets/81679109/34b78e55-6609-42a4-9ba5-6663d386c92b



## Implementacion

### Diseño del API

El taller comienza diseñando un API que permite a los usuarios realizar publicaciones de 140 caracteres y registrarlas en un flujo único de publicaciones, similar a Twitter. El diseño incluye tres entidades clave: Usuario, Hilo (Stream), y Publicaciones (Posts). El API se desarrolla utilizando el framework Quarkus y MongoDB como base de datos. El API se compone de los siguientes elementos:



1. **Controladores**:
   - `PostController`: Este controlador se encarga de gestionar las operaciones relacionadas con las publicaciones, como la obtención de todas las publicaciones y la creación de nuevas publicaciones.

   - `StreamController`: Aunque está vacío en este momento, podría usarse para implementar funcionalidades relacionadas con transmisiones de datos.

   - `UserController`: Administra las operaciones relacionadas con los usuarios, como el inicio de sesión y la obtención de todos los usuarios.

2. **Entidades**:
   - `Post`: Representa una publicación en la base de datos MongoDB, con propiedades como ID, mensaje y usuario.

   - `Stream`: Representa un stream de tweets, aunque actualmente no se ha implementado ninguna funcionalidad específica para este componente.

   - `User`: Representa un usuario de la aplicación, con propiedades como ID, nombre, dirección de correo electrónico y contraseña.

3. **Servicios**:
   - `PostServices`: Proporciona métodos para gestionar las publicaciones, como obtener todas las publicaciones, crear nuevas publicaciones y buscar publicaciones por usuario.

   - `UserServices`: Gestiona las operaciones relacionadas con los usuarios, como obtener todos los usuarios, crear nuevos usuarios y verificar las credenciales de inicio de sesión.


### Aplicacion web y Despliegue

Una aplicación web en JavaScript se crea para interactuar con el servicio. La aplicación web se implementa en Amazon S3 para que esté disponible en Internet.

### Seguridad con JWT y Amazon Cognito

Se agrega seguridad al servicio utilizando tokens JWT (JSON Web Tokens) con el servicio Amazon Cognito de AWS para la autenticación y autorización de usuarios. La clase `CognitoClient` se utiliza para interactuar con Cognito y proporciona métodos para el registro, confirmación de registro y autenticación de usuarios.

### Separacion en Microservicios

El monolito inicial se divide en tres microservicios independientes para mejorar la escalabilidad y el mantenimiento. Estos microservicios abordan las funcionalidades de Usuarios, Hilos y Publicaciones por separado.

### Despliegue en AWS

Los microservicios se despliegan en AWS utilizando EC2 o contenedores Docker en AWS, lo que permite realizar pruebas y demostrar la escalabilidad de la arquitectura.

## Construido con

* [Java](https://www.oracle.com/co/java/) - Backend
* [Maven](https://maven.apache.org/) - Gestion de ciclo de vida, codigo fuente y dependencias
* [Git/Github](https://git-scm.com/) - Almacenar el codigo fuente
* [IntelliJ IDEA](https://www.jetbrains.com/idea/) - IDE para desarrollo
* [Quarkus](https://quarkus.io/) - Framework para la aplicacion


## Autores

* **Juan Francisco Teran** - *Trabajo total* - [TeranRyl](https://github.com/TeranRyl)
* **Daniel Esteban Perez** - *Trabajo total* - [danielsperezb](https://github.com/danielsperezb)

## Licencia

Este proyecto tiene la licencia GNU General Public License v3.0; consulte el archivo [LICENSE](LICENSE.txt) para obtener más información.

## Reconocimientos

* PurpleBooth - Plantilla para hacer un buen README
* Luis Daniel Benavides - Preparacion para el taller e introduccion al tema


