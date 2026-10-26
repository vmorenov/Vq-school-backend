package org.vqschool.bff;
import java.time.Duration;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;
import org.springframework.web.server.ResponseStatusException;
@RestController
public class PlatformController {
    private final Map<String,String> targets;
    private final RestClient client;
    public PlatformController(@Value("${services.school}") String school,@Value("${services.learning}") String learning,@Value("${services.communication}") String communication) {
        targets=Map.of("school",school,"learning",learning,"communication",communication);
        var factory=new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(Duration.ofSeconds(3)); factory.setReadTimeout(Duration.ofSeconds(5));
        client=RestClient.builder().requestFactory(factory).build();
    }
    @GetMapping("/api/v1/platform/{service}")
    public Object capability(@PathVariable String service,@RegisteredOAuth2AuthorizedClient("keycloak") OAuth2AuthorizedClient authorized) {
        String base=targets.get(service);
        if(base==null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        try {
            return client.get().uri(base+"/api/v1/platform/"+service)
                .headers(h -> h.setBearerAuth(authorized.getAccessToken().getTokenValue())).retrieve().body(Map.class);
        } catch(RestClientException ex) { throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE,"Service temporarily unavailable"); }
    }
}
