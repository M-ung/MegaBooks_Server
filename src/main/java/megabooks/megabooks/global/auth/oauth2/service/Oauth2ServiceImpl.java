package megabooks.megabooks.global.auth.oauth2.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import megabooks.megabooks.domain.user.dto.UserResponseDTO;
import megabooks.megabooks.domain.user.entity.User;
import megabooks.megabooks.global.auth.oauth2.dto.Oauth2ResponseDTO;
import megabooks.megabooks.global.common.exception.CustomException;
import megabooks.megabooks.global.common.reponse.ErrorCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class Oauth2ServiceImpl implements Oauth2Service {
    @Override
    public Oauth2ResponseDTO.Oauth2TokenResponseDTO getToken(String accessToken, String refreshToken) {
        try {
            log.info("[Oauth2ServiceImpl] getToken");
            return new Oauth2ResponseDTO.Oauth2TokenResponseDTO(accessToken, refreshToken);
        } catch (CustomException ce){
            log.info("[CustomException] Oauth2ServiceImpl getToken");
            throw ce;
        } catch (Exception e) {
            log.info("[Exception500] Oauth2ServiceImpl getToken");
            throw new CustomException(ErrorCode.SERVER_ERROR, "[Exception500] Oauth2ServiceImpl getToken : " + e.getMessage());
        }
    }
}
