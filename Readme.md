# Proyecto Java + Angular

Este repositorio contiene una aplicación que combina un backend en Java utilizando Spring Boot y un frontend en Angular.

## Requisitos

### Frontend (Angular)

- **Node.js**: v14.21.3
- **npm**: v6.14.15 (viene con Node.js)

### Backend (Java Spring Boot)

- **Java SDK**: v17
- **Maven**: v3.9.9

## Configuración y Ejecución

### Inicializar Angular

1. Asegúrate de tener la versión correcta de **npm** instalada. Puedes verificar tu versión con el siguiente comando:

    ```bash
    npm -v
    ```

    Si tienes una versión diferente, puedes instalar la versión requerida utilizando [nvm](https://github.com/nvm-sh/nvm) o actualizar npm globalmente.

2. Navega al directorio del frontend en tu proyecto (donde está el código de Angular).

3. Ejecuta el siguiente comando para instalar las dependencias:

    ```bash
    npm i
    ```

4. Para iniciar el proyecto Angular, ejecuta:

    ```bash
    npm run start
    ```

   Esto iniciará el servidor de desarrollo en el puerto 4200 por defecto. Puedes acceder a la aplicación en tu navegador en `http://localhost:4200`.

### Inicializar Java Spring Boot

1. Asegúrate de tener **Java SDK 17** y **Maven 3.9.9** instalados en tu máquina. Puedes verificar las versiones de Java y Maven con los siguientes comandos:

    ```bash
    java -version
    mvn -v
    ```

    Si necesitas instalar o actualizar Java o Maven, consulta las instrucciones en sus sitios oficiales.

2. Navega al directorio del backend (donde está el código de Java Spring Boot).

3. Para iniciar la aplicación de Spring Boot, ejecuta:

    ```bash
    mvn spring-boot:run
    ```

   Esto pondrá en marcha el servidor de Spring Boot. Por defecto, la aplicación se ejecutará en `http://localhost:8080`.

## Estructura del Proyecto

El proyecto está dividido en dos directorios principales:

- **frontend/**: Contiene el código fuente de Angular.
- **backend/**: Contiene el código fuente de Java Spring Boot.

## Contribución

Si deseas contribuir al proyecto, por favor sigue estos pasos:

1. Realiza un fork de este repositorio.
2. Crea una rama con tu funcionalidad o corrección de errores.
3. Realiza los cambios y realiza un commit descriptivo.
4. Crea un pull request con una descripción detallada de tus cambios.

## Licencia

Este proyecto está bajo la licencia MIT. Consulta el archivo LICENSE para más detalles.