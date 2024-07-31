package megabooks.megabooks.global.security.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MegabooksHeader {
    AUTHORIZATION("Authorization", null),
    AUTHORIZATION_ROLE("Role", null);

    private final String key;
    private final String value;
}
