package megabooks.megabooks.domain.token.dto.token;

import lombok.Data;
import megabooks.megabooks.global.auth.PrincipalDetails;

@Data
public class TokenResponseDTO {
    private String accessToken;
    private String refreshToken;
    private String userEmail;
    private String userName;
    public TokenResponseDTO(String accessToken, String refreshToken, PrincipalDetails principalDetails) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.userEmail = principalDetails.getEmail();
        this.userName = principalDetails.getUsername();
    }

//    public TokenResponseDTO(String accessToken, String refreshToken, PrincipalDetails principalDetails) {
//        this.accessToken = accessToken;
//        this.refreshToken = refreshToken;
//        this.userEmail = principalDetails.getEmail();
//        this.userName = principalDetails.getName();
//    }
}
