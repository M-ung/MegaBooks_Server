package megabooks.megabooks;

import megabooks.megabooks.global.security.jwt.JwtProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableConfigurationProperties(JwtProperties.class)
@EnableJpaAuditing
@EnableScheduling
@ConfigurationPropertiesScan
public class MegaBooksApplication {
    public static void main(String[] args) {
        SpringApplication.run(MegaBooksApplication.class, args);
    }

}
