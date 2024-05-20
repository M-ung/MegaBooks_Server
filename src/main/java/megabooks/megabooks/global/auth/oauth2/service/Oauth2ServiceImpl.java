package megabooks.megabooks.global.auth.oauth2.service;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    public Oauth2ResponseDTO.Oauth2TokenResponseDTO createOauth2Token(HttpServletRequest request) {
        try {
            log.info("[Oauth2ServiceImpl] getToken");
            // 세션에서 토큰 가져오기
            String accessToken = (String) request.getSession().getAttribute("accessToken");
            String refreshToken = (String) request.getSession().getAttribute("refreshToken");
            String userEmail = (String) request.getSession().getAttribute("userEmail");
            String userName = (String) request.getSession().getAttribute("userName");

            // 세션에서 토큰 정보 제거
            request.getSession().removeAttribute("accessToken");
            request.getSession().removeAttribute("refreshToken");
            request.getSession().removeAttribute("userEmail");
            request.getSession().removeAttribute("userName");

            return new Oauth2ResponseDTO.Oauth2TokenResponseDTO(accessToken, refreshToken, userEmail, userName);
        } catch (CustomException ce){
            log.info("[CustomException] Oauth2ServiceImpl getToken");
            throw ce;
        } catch (Exception e) {
            log.info("[Exception500] Oauth2ServiceImpl getToken");
            throw new CustomException(ErrorCode.SERVER_ERROR, "[Exception500] Oauth2ServiceImpl getToken : " + e.getMessage());
        }
    }
}
