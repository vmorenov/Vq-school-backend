package org.vqschool.security;
import java.time.Instant;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.security.oauth2.core.DelegatingOAuth2TokenValidator;
import org.springframework.security.oauth2.jwt.*;
import static org.assertj.core.api.Assertions.assertThat;
class JwtValidationTest {
    private Jwt token(String issuer, String audience, Instant expiry) {
        return Jwt.withTokenValue("test").header("alg","RS256").subject("synthetic-user")
            .issuer(issuer).audience(List.of(audience)).issuedAt(Instant.now().minusSeconds(600)).expiresAt(expiry).build();
    }
    private final DelegatingOAuth2TokenValidator<Jwt> validator = new DelegatingOAuth2TokenValidator<>(
        JwtValidators.createDefaultWithIssuer("https://auth.example/realms/school"), ResourceSecurity.audienceValidator("school-api"));
    @Test void acceptsExpectedIssuerAndAudience() { assertThat(validator.validate(token("https://auth.example/realms/school","school-api",Instant.now().plusSeconds(60))).hasErrors()).isFalse(); }
    @Test void rejectsWrongAudience() { assertThat(validator.validate(token("https://auth.example/realms/school","another-api",Instant.now().plusSeconds(60))).hasErrors()).isTrue(); }
    @Test void rejectsWrongIssuer() { assertThat(validator.validate(token("https://attacker.invalid","school-api",Instant.now().plusSeconds(60))).hasErrors()).isTrue(); }
    @Test void rejectsExpiredToken() { assertThat(validator.validate(token("https://auth.example/realms/school","school-api",Instant.now().minusSeconds(120))).hasErrors()).isTrue(); }
}
