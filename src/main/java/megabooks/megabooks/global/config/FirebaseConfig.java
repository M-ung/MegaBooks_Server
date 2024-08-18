package megabooks.megabooks.global.config;


import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import megabooks.megabooks.global.firebase.FcmProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ResourceUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


@Configuration
@RequiredArgsConstructor
@Slf4j
public class FirebaseConfig {
    private final FcmProperties fcmProperties;
    private final ResourceLoader resourceLoader;

    @Bean
    public FirebaseApp firebaseApp() {
        try {
            log.info("Initializing FirebaseApp with key path: " + fcmProperties.adminKeyPath());
            if (FirebaseApp.getApps().isEmpty()) {
                Resource resource = resourceLoader.getResource(fcmProperties.adminKeyPath());
                try (InputStream serviceAccount = resource.getInputStream()) {
                    FirebaseOptions options = FirebaseOptions.builder()
                            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                            .setDatabaseUrl(fcmProperties.credentialScope())
                            .build();
                    return FirebaseApp.initializeApp(options);
                }
            } else {
                log.info("FirebaseApp already initialized");
                return FirebaseApp.getInstance();
            }
        } catch (IOException e) {
            log.error("FirebaseApp initialization failed", e);
            throw new IllegalStateException("Failed to initialize FirebaseApp", e);
        }
    }
}