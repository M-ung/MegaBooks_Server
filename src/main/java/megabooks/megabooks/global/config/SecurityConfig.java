package megabooks.megabooks.global.config;

import megabooks.megabooks.domain.user.repository.UserRepository;
import megabooks.megabooks.global.security.MegaBooksSecurityConfigurerAdapter;
import megabooks.megabooks.global.security.SecurityDeniedHandler;
import megabooks.megabooks.global.security.SecurityExceptionHandler;
import megabooks.megabooks.global.security.jwt.JwtProvider;
import megabooks.megabooks.global.security.jwt.MegaBooksRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    private final JwtProvider jwtProvider;
    private final SecurityDeniedHandler securityDeniedHandler;
    private final SecurityExceptionHandler securityExceptionHandler;
    private final UserRepository userRepository;

    public SecurityConfig(@Autowired JwtProvider jwtProvider, UserRepository userRepository) {
        this.jwtProvider = jwtProvider;
        this.userRepository = userRepository;
        this.securityDeniedHandler = new SecurityDeniedHandler();
        this.securityExceptionHandler = new SecurityExceptionHandler();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable)
                .exceptionHandling(it -> {
                            it.authenticationEntryPoint(securityExceptionHandler);
                            it.accessDeniedHandler(securityDeniedHandler);
                        }
                )
                .sessionManagement(it -> it.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize ->
                        authorize.requestMatchers(HttpMethod.GET, "/actuator/health").permitAll()
                                .requestMatchers(HttpMethod.POST, "/api/v1/member/user/login", "/api/v1/member/user/join").permitAll()
                                // 스웨거
                                .requestMatchers( "/swagger-ui/**", "/v3/api-docs/**").permitAll()
                                // GET (User)
                                .requestMatchers(HttpMethod.GET, "/api/v1/**").hasRole(MegaBooksRole.USER.name())

                                // POST (User)
                                .requestMatchers(HttpMethod.POST, "/api/v1/**").hasRole(MegaBooksRole.USER.name())

                                // DELETE (User)
                                .requestMatchers(HttpMethod.DELETE, "/api/v1/**").hasRole(MegaBooksRole.USER.name())

                                // PUT (User)
                                .requestMatchers(HttpMethod.PUT, "/api/v1/**").hasRole(MegaBooksRole.USER.name())

                                // PATCH (User)
                                .requestMatchers(HttpMethod.PATCH, "/api/v1/**").hasRole(MegaBooksRole.USER.name())
                                .requestMatchers("/error").permitAll()
                                .requestMatchers("/**").denyAll()
                )
                .with(
                        new MegaBooksSecurityConfigurerAdapter(jwtProvider, userRepository),
                        it -> {}
                )
                .build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
