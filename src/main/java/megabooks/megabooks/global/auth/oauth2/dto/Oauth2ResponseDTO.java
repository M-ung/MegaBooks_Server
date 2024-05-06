package megabooks.megabooks.global.auth.oauth2.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Oauth2ResponseDTO {
    @Setter
    @Getter
    public static class Oauth2TokenResponseDTO {
        private String accessToken;
        private String refreshToken;

        public Oauth2TokenResponseDTO(String accessToken, String findRefreshToken) {
            this.accessToken = accessToken;
            this.refreshToken = findRefreshToken;
        }
    }
}
