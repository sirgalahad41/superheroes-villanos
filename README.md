# Playground Superhéroes — Android Studio carlos giraldo mejia 

AVISO - en mi correo mencione que no logre eliminar el archivo local.properties entre otros, aclaro que hice otro intento y esta ves si lo logre, no quice molestarlo enviando otro correo, espero me entienda

Aplicación Android de lista y detalle de héroes y villanos desarrollada con Kotlin y Jetpack Compose. Esta versión añade una pestaña independiente de villanos y ocho perfiles nuevos

## Requisitos
- Android Studio con soporte para Kotlin y Jetpack Compose.
- JDK 17 (normalmente incluido con Android Studio).
- Conexión a internet para descargar dependencias Gradle y cargar las imágenes remotas.


## Estructura principal
- `Nombres.kt`: modelo `Nombres`, lista de héroes (`listaNombres`) y lista de ocho villanos (`listaVillanos`).
- `Utils.kt`: rutas de navegación centralizadas.
- `ui/theme/UtilsUI.kt`: `HeroImage`, `HeroInfo`, `HeroInfoDetail`, `HeroCard` y métricas.
- `MainActivity.kt`: lista, pantalla de detalle y `AppNavigation`.
- `AndroidManifest.xml`: permisos de internet y actividad de inicio.

## Funcionalidad
- Lista vertical con `LazyColumn`.
- Cards reutilizables y seleccionables.
- Pestañas separadas para Héroes y Villanos.
- Navegación a `detalle/{id}/{villano}` con `NavHost` y `NavController`, para abrir el expediente del personaje correcto.
- Detalle con descripción, métricas derivadas, chips de superpoderes y resumen táctico.
- Botón para volver a la lista.
- Componentes compartidos `HeroCard`, `HeroInfo` y `HeroInfoDetail` para ambas categorías; los textos de perfil se adaptan según el tipo de personaje.

