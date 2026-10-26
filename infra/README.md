# Infraestructura objetivo

**Diseño pendiente de implementación en HU-02, HU-03, HU-36 y HU-39.** No hay despliegue ejecutable en esta línea base.

## Topología propuesta
Piloto en host Linux Docker Engine + Compose. Staging y producción separados; bases/secretos/volúmenes y datos independientes. Proveedor y región por decidir con el colegio. No se contrata infraestructura en esta entrega.

| Unidad | Red y persistencia |
|---|---|
| Reverse proxy | Única entrada HTTPS 443; 80 sólo redirección/validación TLS según mecanismo |
| Web React | Acceso vía proxy, sin secretos; SSR/prerender de páginas públicas |
| BFF | Sólo proxy; Redis con sesiones/tokens y políticas de expiración |
| School/Learning/Communication | Red interna; endpoints técnicos con credenciales/scopes limitados |
| PostgreSQL | Red privada, cuatro bases/usuarios separados (tres dominios + Keycloak) |
| Keycloak | Autenticación HTTPS, consola administrativa restringida; hostname canónico |
| S3 compatible | Buckets privados/material y públicos/CMS separados, cuarentena |
| Escáner archivos | Red privada, cola/estado de escaneo y actualización de firmas |
| Worker de correo | Credenciales SMTP privadas, reintento e idempotencia |
| Observabilidad | Logs estructurados, métricas y alertas privadas |
| Backup | Destino cifrado fuera del host, credencial y retención propias |

## Archivos a producir durante implementación
- compose.yaml para desarrollo, con healthchecks, perfiles y volúmenes.
- compose.staging.yaml y compose.production.yaml o paquetes equivalentes probados.
- .env.example con nombres y valores ficticios; secretos mediante archivos montados/gestor, nunca valores reales en Git.
- Keycloak realm/client bootstrap sin usuarios reales ni secretos exportados.
- IaC declarativa del proveedor seleccionado (OpenTofu/Terraform o equivalente) y procedimiento de aprovisionamiento.
- Scripts de migración, backup, restauración y smoke test.
- Runbook de incidentes y manifiesto de versiones/digests desplegados.

## Seguridad operacional
No mapear a 0.0.0.0 puertos de DB/Redis/storage/administración. Firewall de mínimo acceso; SSH si existe, restringido a operadores autorizados. TLS válido en staging/producción. Keycloak start-dev sólo en local. Certificados/hostnames consistentes con issuer; no desactivar validación SSL para arreglar un error.

Contenedores no root cuando soportado, imágenes fijadas, límites CPU/memoria, health/readiness, política de reinicio, espacio y rotación de logs. Secrets de Compose limitan exposición por servicio pero no sustituyen cifrado en reposo ni un gestor de secretos productivo.

## Promoción
Feature PR → develop con CI → staging con integración y E2E → master con aprobación de despliegue. Construir una vez y promover digest. Bases con migración previa compatible; un rollback de imagen no deshace un cambio de esquema. El README debe ofrecer instrucciones reales únicamente cuando existan esos comandos.

## Recuperación
Backup diario consistente de bases y objetos con retención propuesta de 30 días, pendiente de política del colegio. Backups cifrados fuera del host y verificación periódica. Restauración aislada y smoke funcional para medir RPO 24h y RTO 4h. Recuperar Keycloak/configuración junto con datos de identidades; no restaurar secretos obsoletos indiscriminadamente. Borrado físico y política de retención requieren acuerdo previo.

## Coste y capacidad
Sin estimación de factura hasta elegir proveedor/región, disponibilidad y cantidad de alumnos. Medir memoria de cuatro JVM + Keycloak, DB, storage/escáner y margen antes de fijar tamaño. No se asume que todos los componentes caben en una VM pequeña ni se promete un precio mensual.
