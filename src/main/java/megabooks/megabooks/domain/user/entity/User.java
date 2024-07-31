package megabooks.megabooks.domain.user.entity;

import jakarta.persistence.*;
import lombok.*;
import megabooks.megabooks.domain.user.dto.UserRequestDTO;
import megabooks.megabooks.global.entity.BaseEntity;
import megabooks.megabooks.global.security.jwt.MegaBooksRole;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;


@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, unique = true)
    private String userEmail;

    @Column(nullable = false)
    private String userPassword;

    @Column(nullable = false)
    private String userName;

    private String kakaoId;

    private LocalDateTime lastLogin;

    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

    @Enumerated(EnumType.STRING)
    private MegaBooksRole megaBooksRole;

    public void updatePassword(UserRequestDTO.UserUpdatePasswordDTO userUpdatePasswordDTO, PasswordEncoder passwordEncoder) {
        this.userPassword = passwordEncoder.encode(userUpdatePasswordDTO.getUserPassword());
    }
    public void updateName(UserRequestDTO.UserUpdateNameDTO userUpdateNameDTO) {
        this.userName = userUpdateNameDTO.getUserName();
    }
}
