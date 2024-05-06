package megabooks.megabooks.domain.token.service.refreshToken;

import megabooks.megabooks.domain.token.dto.refreshToken.RefreshTokenRequestDTO;
import megabooks.megabooks.domain.token.dto.refreshToken.RefreshTokenResponseDTO;

public interface RefreshTokenService {
    RefreshTokenResponseDTO.RefreshTokenGetAccessTokenDTO getAccessToken(RefreshTokenRequestDTO.RefreshTokenGetAccessTokenDTO tokenGetAccessTokenDTO);
}
