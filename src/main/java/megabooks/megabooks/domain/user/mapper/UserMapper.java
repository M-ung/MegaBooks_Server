package megabooks.megabooks.domain.user.mapper;

import megabooks.megabooks.domain.user.dto.UserRequestDTO;
import megabooks.megabooks.domain.user.dto.UserResponseDTO;
import megabooks.megabooks.domain.user.entity.User;
import megabooks.megabooks.domain.user.entity.UserStatus;
import megabooks.megabooks.global.security.jwt.MegaBooksRole;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserMapper {
    private static final ModelMapper modelMapper = new ModelMapper();
    public User toUserEntity(UserRequestDTO.UserJoinDTO userJoinDTO, PasswordEncoder passwordEncoder) {
        return User.builder()
                .userEmail(userJoinDTO.getUserEmail())
                .userPassword(passwordEncoder.encode(userJoinDTO.getUserPassword()))
                .userName(userJoinDTO.getUserName())
                .lastLogin(LocalDateTime.now())
                .userStatus(UserStatus.ACTIVE)
                .megaBooksRole(MegaBooksRole.USER)
                .build();
    }

    public UserResponseDTO.UserJoinDTO toUserJoinResDTO(User user) {
        return modelMapper.map(user, UserResponseDTO.UserJoinDTO.class);
    }
}
