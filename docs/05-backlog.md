# Backlog del MVP

40 historias pendientes de implementación, agrupadas en 9 épicas y 4 incrementos. 207 puntos orientativos, no horas ni compromiso de plazo. P0 y P1 están incluidos en el MVP; indican orden de construcción.

## Épicas

| ID | Épica | HU | Puntos |
|---|---|---|---:|
| E01 | Plataforma e infraestructura | HU-01, HU-02, HU-03, HU-36, HU-39, HU-40 | 36 |
| E02 | Identidad, colegios y permisos | HU-04, HU-05, HU-06, HU-07 | 26 |
| E03 | Organización académica | HU-08, HU-09, HU-10, HU-11, HU-12, HU-13 | 22 |
| E04 | Notas, asistencia y reportes | HU-14, HU-15, HU-16, HU-17, HU-18, HU-38 | 29 |
| E05 | Aprendizaje y evaluaciones | HU-19, HU-20, HU-21, HU-22, HU-23, HU-24, HU-25 | 37 |
| E06 | Sitio público administrable | HU-26, HU-27 | 8 |
| E07 | Comunicaciones | HU-28, HU-29, HU-30 | 13 |
| E08 | Inspectoría y apoderados | HU-31, HU-32, HU-33 | 15 |
| E09 | Auditoría, seguridad y piloto | HU-34, HU-35, HU-37 | 21 |

## Trazabilidad de GitHub

| HU | Historia | Incremento | Prioridad | Puntos | Dependencias |
|---|---|---|---|---:|---|
| [HU-01](https://github.com/vmorenov/Vq-school-backend/issues/1) | Inicializar monorepositorio y herramientas | R0 | P0 | 5 | — |
| [HU-02](https://github.com/vmorenov/Vq-school-backend/issues/2) | Levantar entorno local con Docker Compose | R0 | P0 | 5 | HU-01 |
| [HU-03](https://github.com/vmorenov/Vq-school-backend/issues/3) | Configurar CI y promoción entre ambientes | R0 | P0 | 5 | HU-01 |
| [HU-04](https://github.com/vmorenov/Vq-school-backend/issues/4) | Configurar establecimientos y membresías | R0 | P0 | 5 | HU-01 |
| [HU-05](https://github.com/vmorenov/Vq-school-backend/issues/5) | Autenticarse con Keycloak y cerrar sesión | R0 | P0 | 5 | HU-01, HU-02 |
| [HU-06](https://github.com/vmorenov/Vq-school-backend/issues/6) | Gestionar usuarios y roles del colegio | R0 | P0 | 8 | HU-04, HU-05 |
| [HU-07](https://github.com/vmorenov/Vq-school-backend/issues/7) | Aplicar permisos por rol y relación académica | R0 | P0 | 8 | HU-04, HU-05, HU-06 |
| [HU-08](https://github.com/vmorenov/Vq-school-backend/issues/8) | Gestionar año académico y períodos | R1 | P0 | 3 | HU-04, HU-07 |
| [HU-09](https://github.com/vmorenov/Vq-school-backend/issues/9) | Gestionar cursos y asignaturas | R1 | P0 | 3 | HU-08 |
| [HU-10](https://github.com/vmorenov/Vq-school-backend/issues/10) | Matricular alumnos y registrar apoderados | R1 | P0 | 5 | HU-06, HU-09 |
| [HU-11](https://github.com/vmorenov/Vq-school-backend/issues/11) | Asignar profesores a cursos y asignaturas | R1 | P0 | 3 | HU-06, HU-09 |
| [HU-12](https://github.com/vmorenov/Vq-school-backend/issues/12) | Crear y consultar horarios | R1 | P0 | 5 | HU-10, HU-11 |
| [HU-13](https://github.com/vmorenov/Vq-school-backend/issues/13) | Ver inicio y asignaturas según perfil | R1 | P0 | 3 | HU-07, HU-10, HU-11, HU-12 |
| [HU-14](https://github.com/vmorenov/Vq-school-backend/issues/14) | Configurar escala y evaluaciones académicas | R1 | P0 | 5 | HU-08, HU-11 |
| [HU-15](https://github.com/vmorenov/Vq-school-backend/issues/15) | Registrar, publicar y corregir calificaciones | R1 | P0 | 8 | HU-10, HU-11, HU-14 |
| [HU-16](https://github.com/vmorenov/Vq-school-backend/issues/16) | Consultar notas y promedios personales | R1 | P0 | 3 | HU-15 |
| [HU-17](https://github.com/vmorenov/Vq-school-backend/issues/17) | Registrar y corregir asistencia por clase | R1 | P0 | 5 | HU-10, HU-11, HU-12 |
| [HU-18](https://github.com/vmorenov/Vq-school-backend/issues/18) | Consultar asistencia personal | R1 | P0 | 3 | HU-17 |
| [HU-19](https://github.com/vmorenov/Vq-school-backend/issues/19) | Publicar material pedagógico seguro | R2 | P1 | 5 | HU-07, HU-11, HU-39 |
| [HU-20](https://github.com/vmorenov/Vq-school-backend/issues/20) | Consultar y descargar materiales | R2 | P1 | 3 | HU-10, HU-19 |
| [HU-21](https://github.com/vmorenov/Vq-school-backend/issues/21) | Crear preguntas y pruebas en borrador | R2 | P1 | 5 | HU-11 |
| [HU-22](https://github.com/vmorenov/Vq-school-backend/issues/22) | Publicar y programar pruebas | R2 | P1 | 5 | HU-10, HU-21 |
| [HU-23](https://github.com/vmorenov/Vq-school-backend/issues/23) | Responder pruebas con autoguardado | R2 | P1 | 8 | HU-22 |
| [HU-24](https://github.com/vmorenov/Vq-school-backend/issues/24) | Corregir y publicar retroalimentación | R2 | P1 | 8 | HU-23 |
| [HU-25](https://github.com/vmorenov/Vq-school-backend/issues/25) | Consultar resultados y entregas | R2 | P1 | 3 | HU-24 |
| [HU-26](https://github.com/vmorenov/Vq-school-backend/issues/26) | Configurar identidad y estructura del sitio | R2 | P1 | 3 | HU-04, HU-07 |
| [HU-27](https://github.com/vmorenov/Vq-school-backend/issues/27) | Editar y publicar páginas y noticias | R2 | P1 | 5 | HU-26 |
| [HU-28](https://github.com/vmorenov/Vq-school-backend/issues/28) | Enviar avisos masivos por rol y curso | R2 | P1 | 5 | HU-06, HU-40 |
| [HU-29](https://github.com/vmorenov/Vq-school-backend/issues/29) | Consultar bandeja de notificaciones | R2 | P1 | 3 | HU-28 |
| [HU-30](https://github.com/vmorenov/Vq-school-backend/issues/30) | Enviar correos transaccionales y a apoderados | R3 | P1 | 5 | HU-10, HU-28, HU-40 |
| [HU-31](https://github.com/vmorenov/Vq-school-backend/issues/31) | Registrar observaciones de convivencia | R3 | P1 | 5 | HU-10, HU-07 |
| [HU-32](https://github.com/vmorenov/Vq-school-backend/issues/32) | Registrar retiros y retornos de alumnos | R3 | P1 | 5 | HU-10 |
| [HU-33](https://github.com/vmorenov/Vq-school-backend/issues/33) | Gestionar citaciones de apoderados | R3 | P1 | 5 | HU-10, HU-30 |
| [HU-34](https://github.com/vmorenov/Vq-school-backend/issues/34) | Consultar auditoría de operaciones sensibles | R3 | P1 | 5 | HU-07 |
| [HU-35](https://github.com/vmorenov/Vq-school-backend/issues/35) | Validar seguridad, aislamiento y privacidad | R3 | P1 | 8 | HU-07, HU-19, HU-27, HU-34 |
| [HU-36](https://github.com/vmorenov/Vq-school-backend/issues/36) | Preparar infraestructura y recuperación del piloto | R3 | P1 | 8 | HU-02, HU-03, HU-39 |
| [HU-37](https://github.com/vmorenov/Vq-school-backend/issues/37) | Validar piloto integral y experiencia de uso | R3 | P1 | 8 | HU-13, HU-16, HU-18, HU-20, HU-25, HU-27, HU-29, HU-31, HU-32, HU-33, HU-35, HU-36, HU-38 |
| [HU-38](https://github.com/vmorenov/Vq-school-backend/issues/38) | Consultar reportes básicos y exportar | R3 | P1 | 5 | HU-15, HU-17, HU-31, HU-32 |
| [HU-39](https://github.com/vmorenov/Vq-school-backend/issues/39) | Provisionar almacenamiento y ciclo de archivos | R0 | P0 | 5 | HU-02, HU-04 |
| [HU-40](https://github.com/vmorenov/Vq-school-backend/issues/40) | Integrar servicios con contratos e idempotencia | R0 | P0 | 8 | HU-01, HU-04, HU-05 |

## Criterios completos

### HU-01 — Inicializar monorepositorio y herramientas

Como **equipo técnico**, quiero **construir React y Java desde un checkout**.

- [ ] React/TypeScript en apps/web y Maven multimódulo Java 21 en services; versiones exactas y lockfiles, sin latest.
- [ ] Build, lint y pruebas reproducibles en CI y guía para un nuevo desarrollador.
- [ ] Cada servicio usa Dockerfile multi-stage y usuario no root; no comparte entidades JPA ni lógica de negocio.

Dependencias: ninguna. [Issue 1](https://github.com/vmorenov/Vq-school-backend/issues/1).

### HU-02 — Levantar entorno local con Docker Compose

Como **desarrollador**, quiero **ejecutar el sistema completo**.

- [ ] Un comando inicia web, proxy, BFF, tres servicios de negocio, Keycloak y dependencias con healthchecks.
- [ ] Bases lógicas y usuarios separados por servicio; volúmenes sobreviven reinicios.
- [ ] Seed exclusivamente ficticio de dos colegios y cuatro roles; smoke test de login y aislamiento; reset destructivo documentado.

Dependencias: HU-01. [Issue 2](https://github.com/vmorenov/Vq-school-backend/issues/2).

### HU-03 — Configurar CI y promoción entre ambientes

Como **equipo técnico**, quiero **promover artefactos verificables**.

- [ ] PR ejecuta build, lint, pruebas relevantes, contratos y escaneo de secretos/dependencias.
- [ ] develop, staging y master exigen PR, sin bypass, force push ni borrado; verificar reglas efectivas y checks existentes.
- [ ] Imágenes con SHA y mismo digest entre ambientes; aprobación de producción y secretos separados; forks sin secretos.
- [ ] Rollback de aplicación probado con migraciones compatibles; migraciones destructivas no se revierten automáticamente.

Dependencias: HU-01. [Issue 3](https://github.com/vmorenov/Vq-school-backend/issues/3).

### HU-04 — Configurar establecimientos y membresías

Como **administrador**, quiero **gestionar mi colegio con aislamiento**.

- [ ] Operador crea colegio; administrador sólo configura su nombre, contacto, zona horaria y parámetros.
- [ ] Membresía une issuer+sub, colegio, roles y estado; usuario multicolegio elige un ámbito autorizado.
- [ ] Servidor verifica colegio activo; cambiar slug, header o ID no concede acceso.
- [ ] Pruebas con dos colegios cubren lecturas, escrituras, listados, archivos y exportaciones.

Dependencias: HU-01. [Issue 4](https://github.com/vmorenov/Vq-school-backend/issues/4).

### HU-05 — Autenticarse con Keycloak y cerrar sesión

Como **usuario**, quiero **acceder con una identidad segura**.

- [ ] OIDC Authorization Code con PKCE en BFF; no formulario propio de contraseñas ni client_secret en navegador.
- [ ] Cookie HttpOnly, Secure en HTTPS y SameSite; tokens sólo en servidor; validación CSRF, state y nonce.
- [ ] Logout invalida sesión BFF y SSO; renovación fallida vuelve a login; APIs validan firma, issuer, audiencia y vigencia.
- [ ] MFA obligatorio para personal; recuperación supervisada para alumnos sin exigir correo personal.

Dependencias: HU-01, HU-02. [Issue 5](https://github.com/vmorenov/Vq-school-backend/issues/5).

### HU-06 — Gestionar usuarios y roles del colegio

Como **administrador**, quiero **provisionar usuarios sin SQL manual**.

- [ ] Alta, edición y desactivación de los cuatro roles desde aplicación; provisión idempotente en Keycloak.
- [ ] Vínculo automático por issuer+sub, nunca copiar IDs manualmente ni usar username como clave.
- [ ] Sólo se administran roles del colegio propio; no se otorgan privilegios de operador global.
- [ ] Fallo de provisión deja pendiente/error reintentable; cuenta parcial no se habilita.
- [ ] Desactivar membresía bloquea siguientes operaciones del colegio y preserva historial sin afectar otras membresías.

Dependencias: HU-04, HU-05. [Issue 6](https://github.com/vmorenov/Vq-school-backend/issues/6).

### HU-07 — Aplicar permisos por rol y relación académica

Como **responsable del colegio**, quiero **restringir cada operación a su ámbito**.

- [ ] Cada endpoint valida identidad, membresía activa, rol y relación con alumno/curso/asignatura.
- [ ] Alumno sólo ve sus datos; profesor sólo modifica asignaturas/cursos asignados.
- [ ] Inspector registra anotaciones, salidas y citaciones, nunca calificaciones; administrador no califica sin rol docente y asignación.
- [ ] UI y servidor aplican permisos; pruebas negativas cubren 401/403/404 sin filtrar datos y usuarios multirrol entre colegios.

Dependencias: HU-04, HU-05, HU-06. [Issue 7](https://github.com/vmorenov/Vq-school-backend/issues/7).

### HU-08 — Gestionar año académico y períodos

Como **administrador**, quiero **organizar ciclos y cierres**.

- [ ] Año y períodos tienen fechas válidas no solapadas; sólo uno vigente.
- [ ] Cierre bloquea nuevas notas y cambios ordinarios de asistencia.
- [ ] Reapertura exige permiso y motivo auditado; no convierte administrador en docente.
- [ ] Historial conserva año/período/matrícula al cambiar de ciclo.

Dependencias: HU-04, HU-07. [Issue 8](https://github.com/vmorenov/Vq-school-backend/issues/8).

### HU-09 — Gestionar cursos y asignaturas

Como **administrador**, quiero **representar la estructura académica**.

- [ ] Crear niveles, cursos/secciones y asignaturas por año con unicidad en su ámbito.
- [ ] Asignaciones rechazan referencias de otro colegio.
- [ ] Desactivar conserva historial; no hay borrado destructivo con dependencias.
- [ ] Listados paginados filtrables por año y estado.

Dependencias: HU-08. [Issue 9](https://github.com/vmorenov/Vq-school-backend/issues/9).

### HU-10 — Matricular alumnos y registrar apoderados

Como **administrador**, quiero **vincular estudiantes y contactos responsables**.

- [ ] Máximo una matrícula activa por colegio/año en MVP; traslado conserva historial y fechas.
- [ ] Contactos registran parentesco, teléfono, correo opcional, prioridad y autorización de retiro.
- [ ] Apoderado es contacto sin portal en MVP; datos sólo para personal autorizado.
- [ ] Se rechazan duplicados y referencias ajenas; alumno no consulta contactos de compañeros.

Dependencias: HU-06, HU-09. [Issue 10](https://github.com/vmorenov/Vq-school-backend/issues/10).

### HU-11 — Asignar profesores a cursos y asignaturas

Como **administrador**, quiero **definir responsables académicos**.

- [ ] Asignación incluye profesor/curso/asignatura/año/vigencia y co-docencia explícita.
- [ ] No admite docentes inactivos o de otro colegio.
- [ ] Retirar asignación revoca nuevas modificaciones y conserva autoría.
- [ ] Notas, asistencia, materiales y pruebas usan esta relación para autorizar.

Dependencias: HU-06, HU-09. [Issue 11](https://github.com/vmorenov/Vq-school-backend/issues/11).

### HU-12 — Crear y consultar horarios

Como **administrador y alumno**, quiero **organizar y consultar clases**.

- [ ] Publicar horario semanal con bloque, asignatura, profesor y sala opcional.
- [ ] Rechazar solapamientos de curso, docente y sala informada; cambios tienen vigencia.
- [ ] Alumno consulta su curso y profesor sus bloques en zona horaria del colegio.
- [ ] Historial preservado y estado vacío si no hay horario publicado.

Dependencias: HU-10, HU-11. [Issue 12](https://github.com/vmorenov/Vq-school-backend/issues/12).

### HU-13 — Ver inicio y asignaturas según perfil

Como **alumno y profesor**, quiero **encontrar mis actividades**.

- [ ] Alumno ve asignaturas/clases del día y enlaces a notas, asistencia, material y pruebas.
- [ ] Profesor ve sus cursos; administrador e inspector tienen navegación de su rol.
- [ ] Contadores y enlaces sólo incluyen recursos autorizados; no hay datos simulados presentados como reales.
- [ ] Móvil/escritorio con estados carga, error, vacío y sesión expirada.

Dependencias: HU-07, HU-10, HU-11, HU-12. [Issue 13](https://github.com/vmorenov/Vq-school-backend/issues/13).

### HU-14 — Configurar escala y evaluaciones académicas

Como **administrador y profesor**, quiero **aplicar reglas de calificación consistentes**.

- [ ] Colegio define escala, aprobación y redondeo; propuesta piloto 1,0–7,0.
- [ ] Profesor define evaluación, fecha y ponderación; suma publicada del período debe ser 100%.
- [ ] Ausente, pendiente y eximido no son cero; promedio definitivo sólo con evaluaciones resueltas.
- [ ] Reglas usadas por notas publicadas se versionan; cambios no reescriben resultados históricos.

Dependencias: HU-08, HU-11. [Issue 14](https://github.com/vmorenov/Vq-school-backend/issues/14).

### HU-15 — Registrar, publicar y corregir calificaciones

Como **profesor**, quiero **entregar notas trazables**.

- [ ] Guardar borrador/publicar valida rango, matrícula, asignación y período abierto.
- [ ] Alumno no ve borrador; publicación guarda autor/fecha/versión.
- [ ] Corregir publicado exige motivo y valor anterior/nuevo; control optimista evita sobrescritura concurrente.
- [ ] Inspector y administrador sin rol docente no califican.
- [ ] Publicación emite evento sin nota en correo ni logs generales.

Dependencias: HU-10, HU-11, HU-14. [Issue 15](https://github.com/vmorenov/Vq-school-backend/issues/15).

### HU-16 — Consultar notas y promedios personales

Como **alumno**, quiero **conocer mi rendimiento**.

- [ ] Sólo notas propias publicadas con evaluación, fecha y ponderación.
- [ ] Promedio muestra fórmula, redondeo y estado provisional si faltan evaluaciones.
- [ ] Pruebas cubren límites decimales, ausente/eximido y ponderaciones.
- [ ] Cambiar ID de alumno o colegio no revela calificaciones ni metadatos.

Dependencias: HU-15. [Issue 16](https://github.com/vmorenov/Vq-school-backend/issues/16).

### HU-17 — Registrar y corregir asistencia por clase

Como **profesor**, quiero **registrar participación de mi curso**.

- [ ] Sesión única curso/asignatura/fecha/bloque y registro único por alumno.
- [ ] Estados presente, ausente, atrasado y justificado; pendiente no equivale a ausencia.
- [ ] Idempotencia evita duplicados y control de versión detecta ediciones concurrentes.
- [ ] Corrección exige motivo y período abierto; no se crean ausencias por falta de registro.
- [ ] Indicador es asistencia por clase, no libro oficial de asistencia diaria.

Dependencias: HU-10, HU-11, HU-12. [Issue 17](https://github.com/vmorenov/Vq-school-backend/issues/17).

### HU-18 — Consultar asistencia personal

Como **alumno**, quiero **revisar asistencias y atrasos**.

- [ ] Filtros por período, asignatura y fecha con sesiones registradas.
- [ ] Indicador base = presentes+atrasados dividido por sesiones con estado definitivo; justificado cuenta como no asistido.
- [ ] Mostrar numerador, denominador y pendientes; sin registros mostrar sin datos.
- [ ] Alumno no edita asistencia ni ve la de otros.

Dependencias: HU-17. [Issue 18](https://github.com/vmorenov/Vq-school-backend/issues/18).

### HU-19 — Publicar material pedagógico seguro

Como **profesor**, quiero **compartir recursos de mis clases**.

- [ ] Crear título, descripción, curso/asignatura y PDF o enlace HTTPS, sólo para asignaciones propias.
- [ ] PDF máximo 20 MB, tipo real/extensión/tamaño validados y cuarentena hasta escaneo limpio.
- [ ] Pendiente o rechazado no descargable; nombre original no determina ruta.
- [ ] Borrador/publicado/archivado, versión y cuota inicial configurable de 5 GB por colegio.
- [ ] Objetos privados; ejemplos sin datos reales de alumnos.

Dependencias: HU-07, HU-11, HU-39. [Issue 19](https://github.com/vmorenov/Vq-school-backend/issues/19).

### HU-20 — Consultar y descargar materiales

Como **alumno**, quiero **estudiar con recursos autorizados**.

- [ ] Listar sólo material publicado de asignaturas de matrícula vigente.
- [ ] Descarga revalida membresía/curso y genera URL firmada de 60 segundos, sin listar bucket.
- [ ] Recurso retirado/no disponible informa error sin revelar claves internas.
- [ ] Pruebas de otro colegio/curso, URL expirada y cuarentena.

Dependencias: HU-10, HU-19. [Issue 20](https://github.com/vmorenov/Vq-school-backend/issues/20).

### HU-21 — Crear preguntas y pruebas en borrador

Como **profesor**, quiero **preparar test y ensayos**.

- [ ] Selección única, verdadero/falso y respuesta abierta con enunciado/orden/puntaje positivo.
- [ ] Objetivas tienen exactamente una respuesta correcta; abiertas tienen pauta privada.
- [ ] Total suma puntajes y prueba vacía/inválida no publicable.
- [ ] Soluciones/pautas nunca aparecen en DTOs ni HTML para alumnos.

Dependencias: HU-11. [Issue 21](https://github.com/vmorenov/Vq-school-backend/issues/21).

### HU-22 — Publicar y programar pruebas

Como **profesor**, quiero **habilitar una evaluación con plazos**.

- [ ] Elegir curso, apertura, cierre y duración coherentes mostrando zona horaria.
- [ ] Un intento por alumno/prueba; sólo matrícula autorizada puede iniciar.
- [ ] Publicar crea versión inmutable; intentos existentes no cambian al editar borrador de otra versión.
- [ ] Cancelar conserva intentos y motivo y avisa sin calificar cero.
- [ ] Resultados sólo se liberan por docente después del cierre.

Dependencias: HU-10, HU-21. [Issue 22](https://github.com/vmorenov/Vq-school-backend/issues/22).

### HU-23 — Responder pruebas con autoguardado

Como **alumno**, quiero **entregar sin perder respuestas confirmadas**.

- [ ] Intento creado una sola vez concurrentemente; vence en min(cierre,inicio+duración) según servidor.
- [ ] Autoguardado confirma versión/hora; reintentos idempotentes no duplican ni pisan versiones nuevas.
- [ ] Entregar o vencer bloquea respuestas; job finaliza aun con navegador cerrado.
- [ ] Reconexión recupera sólo respuestas confirmadas; no acepta respuestas tardías.
- [ ] UI informa guardado/error y tiempo accesible, confirma entrega y nunca revela soluciones.

Dependencias: HU-22. [Issue 23](https://github.com/vmorenov/Vq-school-backend/issues/23).

### HU-24 — Corregir y publicar retroalimentación

Como **profesor**, quiero **evaluar respuestas y devolver resultados**.

- [ ] Objetivas corregidas en servidor contra versión del intento; abiertas requieren puntaje manual válido.
- [ ] Sólo docente asignado ve respuestas; no publica con abiertas pendientes ni antes del cierre.
- [ ] Rectificar exige motivo e historial.
- [ ] Pasar resultado a nota es acción explícita con fórmula y evaluación destino; idempotencia evita dos notas.
- [ ] Si school-service falla, sincronización queda pendiente/error visible y reintentable.

Dependencias: HU-23. [Issue 24](https://github.com/vmorenov/Vq-school-backend/issues/24).

### HU-25 — Consultar resultados y entregas

Como **alumno y profesor**, quiero **comprender resultados y pendientes**.

- [ ] Alumno sólo consulta su intento y retroalimentación liberada.
- [ ] Docente filtra entregados/en curso/vencidos/no iniciados de sus cursos.
- [ ] No iniciado difiere de cero y no genera nota automática.
- [ ] Soluciones visibles sólo después de cierre y liberación; listados paginados y autorizados.

Dependencias: HU-24. [Issue 25](https://github.com/vmorenov/Vq-school-backend/issues/25).

### HU-26 — Configurar identidad y estructura del sitio

Como **administrador**, quiero **presentar mi establecimiento**.

- [ ] Configurar logo, colores accesibles, contacto, descripción, menú y slug único.
- [ ] Plantilla con inicio, colegio, noticias y contacto; sin scripts/CSS arbitrarios ni plugins.
- [ ] Imágenes públicas validadas y separadas de archivos privados.
- [ ] Vista previa privada no publica cambios ni incluye expedientes.

Dependencias: HU-04, HU-07. [Issue 26](https://github.com/vmorenov/Vq-school-backend/issues/26).

### HU-27 — Editar y publicar páginas y noticias

Como **administrador y visitante**, quiero **mantener contenido público actualizado**.

- [ ] Borrador/publicado/archivado con vista previa autorizada y autor de publicación.
- [ ] Sanitización servidor elimina scripts, atributos y URLs peligrosas.
- [ ] Visitante sólo obtiene publicado del slug; borradores ausentes de API, HTML y caché.
- [ ] Rutas públicas entregan HTML indexable mediante SSR/prerender con título, descripción y sitemap.
- [ ] Archivar invalida caché y registra revisión; rutas inexistentes devuelven 404.

Dependencias: HU-26. [Issue 27](https://github.com/vmorenov/Vq-school-backend/issues/27).

### HU-28 — Enviar avisos masivos por rol y curso

Como **administrador**, quiero **comunicar avisos segmentados**.

- [ ] Seleccionar roles/curso, redactar y confirmar resumen con cantidad de destinatarios.
- [ ] Servidor resuelve membresías activas del colegio, congela destinatarios y deduplica multirrol.
- [ ] Campaña idempotente y asíncrona muestra pendiente/enviado/error por canal.
- [ ] Sólo administrador de ese colegio; texto sanitizado, sin adjuntar expedientes.
- [ ] Desactivados no reciben nuevos envíos; fallo individual no bloquea otros.

Dependencias: HU-06, HU-40. [Issue 28](https://github.com/vmorenov/Vq-school-backend/issues/28).

### HU-29 — Consultar bandeja de notificaciones

Como **usuario**, quiero **recibir y revisar comunicaciones**.

- [ ] Bandeja propia del colegio activo con paginación, fecha y estado.
- [ ] Marcar leído es idempotente y no implica entrega externa ni aceptación de citación.
- [ ] Enlace interno revalida permiso de destino.
- [ ] Membresía desactivada no recupera avisos con sesión previa.

Dependencias: HU-28. [Issue 29](https://github.com/vmorenov/Vq-school-backend/issues/29).

### HU-30 — Enviar correos transaccionales y a apoderados

Como **personal autorizado**, quiero **entregar invitaciones y citaciones**.

- [ ] SMTP de Keycloak para acceso y worker de communication para avisos, sin secretos frontend.
- [ ] Contacto responsable validado; sin correo queda entrega manual pendiente.
- [ ] Registrar intentos y aceptación del proveedor; no afirmar lectura; rebotes sólo con webhook autenticado.
- [ ] Backoff y límite de reintentos con control de duplicados y fallos visibles.
- [ ] Correo mínimo sin notas, respuestas ni observaciones disciplinarias; detalles en canal autorizado.

Dependencias: HU-10, HU-28, HU-40. [Issue 30](https://github.com/vmorenov/Vq-school-backend/issues/30).

### HU-31 — Registrar observaciones de convivencia

Como **inspector**, quiero **documentar anotaciones del alumno**.

- [ ] Observación positiva/negativa/informativa con fecha, autor y alumno del colegio.
- [ ] Anotación es distinta de calificación y nunca cambia promedios.
- [ ] Por defecto interna a inspectores; versión expresamente visible sólo al alumno afectado.
- [ ] Corrección/anulación con motivo e historial, sin borrado destructivo.
- [ ] No accesible a compañeros ni docentes no autorizados ni otro colegio.

Dependencias: HU-10, HU-07. [Issue 31](https://github.com/vmorenov/Vq-school-backend/issues/31).

### HU-32 — Registrar retiros y retornos de alumnos

Como **inspector**, quiero **documentar salidas de la jornada**.

- [ ] Registrar alumno/hora/motivo/persona que retira y verificación de autorización; registro no sustituye control físico.
- [ ] No dos salidas abiertas simultáneas; control de concurrencia.
- [ ] Persona no autorizada exige resolución explícita del responsable designado y motivo, nunca aprobación automática.
- [ ] Retorno o anulación con motivo; distinguir salida definitiva del día.
- [ ] No cambia asistencia histórica automáticamente; resumen diario por colegio.

Dependencias: HU-10. [Issue 32](https://github.com/vmorenov/Vq-school-backend/issues/32).

### HU-33 — Gestionar citaciones de apoderados

Como **inspector**, quiero **coordinar reuniones y seguimiento**.

- [ ] Registrar alumno/contacto/motivo interno/fecha/hora/lugar/convocante.
- [ ] Estados borrador, emitida, confirmada manualmente, realizada, no asistió y cancelada con historial.
- [ ] Email o constancia imprimible no confirma recepción; confirmación registra responsable/evidencia mínima.
- [ ] Reprogramar crea revisión y aviso, sin duplicar; cierre con resultado interno.
- [ ] Apoderado sin cuenta de portal; enlaces públicos nunca exponen expediente del menor.

Dependencias: HU-10, HU-30. [Issue 33](https://github.com/vmorenov/Vq-school-backend/issues/33).

### HU-34 — Consultar auditoría de operaciones sensibles

Como **administrador autorizado**, quiero **investigar cambios trazables**.

- [ ] Notas/asistencia/roles/publicaciones/observaciones/retiros/citaciones guardan actor/colegio/instante/entidad/acción/correlationId.
- [ ] Auditoría y cambio sensible son transaccionales; fallo de auditoría impide confirmar cambio.
- [ ] Sin edición/borrado por API; detalle exige permiso de dominio además de consulta de auditoría.
- [ ] Logs sin tokens/contraseñas/respuestas/expedientes; retención acordada antes de datos reales.
- [ ] Consulta por fecha/actor acotada y paginada.

Dependencias: HU-07. [Issue 34](https://github.com/vmorenov/Vq-school-backend/issues/34).

### HU-35 — Validar seguridad, aislamiento y privacidad

Como **responsable del piloto**, quiero **proteger datos escolares**.

- [ ] Pruebas negativas con dos colegios cubren IDOR, elevación, CSRF, XSS y exposición de soluciones.
- [ ] Revocación, archivos maliciosos, tokens inválidos y acceso interno no autorizado se rechazan.
- [ ] Inventario de datos/propósito/acceso/retención aprobado por colegio antes de menores reales.
- [ ] Backups, capturas, fixtures y repos públicos sin secretos ni datos reales.
- [ ] Sin vulnerabilidades críticas/altas explotables pendientes en alcance; no se declara certificación legal.

Dependencias: HU-07, HU-19, HU-27, HU-34. [Issue 35](https://github.com/vmorenov/Vq-school-backend/issues/35).

### HU-36 — Preparar infraestructura y recuperación del piloto

Como **operador**, quiero **desplegar y recuperar el servicio**.

- [ ] IaC del proveedor elegido incluye host, redes/firewall, DNS/TLS y almacenamiento; staging aislado de producción.
- [ ] Sólo HTTPS de aplicación/auth público; DB, Redis, almacenamiento privado y consolas no expuestos.
- [ ] Secretos fuera de Git, cifrado en reposo según proveedor, límites y alertas de salud/error/ocupación.
- [ ] Backup diario cifrado de DB/objetos restaurado en entorno aislado; objetivos piloto RPO 24h y RTO 4h medidos.
- [ ] Keycloak productivo con issuer canónico, sin start-dev; rollback y migraciones compatibles ensayados.

Dependencias: HU-02, HU-03, HU-39. [Issue 36](https://github.com/vmorenov/Vq-school-backend/issues/36).

### HU-37 — Validar piloto integral y experiencia de uso

Como **equipo del colegio**, quiero **aceptar el MVP con flujos reales**.

- [ ] Demostrar colegio/usuarios → matrícula/horario → notas/asistencia → material/test → respuesta/corrección → comunicación/inspector.
- [ ] Cuatro perfiles validan móvil/escritorio y teclado/foco/contraste/formularios con objetivo WCAG 2.2 AA.
- [ ] Carga propuesta: 100 usuarios concurrentes, 50 intentos simultáneos, lectura API p95 <700ms y errores <1%, sin upload/SMTP.
- [ ] Ensayar desconexión de prueba, entrega concurrente, correo caído y restauración; sin pérdida de respuestas confirmadas.
- [ ] Acta del colegio registra aceptación y pendientes; código o CI aprobado no equivale a MVP entregado.

Dependencias: HU-13, HU-16, HU-18, HU-20, HU-25, HU-27, HU-29, HU-31, HU-32, HU-33, HU-35, HU-36, HU-38. [Issue 37](https://github.com/vmorenov/Vq-school-backend/issues/37).

### HU-38 — Consultar reportes básicos y exportar

Como **profesor e inspector**, quiero **revisar datos de mi ámbito**.

- [ ] Profesor reporta notas/asistencia de cursos asignados; inspector observaciones/retiros del colegio.
- [ ] Filtros de período/curso/fecha y límites en exportaciones; auditoría del actor y alcance.
- [ ] CSV neutraliza fórmulas y nunca mezcla colegios.
- [ ] Administrador sin rol de dominio no recibe expedientes; reportes no se presentan como certificados oficiales.

Dependencias: HU-15, HU-17, HU-31, HU-32. [Issue 38](https://github.com/vmorenov/Vq-school-backend/issues/38).

### HU-39 — Provisionar almacenamiento y ciclo de archivos

Como **operador y docente**, quiero **conservar recursos con acceso controlado**.

- [ ] S3 compatible separa recursos públicos/privados; claves por colegio e ID aleatorio.
- [ ] Cuarentena y escaneo, cuotas y limpieza de cargas incompletas; job reconcilia metadata/objeto.
- [ ] Carga fallida nunca publicable; retiro respeta historial y retención.
- [ ] Backup/restauración conserva asociación; URLs firmadas no se registran en logs públicos.

Dependencias: HU-02, HU-04. [Issue 39](https://github.com/vmorenov/Vq-school-backend/issues/39).

### HU-40 — Integrar servicios con contratos e idempotencia

Como **equipo técnico**, quiero **resistir fallos parciales**.

- [ ] OpenAPI versionado define DTO/errores/paginación/auth; ningún servicio consulta tablas ajenas.
- [ ] school expone decisiones de membresía/curso/asignatura/relación; consumidores fallan cerrado si no responde.
- [ ] Eventos y cambio se guardan en outbox transaccional; worker entrega por HTTP interno autenticado.
- [ ] communication deduplica eventId/destinatario; reintentos con backoff y cola de fallos visible.
- [ ] Client credentials sólo técnico; no sustituye identidad de usuario para expedientes; correlationId y pruebas de contrato ante caídas.

Dependencias: HU-01, HU-04, HU-05. [Issue 40](https://github.com/vmorenov/Vq-school-backend/issues/40).


## Definición de terminado común

Consultar [plan y aceptación](06-plan-entrega.md). Cada historia exige evidencia de criterios, permisos/aislamiento y pruebas apropiadas, además de implementación, revisión y documentación. Auditoría se integra desde la primera operación sensible; no se posterga al incremento R3. Las issues y este documento constituyen planificación, no funcionalidades terminadas.

[Backlog legible por herramientas](backlog.json).
