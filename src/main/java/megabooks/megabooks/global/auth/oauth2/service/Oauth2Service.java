package megabooks.megabooks.global.auth.oauth2.service;

import megabooks.megabooks.global.auth.oauth2.dto.Oauth2ResponseDTO;

public interface Oauth2Service {
    Oauth2ResponseDTO.Oauth2TokenResponseDTO getToken(String accessToken, String refreshToken);
}
