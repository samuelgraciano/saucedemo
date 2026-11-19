# Sauce Demo - Serenity BDD + Screenplay + Cucumber

Automatizacion E2E de una compra en `https://www.saucedemo.com/`. El escenario inicia sesion como `standard_user`, agrega dos productos, verifica el carrito, completa el formulario y finaliza el pedido.

## Requisitos

- JDK 17 o superior compatible con la version de Gradle del wrapper.
- Google Chrome instalado y acceso a Internet para descargar las dependencias y el controlador.

## Estructura principal

- `src/test/resources/features/purchase.feature`: escenario Gherkin.
- `src/test/resources/environments/settings.json`: credenciales publicas de prueba de Sauce Demo.
- `src/test/java/com/saucedemo/runners/PurchaseRunner.java`: runner de Cucumber.
- `src/test/java/com/saucedemo/stepdefinitions/PurchaseStepDefinitions.java`: pasos del escenario.
- `src/main/java/com/saucedemo/tasks`: acciones Screenplay.
- `src/main/java/com/saucedemo/questions`: consultas para las validaciones.
- `src/main/java/com/saucedemo/ui`: localizadores de la interfaz.
- `src/main/java/com/saucedemo/models`: datos del comprador.

El inicio de sesion lee `usuario` y `password` de `settings.json`, no del feature. No guardes credenciales reales en el proyecto.

## Ejecutar

En Windows, desde la raiz del proyecto:

```powershell
.\gradlew.bat clean test --tests com.saucedemo.runners.PurchaseRunner --no-daemon
```

Para ejecutar sin mostrar el navegador:

```powershell
.\gradlew.bat "-Dheadless.mode=true" clean test --tests com.saucedemo.runners.PurchaseRunner --no-daemon
```

Para ejecutar solo los escenarios con el tag `@compra_exitosa`:

```powershell
.\gradlew.bat "-Dcucumber.filter.tags=@compra_exitosa" clean test --tests com.saucedemo.runners.PurchaseRunner --no-daemon
```

Puedes reemplazar `@compra_exitosa` por otro tag incluido en los features seleccionados por el runner. Para ejecutarlo sin mostrar el navegador, agrega `"-Dheadless.mode=true"` al comando.

El reporte de Serenity se genera en `target/site/serenity/index.html`. El mensaje real de Sauce Demo incluye un signo de exclamacion y puede mostrarse con otra capitalizacion; la validacion compara el texto sin ese signo final y sin distinguir mayusculas.

Consulta `readme.txt` para las instrucciones completas, `conclusiones.txt` para los hallazgos y `reportes/resultado.txt` para el resumen de la ejecucion registrada.
