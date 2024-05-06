package megabooks.megabooks.domain.token.dto.token;

import lombok.Data;

@Data
public class TokenResponseDTO {
    private String accessToken;
    private String refreshToken;

    public TokenResponseDTO(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}
