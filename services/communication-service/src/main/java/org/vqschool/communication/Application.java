package org.vqschool.communication;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.*;
import org.vqschool.security.ResourceSecurity;
@SpringBootApplication
@Import(ResourceSecurity.class)
@RestController
public class Application {
    public static void main(String[] args) { SpringApplication.run(Application.class,args); }
    @GetMapping("/api/v1/platform/communication")
    public Map<String,Object> capability() {
        return Map.of("service","communication-service","domain","communication","stage","foundation","businessFeaturesReady",false);
    }
}
