# ADR-0001: monorepositorio y límites del MVP
Estado: decisión histórica. Distribución de repositorios/frontend sustituida por [ADR-0002](0002-dos-repositorios-microfrontends.md); conservar para trazabilidad, no implementar sus decisiones 1 y alternativa de repositorios. Fecha: 2026-10-25.

## Contexto
Hay dos repositorios nuevos, pero el requisito de producto solicita React y Java en un monorepositorio con microservicios Docker. La operación maneja datos escolares, pruebas con plazos y múltiples roles.

## Decisiones
1. Usar Vq-school-backend como raíz canónica con apps/web, services, contracts, infra y docs. Va-school-app sólo referencia el monorepo; no se borra, archiva ni duplica el frontend.
2. Tres servicios de negocio (school, learning, communication) y BFF técnico. School agrupa académico/inspectoría para evitar exceso de servicios.
3. Keycloak autentica; school autoriza membresía y relaciones. Sin copiar IDs manualmente.
4. BFF guarda tokens y sesión; navegador usa cookie y CSRF. Se prefiere a una SPA con tokens persistentes por reducir exposición en navegador.
5. Un realm por ambiente y colegios en membresías de aplicación. Un realm por colegio se reserva para exigencias de aislamiento/federación futuras.
6. Bases lógicas separadas por servicio; outbox/inbox + HTTP interno para eventos en MVP. Sin transacciones distribuidas, broker ni consultas cruzadas.
7. Docker Compose para piloto sin HA. IaC y proveedor se concretan en HU-36.
8. Apoderados como contactos, no quinto rol de portal. Anotaciones de inspectoría separadas de notas académicas.
9. Sitio público con plantilla y publicación controlada; no constructor libre.
10. Branches mediante PR y sin push directo. Protección efectiva sigue pendiente; no simularla mediante un documento.

## Consecuencias
Una raíz facilita cambios coordinados y contratos; cada servicio conserva imagen y migraciones propias. Se introduce coste operacional por microservicios, BFF, Keycloak y almacenamiento. Caída de School puede bloquear autorizaciones; se falla cerrado. Piloto de un host tiene interrupciones posibles. El alcance de exámenes es deliberadamente limitado a un intento y tres tipos de pregunta.

## Alternativas consideradas
Dos repos frontend/backend: no cumple el monorepositorio solicitado. Monolito modular: más simple operacionalmente, pero no satisface despliegue de microservicios solicitado. Microservicio por módulo/entidad: demasiado coste para piloto. Realm por colegio: mejor separación de configuración SSO, con mayor carga de provisión y operación. Token en localStorage: descartado en favor de BFF.

## Revisión
Revisar al elegir proveedor, incorporar un segundo cliente real o necesitar federación corporativa/HA. Registrar nuevo ADR si cambia la decisión; no cambiar silenciosamente los límites.
