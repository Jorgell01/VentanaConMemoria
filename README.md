# VentanaConMemoria
VentanaConMemoria es una aplicación JavaFX que guarda y recupera el estado de una ventana entre ejecuciones. La aplicación guarda la posición (x, y), el tamaño (ancho y alto) y el color de fondo (valores RGB) de la ventana en un archivo de configuración. Estos valores se cargan al iniciar la aplicación, permitiendo que la ventana retenga el estado que tenía al cerrarse la última vez.

Características
Persistencia de estado: La posición, tamaño y color de fondo de la ventana se guardan en un archivo de propiedades.
Control de color dinámico: Los usuarios pueden ajustar el color de fondo mediante controles deslizantes para los valores de rojo, verde y azul.
Interfaz sencilla: Uso de JavaFX para crear una interfaz gráfica con controles deslizantes para el color y un diseño simple para facilitar la interacción.
Requisitos
Java 8 o superior
JavaFX: La aplicación está construida con JavaFX, por lo que se debe tener configurado correctamente en el entorno de desarrollo.
Estructura del proyecto
El proyecto contiene la siguiente estructura principal:

Main Class: VentanaConMemoria.java
Guarda y carga el estado de la ventana desde un archivo de propiedades.
Vincula los valores de los controles deslizantes a las propiedades del color de fondo.
Configuración de usuario: La configuración de la ventana se guarda en el directorio del usuario dentro de una carpeta llamada .VentanaConMemoria, y los valores se almacenan en el archivo config.properties.
Instalación y uso
Clona o descarga el repositorio en tu máquina local.
Asegúrate de tener configurado JavaFX en tu entorno de desarrollo.
Ejecuta la aplicación desde tu IDE o mediante la línea de comandos.
Al ajustar los controles deslizantes, la ventana cambiará de color en tiempo real.
Al cerrar la ventana, su estado actual (posición, tamaño y color) se guardará en el archivo config.properties, y será restaurado la próxima vez que se ejecute la aplicación.
Guardado del estado
Cuando la aplicación se cierra, guarda el estado actual de la ventana en un archivo llamado config.properties ubicado en:

~/.VentanaConMemoria/config.properties

Los siguientes valores se guardan:

size.width: Ancho de la ventana.
size.height: Alto de la ventana.
size.x: Posición en el eje X de la ventana.
size.y: Posición en el eje Y de la ventana.
color.red: Componente rojo del color de fondo.
color.green: Componente verde del color de fondo.
color.blue: Componente azul del color de fondo.

Notas
Si el archivo de configuración no existe al iniciar la aplicación por primera vez, se utilizarán valores por defecto.
El color de fondo se ajusta automáticamente conforme cambian los valores de los controles deslizantes.
