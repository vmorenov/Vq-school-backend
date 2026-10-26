# Contratos
El contrato inicial de sesión y capacidades está en [foundation.openapi.yaml](foundation.openapi.yaml) y corresponde a los endpoints de la base técnica. Las APIs de negocio y eventos siguen pendientes en HU-40 a partir de [datos y contratos](../docs/04-datos-contratos.md).

Cada servicio publicará su OpenAPI versionado y pruebas de compatibilidad. No compartir entidades JPA ni tablas. Los eventos usarán envelope versionado, payload mínimo, outbox/inbox e idempotencia. El catálogo conceptual no es una promesa de endpoints ejecutables.
