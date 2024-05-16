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
        private String userEmail;
        private String userName;

        public Oauth2TokenResponseDTO(String accessToken, String findRefreshToken, String userEmail, String userName) {
            this.accessToken = accessToken;
            this.refreshToken = findRefreshToken;
            this.userEmail = userEmail;
            this.userName = userName;
        }
    }
}
