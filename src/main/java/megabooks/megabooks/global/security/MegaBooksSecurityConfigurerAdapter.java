package megabooks.megabooks.global.security;

import lombok.AllArgsConstructor;
import megabooks.megabooks.domain.user.repository.UserRepository;
import megabooks.megabooks.global.security.jwt.JwtProvider;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@AllArgsConstructor
public class MegaBooksSecurityConfigurerAdapter extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    private final JwtProvider jwtProvider;
    private final UserRepository userRepository;

    @Override
    public void configure(HttpSecurity security) {
        security.addFilterAfter(
                new SecurityFilter(jwtProvider, userRepository),
                UsernamePasswordAuthenticationFilter.class
        );
    }
}
