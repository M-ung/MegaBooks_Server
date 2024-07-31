package megabooks.megabooks.domain.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import megabooks.megabooks.domain.user.dto.UserRequestDTO;
import megabooks.megabooks.domain.user.dto.UserResponseDTO;
import megabooks.megabooks.domain.user.entity.User;
import megabooks.megabooks.domain.user.mapper.UserMapper;
import megabooks.megabooks.domain.user.repository.UserRepository;
import megabooks.megabooks.global.exception.user.UserEmailDuplicationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static megabooks.megabooks.global.exception.ErrorCode.EMAIL_DUPLICATION_USER;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Override
    public UserResponseDTO.UserJoinDTO join(UserRequestDTO.UserJoinDTO userJoinDTO) {
        // 이메일 중복 확인
        if(userRepository.findByUserEmail(userJoinDTO.getUserEmail()).isPresent()) {
            throw new UserEmailDuplicationException(EMAIL_DUPLICATION_USER);
        }

        // User 생성 및 저장
        User user = userRepository.save(userMapper.toUserEntity(userJoinDTO, passwordEncoder));

        // UserResponseDTO.UserJoinDTO 반환
        return userMapper.toUserJoinResDTO(user);
    }
}
