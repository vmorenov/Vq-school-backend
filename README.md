# VQ School — backend e infraestructura

Monorepositorio Java 21 / Spring Boot con BFF y tres servicios: School, Learning y Communication. El frontend está en [Va-school-app](https://github.com/vmorenov/Va-school-app/tree/feat/microfrontend-foundation), un repositorio activo con shell React y dos microfrontends.

**Estado: primera base técnica implementada; MVP funcional pendiente.** No hay datos escolares reales ni operaciones académicas implementadas. Sesión BFF en memoria; membresías, persistencia, MFA y entorno productivo siguen en backlog.

## Arranque y pruebas
Requiere Java 21 y Maven 3.9+ para `mvn verify`. Para el stack integrado, seguir [infra/README.md](infra/README.md): ambos checkouts hermanos, Python 3 y Docker Compose v2. No se necesita copiar IDs manualmente; el usuario de demostración es sintético y la contraseña se genera localmente.

```sh
mvn -B -ntp verify
python3 scripts/check_backlog.py
```

## Código
- `services/bff`: login OIDC/PKCE, cookie HttpOnly, CSRF, logout y proxy limitado de capacidades.
- `services/school-service`, `learning-service`, `communication-service`: health y capacidades autenticadas; sin endpoints de expedientes todavía.
- `libraries/security`: validación issuer/audiencia/vigencia y configuración de resource server.
- `infra`: Compose local, realm sintético, proxy y generación local de secretos.
- `contracts`: contrato OpenAPI inicial; `docs`: alcance y backlog.

## Documentación
- [Alcance MVP](docs/01-alcance-mvp.md), [arquitectura](docs/02-arquitectura.md) y [roles](docs/03-roles-seguridad.md).
- [40 HU](docs/05-backlog.md) y [distribución con 18 tareas frontend](docs/08-distribucion-repositorios.md).
- [ADR vigente: dos repositorios y microfrontends](docs/adr/0002-dos-repositorios-microfrontends.md).
- [Validaciones, límites y siguientes pasos](docs/09-estado-implementacion.md).

Cambios mediante PR a develop, sin push directo a develop/staging/master. Protección de ramas aún pendiente de aplicar/verificar. Nunca cargar secretos, datos de menores ni capturas reales en este repositorio público.
