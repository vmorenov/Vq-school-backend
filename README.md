# VQ School — base del MVP

Plataforma escolar con sitio público administrable y portal privado para alumnos, profesores, administradores e inspectores.

**Estado: alcance, arquitectura y backlog registrados; funcionalidades todavía no implementadas.** Esta entrega es la línea base para construir el MVP. No existe aún una aplicación desplegable ni se han ejecutado pruebas de runtime.

## Leer primero

1. [Alcance y reglas del MVP](docs/01-alcance-mvp.md)
2. [Arquitectura y diagramas](docs/02-arquitectura.md)
3. [Roles y seguridad](docs/03-roles-seguridad.md)
4. [Modelo de datos y contratos](docs/04-datos-contratos.md)
5. [Backlog de 40 HU](docs/05-backlog.md)
6. [Incrementos y aceptación](docs/06-plan-entrega.md)
7. [Infraestructura y operación](infra/README.md)
8. [Decisiones de arquitectura](docs/adr/0001-base-mvp.md)
9. [Fuentes técnicas](docs/07-fuentes.md)

## Monorepositorio canónico

Se utilizará **vmorenov/Vq-school-backend** como monorepositorio de producto, conservando el nombre existente:
- `apps/web`: React + TypeScript, web pública y portal.
- `services/bff`: Java, sesión web y enrutamiento.
- `services/school-service`: establecimiento, usuarios, academia e inspectoría.
- `services/learning-service`: material, pruebas e intentos.
- `services/communication-service`: CMS, bandeja y entrega de notificaciones.
- `contracts`: OpenAPI y eventos.
- `infra`: Compose, configuración y futura IaC.
- `docs`: alcance, arquitectura, decisiones y backlog.

Estas rutas son **la estructura objetivo**, no módulos de software ya disponibles. Un monorepositorio comparte código fuente y versionado; cada servicio tendrá imagen y despliegue independiente.

El repositorio **vmorenov/Va-school-app** queda como punto de referencia hacia este monorepositorio; no se elimina ni archiva. No habrá dos copias activas del frontend.

## Trabajo y ramas

`feature/* → PR a develop → PR a staging → PR a master`. La rama `main` original se conserva. La protección de ramas sigue **pendiente de configuración**; no se considera aplicada. Esta base se entrega en una rama de trabajo mediante PR, sin push directo a develop, staging o master.

## Límites de esta entrega

No contiene secretos, cuentas reales, datos de estudiantes ni valores de infraestructura contratada. Las HU están pendientes; crear documentos/issues no las implementa. Se requiere aprobar reglas académicas, proveedor y políticas de datos con el colegio piloto antes de cargar datos reales.
