SAUCE DEMO - INSTRUCCIONES DE EJECUCION

Este proyecto automatiza una compra en Sauce Demo con Java, Serenity BDD,
Screenplay y Cucumber. El escenario inicia sesion, agrega dos productos,
verifica el carrito, completa el formulario y valida la confirmacion.

Requisitos
1. Instalar JDK 17 o superior y configurar JAVA_HOME. Verificar con:
   java -version
2. Instalar Google Chrome y tener acceso a Internet. La primera ejecucion
   descarga Gradle, dependencias y, si es necesario, el controlador de Chrome.
3. Instalar Git.

Ejecucion en Windows
1. Abrir PowerShell y clonar el repositorio:
   git clone https://github.com/samuelgraciano/saucedemo.git
2. Entrar al proyecto:
   cd saucedemo
3. Revisar src\test\resources\environments\settings.json. Contiene las
   credenciales publicas de prueba de Sauce Demo; el feature no las recibe.
4. Ejecutar el escenario:
   .\gradlew.bat clean test --tests com.saucedemo.runners.PurchaseRunner --no-daemon
5. Para ejecutarlo sin mostrar el navegador:
   .\gradlew.bat "-Dheadless.mode=true" clean test --tests com.saucedemo.runners.PurchaseRunner --no-daemon
6. Abrir target\site\serenity\index.html para consultar el reporte Serenity.
   El reporte de Gradle se encuentra en build\reports\tests\test\index.html.
   Cada ejecucion clean regenera estos archivos.

Ejecucion en macOS o Linux: desde la raiz, usar ./gradlew en lugar de
.\gradlew.bat con los mismos argumentos. Si es necesario, ejecutar antes
chmod +x gradlew. Tambien se requiere Chrome y un JDK compatible.

El resumen de una ejecucion se encuentra en reportes\resultado.txt y las
conclusiones en conclusiones.txt. Los reportes HTML se generan localmente.
No se deben guardar credenciales reales en settings.json ni en el repositorio.
