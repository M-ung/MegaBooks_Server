package megabooks.megabooks.global.auth;

import lombok.RequiredArgsConstructor;
import megabooks.megabooks.domain.user.entity.User;
import megabooks.megabooks.domain.user.repository.UserRepository;
import megabooks.megabooks.global.common.exception.CustomException;
import megabooks.megabooks.global.common.reponse.ErrorCode;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException, CustomException {
        User userEntity = userRepository.findByUserEmail(userEmail).get(); // 여기서 한 번 등록된 이메일인지 확인하기 떄문에 굳이 로직에서 확인할 필요 없을 듯???
        if(userEntity == null) {
            throw new CustomException(ErrorCode.USER_NOT_FOUND);
        }
        return new PrincipalDetails(userEntity);
    }
}
