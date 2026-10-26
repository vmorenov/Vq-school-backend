# Estado de implementación — primera base técnica

## Implementado
- Monorepositorio Java 21/Spring Boot 3.5.16 con BFF y tres servicios empaquetables por separado.
- BFF: registro OIDC confidencial explícito, Authorization Code + PKCE, sesión HttpOnly, CSRF, logout OIDC y proxy de capacidades limitado a tres destinos.
- APIs internas con JWT, validación de issuer/audiencia/tiempo y health público sin detalles sensibles.
- Frontend en Va-school-app: shell React, dos remotos Module Federation, web pública prerenderizada, contratos y UI compartida, fallback y estados vacíos.
- Dockerfiles por aplicación, Compose local integrado con Keycloak/PostgreSQL, generación local de secretos y smoke script.
- CI de compilación/pruebas/imágenes, contrato OpenAPI de la base y trazabilidad de 40 HU hacia 18 tareas frontend.

## Validación ejecutada
| Comprobación | Resultado |
|---|---|
| Maven verify con JDK 21 | Correcto: 24 pruebas, 0 fallos/errores, 0 omitidas; cuatro JAR ejecutables |
| TypeScript estricto | Correcto |
| Vitest | 8 pruebas correctas |
| Build frontend | Cuatro aplicaciones; web pública prerenderizada |
| Playwright | 4 pruebas correctas: bundles remotos reales, caída de remoto, visitante anónimo y móvil |
| Revisión visual | Portal revisado en escritorio y móvil con datos sintéticos |
| npm audit de dependencias productivas | 0 vulnerabilidades informadas en esta ejecución; no cubre herramientas dev ni imágenes |
| Backlog | 40 HU, 18 tareas FE, enlaces válidos estructuralmente y dependencias sin ciclos |
| Compose/OpenAPI | YAML y dependencias estructurales verificados; 11 servicios locales |
| Secretos locales | Generación probada sin sobrescribir y .env excluido de Git |

Los E2E cargan los bundles reales, pero **simulan sesión y respuestas API**. No son pruebas de login real. Chromium de pruebas se obtuvo de @sparticuz/chromium porque la descarga habitual no estaba disponible; `CHROMIUM_EXECUTABLE` permite señalar un binario alternativo. CI utiliza la instalación normal de Playwright. No se desactivó CORS ni la seguridad web para hacer pasar federación.

## No validado aquí
No hay Docker disponible: no se construyeron imágenes, no se ejecutó Compose ni se validó SSO completo contra Keycloak. Los Dockerfiles y workflows quedan preparados para validarlo en una máquina con Docker/CI; no se afirma que CI remota ya esté verde. No hubo despliegue en staging/producción.

## Pendiente funcional y técnico
Membresías/colegios y autorización de dominio, provisión de usuarios desde aplicación, MFA/recuperación, datos y Flyway de los servicios, horarios/notas/asistencia, material/pruebas, CMS dinámico, inspectoría, notificaciones y outbox. El BFF guarda sesiones en memoria: reiniciar exige login; Redis y escalado horizontal siguen pendientes. Tampoco se implementaron almacenamiento/escaneo, backups, observabilidad completa, reglas de promoción ni protección de ramas.

La imagen y el Compose son de desarrollo; usan HTTP local y un usuario sintético. No sirven para operar con datos reales. La base permite continuar HU-04/06/07 y luego el primer flujo académico, sin cerrar prematuramente las HU fundacionales.

## Siguiente corte recomendado
Persistencia de School, dos colegios ficticios, membresías por issuer+sub y selección de colegio; luego aprovisionamiento de usuarios y autorización por curso. Completar integración real BFF/Keycloak en Docker antes de exponer información académica. Frontend FE-04/05 consume esos contratos sin introducir tokens en el navegador.
