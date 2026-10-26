# Fuentes técnicas

Consultadas al preparar la base. Son referencias de comportamiento de tecnologías; la arquitectura y el alcance son decisiones de este proyecto. Las versiones exactas deben fijarse y probarse en HU-01.

- [Spring Security: OAuth2 Login](https://docs.spring.io/spring-security/reference/servlet/oauth2/login/index.html): flujo Authorization Code para login OIDC.
- [Spring Security: JWT Resource Server](https://docs.spring.io/spring-security/reference/servlet/oauth2/resource-server/jwt.html): validación de JWT, issuer y claves; audiencia se configura explícitamente.
- [Spring Security: CSRF](https://docs.spring.io/spring-security/reference/servlet/exploits/csrf.html): protección de solicitudes con sesión/cookies.
- [Keycloak: JavaScript adapter](https://www.keycloak.org/securing-apps/javascript-adapter): contexto de alternativa SPA y PKCE. El MVP usa BFF, por lo que no asume que keycloak-js sea obligatorio.
- [Docker Compose: secretos](https://docs.docker.com/compose/how-tos/use-secrets/): exposición de secretos por servicio mediante archivos.
- [Docker Compose en producción](https://docs.docker.com/compose/how-tos/production/): configuración específica de ambientes.
- [GitHub: reglas de protección](https://docs.github.com/en/repositories/configuring-branches-and-merges-in-your-repository/managing-protected-branches/managing-a-branch-protection-rule): requerir PR y controles de merge.
- [GitHub: rulesets](https://docs.github.com/repositories/configuring-branches-and-merges-in-your-repository/managing-rulesets/about-rulesets): alcance y actores con bypass.
