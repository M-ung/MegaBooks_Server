package megabooks.megabooks.global.auth.config;

import lombok.RequiredArgsConstructor;
import megabooks.megabooks.domain.token.repository.RefreshTokenRepository;
import megabooks.megabooks.domain.token.service.TokenServiceImpl;
import megabooks.megabooks.domain.user.repository.UserRepository;
import megabooks.megabooks.global.auth.jwt.filter.JwtAuthenticationFilter;
import megabooks.megabooks.global.auth.jwt.filter.JwtAuthorizationFilter;
import megabooks.megabooks.global.auth.oauth2.PrincipalOauth2UserService;
import megabooks.megabooks.global.auth.oauth2.handler.Oauth2LoginFailureHandler;
import megabooks.megabooks.global.auth.oauth2.handler.Oauth2LoginSuccessHandler;
import megabooks.megabooks.global.common.config.CorsConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;

@Configuration
@EnableWebSecurity // 시큐리티 활성화 -> 기본 스프링 필터체인에 등록
@RequiredArgsConstructor
public class SecurityConfig {
    private final CorsConfig corsConfig;
    private final UserRepository userRepository;
    private final RefreshTokenRepository tokenRepository;
    private final TokenServiceImpl tokenService;
    @Value(("${jwt.secret}"))
    private String secretKey;

    /** Oauth2 로그인 구현 **/
    private final PrincipalOauth2UserService principalOauth2UserService;
    private final Oauth2LoginSuccessHandler oauth2LoginSuccessHandler;
    private final Oauth2LoginFailureHandler oauth2LoginFailureHandler;
    private final LogoutSuccessHandler logoutSuccessHandler;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    SecurityFilterChain configure(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception {
        return http
                .csrf(CsrfConfigurer::disable)
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 세션을 사용하지 않겠다.
                )
                .addFilter(corsConfig.corsFilter()) // @CrossOrigin(인증x), 시큐리티 필터에 등록 인증(o)
                .formLogin(login -> login
                        .disable()
                )
                .httpBasic(basic -> basic
                        .disable() // basic 방식은 id와 pw를 보내기 떄문에 노출이 될 가능성이 크다. 그래서 bearer token 방법을 쓴다.
                )
                .addFilter(new JwtAuthenticationFilter(authenticationManager, tokenRepository, secretKey))
                .addFilter(new JwtAuthorizationFilter(authenticationManager, userRepository, tokenService, secretKey))
                .authorizeRequests(authorize -> authorize
                                .requestMatchers("/swagger/index.html").permitAll()
                                .requestMatchers("/api/token/getAccessToken").permitAll()
                                .requestMatchers("/api/healthCheck").permitAll()
                                .requestMatchers("/api/v1/member/user/join").permitAll()
                                .requestMatchers("/api/v1/member/**")
                                .access("hasRole('ROLE_USER') or hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
                                .requestMatchers("/api/v1/manager/**")
                                .access("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
                                .requestMatchers("/api/v1/admin/**")
                                .access("hasRole('ROLE_ADMIN')")
//                        .anyRequest().permitAll()
                )

                /** Oauth2 로그인 구현 **/
                .oauth2Login(login -> login
                        .successHandler(oauth2LoginSuccessHandler)
                        .failureHandler(oauth2LoginFailureHandler)
                        .userInfoEndpoint(userInfoEndpointConfig -> userInfoEndpointConfig
                                .userService(principalOauth2UserService))
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessHandler(logoutSuccessHandler)
                        .deleteCookies("JSESSIONID")
                )
                .build();
    }
}