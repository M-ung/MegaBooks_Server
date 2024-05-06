package megabooks.megabooks.domain.token.dto.refreshToken;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class RefreshTokenRequestDTO {
    @Getter
    @Setter
    public static class RefreshTokenGetAccessTokenDTO {
        private String refreshToken;
    }
}
