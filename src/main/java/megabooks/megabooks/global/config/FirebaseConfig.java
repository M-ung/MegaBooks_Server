package megabooks.megabooks.global.config;


import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import megabooks.megabooks.global.firebase.FcmProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class FirebaseConfig {
    private final FcmProperties fcmProperties;
    @PostConstruct
    public void initialize() {
        try {
            FileInputStream serviceAccount = new FileInputStream(fcmProperties.adminKeyPath());
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl(fcmProperties.credentialScope())
                    .build();

            FirebaseApp.initializeApp(options);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Bean
    public DatabaseReference firebaseDatabase() {
        return FirebaseDatabase.getInstance().getReference();
    }
}