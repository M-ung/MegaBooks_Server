package megabooks.megabooks.global.auth.jwt.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import megabooks.megabooks.domain.token.service.TokenServiceImpl;
import megabooks.megabooks.domain.user.entity.User;
import megabooks.megabooks.domain.user.repository.UserRepository;
import megabooks.megabooks.global.auth.PrincipalDetails;
import megabooks.megabooks.global.auth.jwt.JwtProperties;
import megabooks.megabooks.global.common.reponse.ErrorCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import java.io.IOException;

@Slf4j
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {
    private UserRepository userRepository;
    private TokenServiceImpl tokenService;
    @Value(("${jwt.secret}")) // application.properties 또는 yml 파일의 jwt.secret 값을 여기에 주입
    private String secretKey; // JWT 토큰 생성 및 파싱에 사용할 비밀키

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, UserRepository userRepository, TokenServiceImpl tokenService, String secretKey) {
        super(authenticationManager);
        this.userRepository = userRepository;
        this.tokenService = tokenService;
        this.secretKey = secretKey;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String jwtHeader = request.getHeader(JwtProperties.HEADER_STRING);

        if (jwtHeader == null || !jwtHeader.startsWith(JwtProperties.TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }

        try {
            String jwtToken = request.getHeader(JwtProperties.HEADER_STRING).replace(JwtProperties.TOKEN_PREFIX, "");
            String userEmail = JWT.require(Algorithm.HMAC512(secretKey)).build().verify(jwtToken).getClaim("userEmail").asString();

            // 블랙리스트에 토큰이 있는지 확인
            if (tokenService.isTokenBlacklisted(jwtToken)) {
                sendErrorResponse(response, ErrorCode.BLACKLIST_TOKEN);
                return;
            }

            if (userEmail != null) {
                User Entity = userRepository.findByUserEmail(userEmail).get();

                PrincipalDetails principalDetails = new PrincipalDetails(Entity);
                Authentication authentication = new UsernamePasswordAuthenticationToken(principalDetails, principalDetails.getPassword(), principalDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
            chain.doFilter(request, response);
        } catch (TokenExpiredException e) {
            log.info("[JwtAuthorizationFilter] EXPIRED_ACCESS_TOKEN");
            sendErrorResponse(response, ErrorCode.EXPIRED_ACCESS_TOKEN);
        } catch (Exception e) {
            log.info("[JwtAuthorizationFilter] INVALID_ACCESS_TOKEN");
            sendErrorResponse(response, ErrorCode.INVALID_ACCESS_TOKEN);
        }
    }

    private void sendErrorResponse(HttpServletResponse response, ErrorCode errorCode) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        String errorMessage = "{\"code\": \"" + HttpServletResponse.SC_UNAUTHORIZED + "\", \"message\": \"" + errorCode.getMsg() + "\", \"status\": \"FAIL\"}";
        response.getOutputStream().write(errorMessage.getBytes("UTF-8"));
    }
}
// {
//    "code": 409,
//    "message": "CustomException : 이미 가입된 이메일입니다.",
//    "status": "FAIL"
//}
