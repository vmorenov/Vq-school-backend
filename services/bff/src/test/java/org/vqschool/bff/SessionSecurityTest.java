package org.vqschool.bff;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@SpringBootTest(properties={"identity.secret=synthetic-test-only"}) @AutoConfigureMockMvc
class SessionSecurityTest {
    @Autowired MockMvc mvc;
    @Autowired org.springframework.security.oauth2.client.registration.ClientRegistrationRepository clients;
    @Test void anonymousSessionIsExplicit() throws Exception { mvc.perform(get("/api/v1/session")).andExpect(status().isOk()).andExpect(jsonPath("$.authenticated").value(false)).andExpect(jsonPath("$.accessToken").doesNotExist()); }
    @Test void downstreamWithoutSessionReturns401() throws Exception { mvc.perform(get("/api/v1/platform/school")).andExpect(status().isUnauthorized()); }
    @Test void sessionDoesNotExposeTokens() throws Exception { mvc.perform(get("/api/v1/session").with(oidcLogin().idToken(t -> t.claim("name","Synthetic Student")))).andExpect(status().isOk()).andExpect(jsonPath("$.authenticated").value(true)).andExpect(jsonPath("$.membershipReady").value(false)).andExpect(jsonPath("$.accessToken").doesNotExist()); }
    @Test void logoutRejectsMissingCsrf() throws Exception { mvc.perform(post("/logout").with(oidcLogin())).andExpect(status().isForbidden()); }
    @Test void csrfEndpointReturnsToken() throws Exception { mvc.perform(get("/api/v1/csrf")).andExpect(status().isOk()).andExpect(jsonPath("$.token").isNotEmpty()); }
    @Test void missingDisplayClaimsDoNotBreakSession() throws Exception { mvc.perform(get("/api/v1/session").with(oidcLogin())).andExpect(status().isOk()).andExpect(jsonPath("$.displayName").isNotEmpty()); }
    @Test void validLogoutRedirectsToKeycloak() throws Exception { mvc.perform(post("/logout").with(oidcLogin().clientRegistration(clients.findByRegistrationId("keycloak"))).with(csrf())).andExpect(status().is3xxRedirection()).andExpect(header().string("Location",org.hamcrest.Matchers.startsWith("http://localhost:8080/auth/realms/vq-school/protocol/openid-connect/logout"))); }
    @Test void authorizationUsesPkce() throws Exception { mvc.perform(get("/oauth2/authorization/keycloak")).andExpect(status().is3xxRedirection()).andExpect(header().string("Location",org.hamcrest.Matchers.containsString("code_challenge_method=S256"))); }
}
