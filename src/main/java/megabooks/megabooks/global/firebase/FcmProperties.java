package megabooks.megabooks.global.firebase;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "firebase.fcm")
public record FcmProperties (
        String id,
        String adminKeyPath,
        String credentialScope
) {

}
