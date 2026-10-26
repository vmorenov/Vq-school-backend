# Entorno local integrado

## Requisitos y arranque
Docker Engine + Compose v2, Python 3 y ambos repositorios como carpetas hermanas, en las ramas de esta entrega:

```sh
git clone --branch feat/platform-foundation https://github.com/vmorenov/Vq-school-backend.git
git clone --branch feat/microfrontend-foundation https://github.com/vmorenov/Va-school-app.git
cd Vq-school-backend
python3 infra/init-local.py
docker compose --env-file infra/.env -f infra/compose.yaml up --build -d
python3 infra/smoke-local.py
```

Abrir http://localhost:8080 (portal), http://localhost:8080/public/ (sitio) y http://localhost:8080/auth/admin/ (Keycloak local). Usuario sintético `demo.student`; contraseña aleatoria en `infra/.env`, clave DEMO_STUDENT_PASSWORD. No copiar contraseñas a issues o capturas. Administrador local `local-admin`, contraseña aleatoria del mismo archivo.

El realm se importa sólo al crear el entorno. Si cambias secretos/realm, no esperes que Keycloak modifique un realm ya existente: aplica la modificación administrativa o recrea **sólo el volumen de desarrollo** conscientemente. `docker compose ... down` conserva datos; `down -v` los elimina. init-local nunca sobrescribe un .env existente.

La única entrada publicada es 127.0.0.1:8080. HTTP, COOKIE_SECURE=false, sslRequired=none y start-dev son exclusivamente locales. No usar este Compose en Internet ni con datos reales. Backend y Keycloak usan issuer público consistente y JWKS/token endpoints internos. Credenciales generadas localmente y excluidas de Git.

## Alcance implementado
Cuatro aplicaciones Java, Keycloak con PostgreSQL, shell, dos remotos y web pública. Endpoints de salud y capacidades autenticadas; sesiones en memoria del BFF (reiniciar exige login). No hay datos escolares ni autorización de membresías implementados, ni persistencia de los tres dominios, Redis, outbox, escáner o S3 todavía. Las HU correspondientes permanecen abiertas.

## Comprobar independencia
Cambiar el texto de `Va-school-app/apps/learning/src/App.tsx` y ejecutar desde backend:

```sh
docker compose --env-file infra/.env -f infra/compose.yaml up -d --build --no-deps learning-web
```

Recargar Aprendizaje: no se reconstruyen shell/academic. Detener learning-web y abrir esa sección debe activar el fallback del shell; Académico permanece utilizable. remoteEntry y manifiesto no se cachean; assets con hash son inmutables. Para producción se necesitan releases versionadas y conservar assets de la versión anterior; no se promete disponibilidad sin interrupción en este Compose.

## Pendiente antes de piloto
Completar membresías/RBAC, persistencia, MFA y recuperación, Redis, healthchecks completos, TLS, secretos gestionados, escaneo, backups restaurados, despliegue productivo e IaC. Staging/producción no se aprovisionaron. La protección de ramas sigue pendiente. Consultar docs/09-estado-implementacion.md para validaciones efectivamente ejecutadas.
