package megabooks.megabooks.global.security.util;

import megabooks.megabooks.global.exception.ErrorCode;
import megabooks.megabooks.global.exception.user.UserNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityUtil {

    public static Long getCurrentId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof UserDetails) {
                try {
                    String username = ((UserDetails) principal).getUsername();
                    return Long.parseLong(username);
                } catch (NumberFormatException e) {
                    throw new UserNotFoundException(ErrorCode.NOT_FOUND_USER);
                }
            }
        }
        throw new UserNotFoundException(ErrorCode.NOT_FOUND_USER);
    }
}