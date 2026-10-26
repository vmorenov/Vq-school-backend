package org.vqschool.communication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.jwt;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@SpringBootTest @AutoConfigureMockMvc
class AccessTest {
    @Autowired MockMvc mvc;
    @Test void healthIsPublic() throws Exception { mvc.perform(get("/actuator/health")).andExpect(status().isOk()); }
    @Test void capabilityRequiresIdentity() throws Exception { mvc.perform(get("/api/v1/platform/communication")).andExpect(status().isUnauthorized()); }
    @Test void authenticatedCapabilityDoesNotPretendBusinessIsReady() throws Exception { mvc.perform(get("/api/v1/platform/communication").with(jwt())).andExpect(status().isOk()).andExpect(jsonPath("$.businessFeaturesReady").value(false)); }
    @Test void actuatorEnvironmentIsNotPublic() throws Exception { mvc.perform(get("/actuator/env")).andExpect(status().isUnauthorized()); }
}
