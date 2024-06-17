# Ejecutar proyecto
  Desde la carpeta raíz del proyecto se debe ejecutar el comando:

```
./gradlew bootRun
```

>Nota: Para esta demo se requiere la versión 21 de Java

# Configuración validación password
 En el archivo [application.properties](src%2Fmain%2Fresources%2Fapplication.properties)
 se encuentra la propiedad **config.formato-password.regex** para establecer la expresión regular requerida para validar
 el formato del campo password.
 
# Endpoints

La documentación de los endpoints se encuentra disponible en:

[http://localhost:8080/endpoints](http://localhost:8080/endpoints)