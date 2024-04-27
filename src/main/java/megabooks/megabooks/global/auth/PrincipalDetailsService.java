package megabooks.megabooks.global.auth;

import lombok.RequiredArgsConstructor;
import megabooks.megabooks.domain.user.entity.User;
import megabooks.megabooks.domain.user.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        User userEntity = userRepository.findByUserEmail(userEmail).get();
        return new PrincipalDetails(userEntity);
    }
}
