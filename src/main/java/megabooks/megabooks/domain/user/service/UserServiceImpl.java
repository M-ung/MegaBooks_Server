package megabooks.megabooks.domain.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import megabooks.megabooks.domain.user.dto.UserRequestDTO;
import megabooks.megabooks.domain.user.dto.UserResponseDTO;
import megabooks.megabooks.domain.user.entity.User;
import megabooks.megabooks.domain.user.mapper.UserMapper;
import megabooks.megabooks.domain.user.repository.UserRepository;
import megabooks.megabooks.global.exception.user.UserEmailDuplicationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

//    @Transactional
//    @Override
//    public UserResponseDTO.UserJoinDTO join(UserRequestDTO.UserJoinDTO userJoinDTO) {
//        if (userRepository.existsByUserEmail(userJoinDTO.getUserEmail())) {
//            throw new UserEmailDuplicationException(EMAIL_DUPLICATION_USER);
//        }
//
//
//        User user = UserMapper.toEntity(userJoinDTO);
//        userRepository.save(user);
//        return UserMapper.toDto(user);
//    }
//
//    @Override
//    public UserResponseDTO.UserFindOneDTO findOne(String userEmail) {
//        return userRepository.findOne(userEmail);
//    }
}
