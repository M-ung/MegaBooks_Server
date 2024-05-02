package megabooks.megabooks.global.auth.service;

import megabooks.megabooks.domain.user.entity.User;
import megabooks.megabooks.global.auth.PrincipalDetails;
import megabooks.megabooks.global.common.exception.CustomException;
import megabooks.megabooks.global.common.reponse.ErrorCode;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public String getCurrentAuthenticatedUserEmail() throws CustomException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof PrincipalDetails) {
                return ((PrincipalDetails) principal).getEmail();
            }
            throw new CustomException(ErrorCode.USER_NOT_FOUND);
        }
        throw new CustomException(ErrorCode.ACCESS_DENIED);
    }

    public User getCurrentAuthenticatedUser() throws CustomException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof PrincipalDetails) {
                return ((PrincipalDetails) principal).getUser();
            }
            throw new CustomException(ErrorCode.USER_NOT_FOUND);
        }
        throw new CustomException(ErrorCode.ACCESS_DENIED);
    }
}
