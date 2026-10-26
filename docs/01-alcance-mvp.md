# Alcance MVP — VQ School
Fecha de línea base: 25 de octubre de 2026 (Chile). Estado: propuesta ejecutable para implementación.

## Problema y propuesta
Un establecimiento necesita mantener su presencia pública, administrar su operación académica y comunicar a su comunidad sin repartir horarios, notas, pruebas y registros de inspectoría en herramientas inconexas.

El MVP permite operar un ciclo completo: configurar colegio → incorporar usuarios → matricular y asignar docentes → publicar horario → registrar notas/asistencia → compartir material y rendir una prueba → revisar resultados → notificar y gestionar una actuación de inspectoría.

Comprador propuesto: dirección/administración del establecimiento. Usuarios: cuatro roles solicitados. Hipótesis comercial a validar: suscripción por establecimiento con tramo de alumnos activos y cuota de almacenamiento, más incorporación inicial. No se fija precio, tamaño de mercado ni ahorro prometido sin validar con colegios.

## Supuestos de producto
- Piloto en un colegio chileno; arquitectura permite varios colegios y pruebas deben usar al menos dos ficticios para verificar aislamiento.
- Idioma español y zona horaria configurable, con America/Santiago como propuesta del piloto.
- “Notas del inspector” se interpreta como **anotaciones de convivencia**, separadas de calificaciones académicas.
- Apoderado es contacto asociado a un alumno y destinatario de citaciones; el acceso con rol APODERADO se deja para una fase posterior.
- Un usuario puede tener varios roles, pero sólo dentro de membresías explícitas. Un administrador de colegio no es administrador de Keycloak.
- Sitio público y portal pertenecen al mismo producto y monorepositorio. Se conserva el repositorio existente de backend como raíz, sin renombrarlo.
- No se pretende reemplazar un libro oficial, emitir certificados oficiales ni integrar organismos públicos en este MVP.

## Alcance incluido

| Capacidad | Incluido y límite |
|---|---|
| Identidad | Keycloak, acceso, cierre, recuperación, MFA para personal, altas y bajas desde aplicación |
| Establecimientos | Configuración y aislamiento; incorporación inicial de colegio mediante operador |
| Gestión académica | Año/períodos, niveles, cursos, asignaturas, matrículas, apoderados/contactos y asignación docente |
| Horarios | Semana por curso, vigencias y prevención de cruces; consulta de alumno/profesor |
| Calificaciones | Evaluaciones, escala configurable, ponderación, borrador/publicación, corrección auditada y promedio |
| Asistencia | Por sesión de clase, presente/ausente/atrasado/justificado y consulta individual |
| Material | PDF o enlaces HTTPS; 20 MB por archivo y cuota inicial 5 GB configurable; escaneo previo |
| Test y ensayos | Selección única, V/F y abierta; un intento, ventana temporal, duración, autoguardado y envío |
| Corrección | Automática objetiva y manual abierta; publicación de feedback y traspaso explícito a nota |
| Sitio público | Plantilla inicio/colegio/noticias/contacto, marca, editor seguro, borrador/publicación y SEO básico |
| Notificaciones | Campaña por rol/curso, bandeja interna, correo mínimo y estados de envío |
| Inspectoría | Observaciones, salidas/retornos, citaciones y seguimiento; datos internos por defecto |
| Reportes | Consultas y CSV básicos autorizados; constancia imprimible de citación |
| Operación | Docker, pipeline, secretos, auditoría, métricas, backups/restauración y despliegue del piloto |

## Fuera del MVP
Portal de apoderados; pagos/mensualidades; admisión comercial; integración SIGE/Mineduc u otros sistemas; firma digital avanzada; libro de clases certificado; biometría; aplicación móvil nativa; chat en tiempo real; videoclases; WhatsApp/SMS/push móvil; IA generativa; corrección automática de texto libre; banco adaptativo; preguntas aleatorias; proctoring; ensayos oficiales PAES calibrados; importaciones masivas de históricos; constructor libre de páginas; múltiples campus complejos; matrícula simultánea en varios cursos del mismo colegio/año.

No incluye contratación ni pago de infraestructura, envío real de campañas o manejo de datos de menores en esta fase de definición.

## Reglas académicas propuestas
1. Escala piloto 1,0–7,0 y aprobación 4,0, configurables antes de publicar. El colegio debe confirmar redondeo y ponderaciones.
2. Cada evaluación pertenece a curso/asignatura/período; ponderaciones publicadas suman 100%.
3. Eximido se excluye y se renormaliza el resto. Pendiente/ausente sin resolver impide promedio definitivo. Si todas están eximidas, se muestra “sin promedio”.
4. Promedio provisional usa sólo evaluaciones calificadas y sus pesos renormalizados, claramente identificado como provisional.
5. No entregar una prueba no genera automáticamente cero ni la nota mínima. Docente resuelve según reglas del colegio.
6. Resultado porcentual de prueba se convierte a nota sólo por acción del docente con fórmula/versionado aprobados; no se asume conversión lineal ni exigencia del 60%.
7. Asistencia base = (presente + atrasado) / sesiones con estado definitivo. Justificado significa ausencia justificada y cuenta en denominador. Pendientes se muestran aparte. No confundir con asistencia diaria oficial.
8. Cierre de período bloquea cambios. Reapertura auditada habilita edición al docente autorizado; no al administrador por el mero hecho de reabrir.
9. Traslado conserva autoría y datos históricos. Alumno mantiene acceso a su historial; no a materiales nuevos del curso previo.
10. Autoguardado sólo garantiza respuestas confirmadas por servidor. Tiempo del servidor decide vencimiento; no hay modo offline de examen.

## Condición de salida
Las 40 HU del backlog deben cumplir criterios y definición de terminado, incluidas pruebas de aislamiento y restauración. Debe demostrarse el circuito completo con los cuatro roles y acta de aceptación del piloto. No se declara terminado porque estén creadas las issues.

## Decisiones a confirmar en refinamiento
Colegio piloto y responsable; política de acceso del alumno a observaciones; reglas de nota y asistencia; retención y tratamiento de expedientes; proveedor/país de alojamiento; dominio/correo; volumen y concurrencia esperados. La propuesta avanza con los supuestos anteriores y los hace visibles.
