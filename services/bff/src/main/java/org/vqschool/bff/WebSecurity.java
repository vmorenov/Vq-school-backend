package org.vqschool.bff;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.client.registration.*;
import org.springframework.security.oauth2.client.web.*;
import org.springframework.security.oauth2.client.oidc.web.logout.OidcClientInitiatedLogoutSuccessHandler;
import org.springframework.security.oauth2.core.*;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
@Configuration
public class WebSecurity {
    @Bean ClientRegistrationRepository clients(@Value("${identity.public-url}") String external,
            @Value("${identity.internal-url}") String internal,@Value("${identity.secret}") String secret) {
        return new InMemoryClientRegistrationRepository(ClientRegistration.withRegistrationId("keycloak")
            .clientId("school-bff").clientSecret(secret).clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
            .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
            .redirectUri("{baseUrl}/login/oauth2/code/{registrationId}").scope("openid","profile")
            .authorizationUri(external+"/protocol/openid-connect/auth")
            .tokenUri(internal+"/protocol/openid-connect/token").jwkSetUri(internal+"/protocol/openid-connect/certs")
            .userInfoUri(internal+"/protocol/openid-connect/userinfo").userNameAttributeName("sub").issuerUri(external)
            .providerConfigurationMetadata(java.util.Map.of("end_session_endpoint",external+"/protocol/openid-connect/logout"))
            .clientName("VQ School").build());
    }
    @Bean SecurityFilterChain browserSecurity(HttpSecurity http,ClientRegistrationRepository clients,
            @Value("${identity.post-logout-url}") String postLogout) throws Exception {
        var resolver=new DefaultOAuth2AuthorizationRequestResolver(clients,"/oauth2/authorization");
        resolver.setAuthorizationRequestCustomizer(OAuth2AuthorizationRequestCustomizers.withPkce());
        var logout=new OidcClientInitiatedLogoutSuccessHandler(clients);
        logout.setPostLogoutRedirectUri(postLogout);
        // Explicit metadata avoids startup discovery while retaining OIDC logout.
        return http.authorizeHttpRequests(a -> a.requestMatchers("/api/v1/session","/api/v1/csrf","/actuator/health","/actuator/health/**","/error").permitAll().anyRequest().authenticated())
            .exceptionHandling(e -> e.defaultAuthenticationEntryPointFor(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED),new AntPathRequestMatcher("/api/**")))
            .oauth2Login(o -> o.authorizationEndpoint(e -> e.authorizationRequestResolver(resolver)).defaultSuccessUrl("/",true))
            .logout(l -> l.logoutSuccessHandler(logout).invalidateHttpSession(true).deleteCookies("VQSESSION"))
            .build(); // Session CSRF protection deliberately enabled.
    }
}
