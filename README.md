
#Conversor-de-monedas

Conversor de Monedas en Java que convierte varias divisas a USD usando la API ExchangeRate. Incluye menú interactivo en consola, filtrado de monedas, manejo de errores y muestra tasas de cambio actualizadas en tiempo real.

Tecnologías utilizadas

-Java 17 o superior

-Gson (para analizar datos JSON)

-HttpClient (para conectar con la API)

-IntelliJ IDEA / Visual Studio Code (para escribir y ejecutar el código)

-API ExchangeRate (fuente de datos de tasas de cambio)

Instalación

1-Descarga o clona este repositorio: https://github.com/Jazmin777/Conversor-de-monedas/edit/master/README.md

2-Abre el proyecto en IntelliJ IDEA o VS Code.

3-Asegúrate de tener configurado el JDK 17 o superior.

4-Agrega la librería Gson (descargándola o mediante el gestor de dependencias).

Ejecución

1-Abre el archivo ConversorAPI.java.

2-Ejecuta el método main (botón verde o clic derecho → Run).

3-Espera unos segundos mientras se obtiene la información desde la API.

4-Interactúa con el menú en consola para realizar tus conversiones.

Funcionalidades -Obtiene tasas de cambio actualizadas en tiempo real.

-Convierte de distintas monedas al USD.

-Incluye menú interactivo con varias opciones.

-Filtra monedas específicas desde el JSON.

-Muestra el código HTTP y encabezados de la respuesta de la API.

-Manejo de errores y validaciones de entrada.

Consejos de uso

-Revisa que tengas conexión a internet (la API requiere acceso).

-Si no carga la API, espera unos segundos y vuelve a ejecutar.

-Usa valores numéricos válidos (no letras) al ingresar montos.

-Puedes editar el arreglo de monedas (monedasFiltradas) para agregar más.

Error Posible

1-Error al obtener los datos

2-No se encontró la tasa de cambio

3-Gson not found

Solucion

1-Verifica tu conexión o prueba más tarde

2-Asegúrate de usar uno de los códigos listados (ARS, BOB, BRL, etc.)

3-Descarga e importa gson-2.x.jar desde Maven
