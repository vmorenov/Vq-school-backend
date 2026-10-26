package org.vqschool.bff;
import java.util.Map;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;
@RestController
public class SessionController {
    @GetMapping("/api/v1/session")
    public Map<String,Object> session(@AuthenticationPrincipal OidcUser user) {
        if(user==null) return Map.of("authenticated",false);
        String displayName=user.getFullName();
        if(displayName==null || displayName.isBlank()) displayName=user.getPreferredUsername();
        if(displayName==null || displayName.isBlank()) displayName=user.getSubject();
        return Map.of("authenticated",true,"subject",user.getSubject(),"displayName",displayName,"membershipReady",false);
    }
    @GetMapping("/api/v1/csrf")
    public Map<String,String> csrf(CsrfToken token) { return Map.of("token",token.getToken(),"parameterName",token.getParameterName(),"headerName",token.getHeaderName()); }
}
