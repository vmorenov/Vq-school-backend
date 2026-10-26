# Contratos
La primera versión de APIs y eventos se implementa en HU-40 a partir de [datos y contratos](../docs/04-datos-contratos.md). Todavía no hay OpenAPI implementado.

Cada servicio publicará su OpenAPI versionado y pruebas de compatibilidad. No compartir entidades JPA ni tablas. Los eventos usarán envelope versionado, payload mínimo, outbox/inbox e idempotencia. El catálogo conceptual no es una promesa de endpoints ejecutables.
