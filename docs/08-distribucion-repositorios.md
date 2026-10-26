# Distribución entre repositorios

40 HU funcionales y 18 tareas frontend; no son 58 funcionalidades ni se suman estimaciones dos veces. Las HU originales siguen coordinando aceptación integral; las tareas FE contienen implementación de interfaz. Backend tiene reglas, seguridad, contratos e infraestructura; frontend tiene shell, microfrontends y web pública.

| HU | Resultado funcional | Ejecución frontend |
|---|---|---|
| [HU-01](https://github.com/vmorenov/Vq-school-backend/issues/1) | Inicializar monorepositorio y herramientas | [FE-01](https://github.com/vmorenov/Va-school-app/issues/2), [FE-02](https://github.com/vmorenov/Va-school-app/issues/3) |
| [HU-02](https://github.com/vmorenov/Vq-school-backend/issues/2) | Levantar entorno local con Docker Compose | [FE-01](https://github.com/vmorenov/Va-school-app/issues/2) |
| [HU-03](https://github.com/vmorenov/Vq-school-backend/issues/3) | Configurar CI y promoción entre ambientes | [FE-03](https://github.com/vmorenov/Va-school-app/issues/4), [FE-18](https://github.com/vmorenov/Va-school-app/issues/19) |
| [HU-04](https://github.com/vmorenov/Vq-school-backend/issues/4) | Configurar establecimientos y membresías | [FE-05](https://github.com/vmorenov/Va-school-app/issues/6) |
| [HU-05](https://github.com/vmorenov/Vq-school-backend/issues/5) | Autenticarse con Keycloak y cerrar sesión | [FE-04](https://github.com/vmorenov/Va-school-app/issues/5) |
| [HU-06](https://github.com/vmorenov/Vq-school-backend/issues/6) | Gestionar usuarios y roles del colegio | [FE-05](https://github.com/vmorenov/Va-school-app/issues/6) |
| [HU-07](https://github.com/vmorenov/Vq-school-backend/issues/7) | Aplicar permisos por rol y relación académica | [FE-04](https://github.com/vmorenov/Va-school-app/issues/5) |
| [HU-08](https://github.com/vmorenov/Vq-school-backend/issues/8) | Gestionar año académico y períodos | [FE-05](https://github.com/vmorenov/Va-school-app/issues/6) |
| [HU-09](https://github.com/vmorenov/Vq-school-backend/issues/9) | Gestionar cursos y asignaturas | [FE-05](https://github.com/vmorenov/Va-school-app/issues/6) |
| [HU-10](https://github.com/vmorenov/Vq-school-backend/issues/10) | Matricular alumnos y registrar apoderados | [FE-05](https://github.com/vmorenov/Va-school-app/issues/6) |
| [HU-11](https://github.com/vmorenov/Vq-school-backend/issues/11) | Asignar profesores a cursos y asignaturas | [FE-05](https://github.com/vmorenov/Va-school-app/issues/6) |
| [HU-12](https://github.com/vmorenov/Vq-school-backend/issues/12) | Crear y consultar horarios | [FE-05](https://github.com/vmorenov/Va-school-app/issues/6) |
| [HU-13](https://github.com/vmorenov/Vq-school-backend/issues/13) | Ver inicio y asignaturas según perfil | [FE-02](https://github.com/vmorenov/Va-school-app/issues/3), [FE-06](https://github.com/vmorenov/Va-school-app/issues/7) |
| [HU-14](https://github.com/vmorenov/Vq-school-backend/issues/14) | Configurar escala y evaluaciones académicas | [FE-07](https://github.com/vmorenov/Va-school-app/issues/8) |
| [HU-15](https://github.com/vmorenov/Vq-school-backend/issues/15) | Registrar, publicar y corregir calificaciones | [FE-07](https://github.com/vmorenov/Va-school-app/issues/8) |
| [HU-16](https://github.com/vmorenov/Vq-school-backend/issues/16) | Consultar notas y promedios personales | [FE-07](https://github.com/vmorenov/Va-school-app/issues/8) |
| [HU-17](https://github.com/vmorenov/Vq-school-backend/issues/17) | Registrar y corregir asistencia por clase | [FE-08](https://github.com/vmorenov/Va-school-app/issues/9) |
| [HU-18](https://github.com/vmorenov/Vq-school-backend/issues/18) | Consultar asistencia personal | [FE-08](https://github.com/vmorenov/Va-school-app/issues/9) |
| [HU-19](https://github.com/vmorenov/Vq-school-backend/issues/19) | Publicar material pedagógico seguro | [FE-09](https://github.com/vmorenov/Va-school-app/issues/10) |
| [HU-20](https://github.com/vmorenov/Vq-school-backend/issues/20) | Consultar y descargar materiales | [FE-09](https://github.com/vmorenov/Va-school-app/issues/10) |
| [HU-21](https://github.com/vmorenov/Vq-school-backend/issues/21) | Crear preguntas y pruebas en borrador | [FE-10](https://github.com/vmorenov/Va-school-app/issues/11) |
| [HU-22](https://github.com/vmorenov/Vq-school-backend/issues/22) | Publicar y programar pruebas | [FE-10](https://github.com/vmorenov/Va-school-app/issues/11) |
| [HU-23](https://github.com/vmorenov/Vq-school-backend/issues/23) | Responder pruebas con autoguardado | [FE-11](https://github.com/vmorenov/Va-school-app/issues/12) |
| [HU-24](https://github.com/vmorenov/Vq-school-backend/issues/24) | Corregir y publicar retroalimentación | [FE-12](https://github.com/vmorenov/Va-school-app/issues/13) |
| [HU-25](https://github.com/vmorenov/Vq-school-backend/issues/25) | Consultar resultados y entregas | [FE-12](https://github.com/vmorenov/Va-school-app/issues/13) |
| [HU-26](https://github.com/vmorenov/Vq-school-backend/issues/26) | Configurar identidad y estructura del sitio | [FE-13](https://github.com/vmorenov/Va-school-app/issues/14) |
| [HU-27](https://github.com/vmorenov/Vq-school-backend/issues/27) | Editar y publicar páginas y noticias | [FE-13](https://github.com/vmorenov/Va-school-app/issues/14) |
| [HU-28](https://github.com/vmorenov/Vq-school-backend/issues/28) | Enviar avisos masivos por rol y curso | [FE-14](https://github.com/vmorenov/Va-school-app/issues/15) |
| [HU-29](https://github.com/vmorenov/Vq-school-backend/issues/29) | Consultar bandeja de notificaciones | [FE-14](https://github.com/vmorenov/Va-school-app/issues/15) |
| [HU-30](https://github.com/vmorenov/Vq-school-backend/issues/30) | Enviar correos transaccionales y a apoderados | [FE-14](https://github.com/vmorenov/Va-school-app/issues/15) |
| [HU-31](https://github.com/vmorenov/Vq-school-backend/issues/31) | Registrar observaciones de convivencia | [FE-15](https://github.com/vmorenov/Va-school-app/issues/16) |
| [HU-32](https://github.com/vmorenov/Vq-school-backend/issues/32) | Registrar retiros y retornos de alumnos | [FE-15](https://github.com/vmorenov/Va-school-app/issues/16) |
| [HU-33](https://github.com/vmorenov/Vq-school-backend/issues/33) | Gestionar citaciones de apoderados | [FE-15](https://github.com/vmorenov/Va-school-app/issues/16) |
| [HU-34](https://github.com/vmorenov/Vq-school-backend/issues/34) | Consultar auditoría de operaciones sensibles | [FE-16](https://github.com/vmorenov/Va-school-app/issues/17) |
| [HU-35](https://github.com/vmorenov/Vq-school-backend/issues/35) | Validar seguridad, aislamiento y privacidad | [FE-17](https://github.com/vmorenov/Va-school-app/issues/18) |
| [HU-36](https://github.com/vmorenov/Vq-school-backend/issues/36) | Preparar infraestructura y recuperación del piloto | [FE-03](https://github.com/vmorenov/Va-school-app/issues/4), [FE-18](https://github.com/vmorenov/Va-school-app/issues/19) |
| [HU-37](https://github.com/vmorenov/Vq-school-backend/issues/37) | Validar piloto integral y experiencia de uso | [FE-17](https://github.com/vmorenov/Va-school-app/issues/18), [FE-18](https://github.com/vmorenov/Va-school-app/issues/19) |
| [HU-38](https://github.com/vmorenov/Vq-school-backend/issues/38) | Consultar reportes básicos y exportar | [FE-16](https://github.com/vmorenov/Va-school-app/issues/17) |
| [HU-39](https://github.com/vmorenov/Vq-school-backend/issues/39) | Provisionar almacenamiento y ciclo de archivos | [FE-09](https://github.com/vmorenov/Va-school-app/issues/10) |
| [HU-40](https://github.com/vmorenov/Vq-school-backend/issues/40) | Integrar servicios con contratos e idempotencia | [FE-02](https://github.com/vmorenov/Va-school-app/issues/3) |

HU-13 se implementa principalmente en frontend; backend entrega los datos autorizados mediante las HU de dominio. Las fundaciones están en progreso, no se declaran completas por existir código.
