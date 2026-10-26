# ADR-0002: dos repositorios activos y microfrontends React

Estado: aceptado por el usuario. Sustituye las decisiones de repositorio/frontend de ADR-0001.

## Distribución
- Vq-school-backend: monorepositorio Java con BFF, School, Learning, Communication, contratos e infraestructura integrada.
- Va-school-app: monorepositorio React/TypeScript con shell, microfrontend académico, microfrontend aprendizaje, web pública y paquetes compartidos.
- Cada aplicación genera su propia imagen. Ningún repo duplica código del otro. Compose referencia un checkout hermano explícito.

## Microfrontends
Module Federation carga Académico y Aprendizaje en runtime. Shell controla navegación, sesión, errores y composición. La división es por dominio, no por rol: alumnos y profesores usan distintas acciones del mismo dominio. Administración e inspectoría permanecen en módulos del shell hasta justificar su extracción.

React/ReactDOM se comparten como singleton con versión compatible. El contrato de entrada inicial contiene apiBase, sin tokens. Los remotos se sirven por rutas del mismo origen. No comparten un store global de negocio; una futura comunicación cruzada usa contratos explícitos y versionados.

La web pública se construye de manera independiente y se prerenderiza para entregar HTML indexable. CMS dinámico y publicación siguen pendientes.

## Despliegue y aprendizaje
Cada remoto tiene build e imagen independientes. La prueba educativa consiste en modificar sólo Aprendizaje, desplegar su imagen y comprobar que shell/Académico no se reconstruyen. Fallback mantiene navegación cuando falla la carga de un remoto. remoteEntry sin caché y assets versionados por hash. Producción debe conservar assets de releases anteriores y probar compatibilidad/rollback; el reemplazo de contenedor local no promete cero interrupciones.

## Backlog
Se conservan las 40 HU funcionales originales para trazabilidad y se asigna ejecución de interfaz a 18 issues FE en Va-school-app. No son 58 funcionalidades ni se suman puntos por duplicado. La matriz de distribución vincula cada HU con sus tareas frontend. Las HU se aceptan con evidencia integral; no se cierran por crear carpetas o mocks.

## Compromisos
Más coordinación de contratos, caché, dependencias y despliegues a cambio de aprendizaje práctico y autonomía de módulos. No se introduce single-spa simultáneamente. Keycloak y BFF mantienen una única sesión; los microfrontends no autentican al usuario de nuevo ni sustituyen autorización del servidor.
