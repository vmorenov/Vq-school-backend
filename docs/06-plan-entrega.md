# Plan de entrega y aceptación

## Estado real de la línea base
Entregado: definición y primera implementación de fundaciones en dos repositorios. El detalle de pruebas y limitaciones está en [estado de implementación](09-estado-implementacion.md). Las funcionalidades escolares, membresías, persistencia, hardening productivo y protección de ramas siguen pendientes. Esta base no equivale al MVP terminado.

## Incrementos
Todos forman parte del MVP completo. P0 y P1 priorizan el orden; P1 no significa fuera de alcance.

| Incremento | Resultado demostrable | HU |
|---|---|---|
| R0 Fundaciones | Arranque, identidad, colegios, permisos, contratos y archivos | 01–07, 39–40 |
| R1 Operación académica | Matrícula, horarios, notas y asistencia con consultas propias | 08–18 |
| R2 Aprendizaje y portal | Material, prueba completa, contenido público y bandeja | 19–29 |
| R3 Inspectoría y piloto | Correos, observaciones, retiros, citaciones, reportes y aceptación | 30–38 |

Backlog: 40 HU, 207 puntos orientativos de complejidad relativa. No son horas ni compromiso de fecha. Se debe recalibrar con el equipo tras HU-01/02. Trabajo horizontal como auditoría y autorización se implementa desde la primera historia que escribe datos; HU-34 consolida consulta y cobertura, no pospone controles hasta el final.

## Dependencias
HU-40 y HU-39 son fundaciones aunque su numeración esté al final. HU-07 bloquea módulos privados; HU-10/11 bloquean operación por curso; HU-22/23/24 son secuencia del examen; HU-30 habilita citaciones electrónicas. Las dependencias completas están en cada HU y en backlog.json. No hay ciclos.

No paralelizar modificaciones de contratos sin acuerdo de compatibilidad; no activar checks requeridos antes de que existan. No promoción a producción por mera creación de una rama.

## Definición de preparado
Objetivo y rol claros; criterios verificables; datos/permiso/estados identificados; dependencias resueltas o contrato acordado; diseño UI con carga/vacío/error; riesgos y prueba de aceptación acordados.

## Definición de terminado
- Criterios de la HU demostrados con evidencias y datos ficticios.
- Interfaz y API completas donde aplique; no sólo endpoint o maqueta.
- Autorización servidor, aislamiento, auditoría y validaciones correspondientes.
- Pruebas unitarias de reglas, integración DB/contratos y E2E de flujo crítico según el cambio; no porcentaje arbitrario de cobertura como sustituto.
- Migraciones y errores recuperables; concurrencia e idempotencia si aplica.
- Documentación, logs sin datos sensibles y controles de seguridad actualizados.
- Revisión por PR y CI verde; accesibilidad y uso móvil revisados.
- HU cerrada después de comprobar aceptación, nunca por generar código.

## Escenarios de aceptación del piloto
1. Administrador configura dos colegios ficticios, incorpora usuarios y demuestra que ninguno cruza datos.
2. Colegio A matricula alumnos, registra contacto de retiro, asigna docente y publica horario sin cruces.
3. Docente registra asistencia y nota; alumno sólo ve su nota publicada; inspector no puede modificarla.
4. Docente publica PDF limpio; alumno autorizado descarga; otro colegio, cuarentena y URL vencida fallan.
5. Alumno inicia examen, pierde conexión, recupera guardados y entrega una sola vez; vencimiento se aplica desde servidor.
6. Docente corrige pregunta abierta, libera después del cierre y sincroniza nota explícitamente; reintento no duplica.
7. Administrador publica noticia y campaña; visitante no ve borradores y el usuario sólo recibe su segmentación.
8. Inspector registra observación interna, retiro autorizado y citación; se diferencia email enviado de confirmación.
9. Desactivar membresía impide nuevas operaciones; cambiar IDs o rol en cliente no concede permisos.
10. Restaurar bases/objetos y verificar datos; probar rollback compatible y alerta por dependencia caída.

## Objetivos medibles propuestos
Carga inicial a validar: 1.000 alumnos por colegio piloto, 100 usuarios concurrentes y 50 intentos simultáneos. Lecturas API p95 <700 ms y errores <1% bajo carga acordada, excluyendo upload y proveedor de correo. UI objetivo WCAG 2.2 AA con teclado, contraste y formularios. RPO 24h / RTO 4h para piloto, verificados por ensayo. Son objetivos de aceptación, no resultados medidos ni SLA comercial.

## Riesgos y mitigaciones
- Expansión a ERP escolar: mantener exclusiones y refinamiento por incremento.
- Datos de menores: mínimos accesos, aislamiento y acuerdo de tratamiento/retención antes del piloto.
- Complejidad microservicios: tres dominios, REST y outbox; sin broker ni orquestación compleja inicial.
- Keycloak/provisión parcial: estados explícitos y reconciliación; no manualidad de IDs.
- Falta de red en exámenes: distinguir respuesta local de confirmada; autoguardado y expiración servidor.
- Caída de un host: backup probado y expectativas explícitas; no prometer HA.
- Ramas sin protección: bloquear promociones del piloto hasta HU-03 verificada.
