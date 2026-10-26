# Roles, autorización y datos

## Matriz de permisos
“Propio” significa recurso del usuario dentro de su colegio activo. “Asignado” requiere relación docente vigente. Los permisos nunca dependen sólo de ocultar un botón.

| Acción | Alumno | Profesor | Administrador | Inspector |
|---|---|---|---|---|
| Ver sitio publicado | Sí | Sí | Sí | Sí |
| Gestionar usuarios/roles del colegio | No | No | Sí | No |
| Configurar años/cursos/asignaturas/matrículas | No | No | Sí | No |
| Registrar contactos y autorizaciones de retiro | No | No | Sí | Consultar para su función |
| Publicar horario | No | No | Sí | No |
| Consultar horario | Propio | Asignado | Colegio | Colegio |
| Registrar/publicar notas | No | Asignado | No por defecto | No |
| Ver calificaciones | Propias | Asignado | No por defecto | No |
| Registrar/corregir asistencia | No | Asignado | No por defecto | No |
| Consultar asistencia | Propia | Asignado | No por defecto | Resumen necesario para inspectoría |
| Publicar material/pruebas y corregir | No | Asignado | No por defecto | No |
| Responder pruebas | Propias | No | No | No |
| Descargar material privado | Matrícula | Asignado | No por defecto | No |
| Publicar CMS / campaña masiva | No | No | Colegio | No |
| Consultar bandeja | Propia | Propia | Propia | Propia |
| Registrar observaciones/retiros/citaciones | No | No | No por defecto | Colegio |
| Leer observaciones | Sólo las liberadas para sí | No por defecto | No por defecto | Colegio |
| Consultar auditoría | No | Sus cambios vía dominio | Metadatos; detalle con rol de dominio | Su dominio |

Un administrador que también sea profesor/inspector recibe esos permisos por membresía explícita y asignación cuando corresponda. El operador de plataforma es una función técnica de aprovisionamiento, no un quinto perfil escolar de uso diario ni un permiso implícito de lectura de expedientes.

## Política de autorización
1. Validar JWT: firma, issuer, audiencia, vigencia.
2. Resolver persona por (issuer, sub), no por email, username ni IDs editables por usuario.
3. Verificar membresía activa del colegio seleccionado.
4. Exigir rol y relación del recurso: matrícula, asignación docente o función de inspectoría.
5. Ejecutar consulta filtrada por colegio y ámbito de usuario; comprobar referencias cruzadas.
6. Auditar modificaciones sensibles en la misma transacción.
7. Responder sin filtrar existencia ajena. Datos inexistentes/no accesibles pueden responder 404; acción conocida sin permiso, 403.

IDs UUID son identificadores, no controles de acceso. No confiar en schoolId enviado por formulario. Las FK compuestas con school_id refuerzan consistencia dentro de cada base. PostgreSQL RLS puede ser defensa adicional sólo si se prueba el contexto con pool de conexiones; no sustituye filtros y autorización de aplicación.

## Keycloak y provisión
Un realm por ambiente del producto en piloto. Cliente BFF confidencial con redirects exactos. Clientes técnicos separados para outbox y provisión, con scopes mínimos. No entregar realm-admin al frontend ni usar credenciales administrativas generales para el runtime.

School controla membresías y proceso de provisión: PENDING → ACTIVE o ERROR reintentable. No se requiere copiar IDs manualmente. Desactivar membresía bloquea el colegio inmediatamente; si usuario conserva otro colegio, no se desactiva globalmente en Keycloak. Recuperación para alumnos puede ser asistida y auditada; sin contraseñas temporales en logs o issues.

## Sesión y APIs
Cookie HttpOnly, Secure en HTTPS y SameSite coherente con redirect; renovación del ID tras login. CSRF para acciones del navegador, CORS sólo origen propio, CSP y sanitización CMS. APIs de servicios reciben Bearer desde BFF y no se exponen directamente a Internet.

Endpoints internos de eventos usan client credentials con audience/scope específicos. Autorización de dominio usa token delegado del usuario; un token técnico no puede leer notas de cualquier alumno. No fabricar headers de identidad a partir de input externo.

## Datos escolares y publicación
Repositorio público sólo contiene código/configuración sin secretos y fixtures sintéticos. No se publican alumnos, apoderados, notas, asistencia, pruebas reales ni capturas con información personal. Logs técnicos minimizados; auditoría sensible separada y autorizada. Backups cifrados y acceso de operador restringido.

Antes del piloto real: acordar responsable, finalidades, retención por tipo, solicitudes de acceso/corrección y procedimiento ante incidentes. La retención no se inventa como obligación legal; necesita validación con el colegio y asesoría pertinente. No hay afirmación de certificación o cumplimiento normativo automático.

## Pruebas de seguridad obligatorias
Dos colegios, dos alumnos del mismo curso, alumnos de distinto curso, docente asignado/no asignado, inspector, administrador y multirrol. Intentar cambiar IDs/colegio, reutilizar JWT/sesión de membresía revocada, obtener borradores/soluciones, descargar cuarentena y leer expedientes mediante cuenta técnica. Rechazo de CSRF/XSS y archivos que no coinciden con tipo declarado.

## Estado de protección Git
Las ramas fueron creadas pero **no protegidas** por la herramienta. HU-03 exige aplicar y verificar rulesets activos con PR obligatorio, lista de bypass vacía, bloqueo de force push y borrado, y checks reales. Esta documentación no configura reglas por sí misma.
