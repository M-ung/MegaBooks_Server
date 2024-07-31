package megabooks.megabooks.domain.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import megabooks.megabooks.domain.user.dto.UserRequestDTO;
import megabooks.megabooks.domain.user.dto.UserResponseDTO;
import megabooks.megabooks.domain.user.entity.User;
import megabooks.megabooks.domain.user.mapper.UserMapper;
import megabooks.megabooks.domain.user.repository.UserRepository;
import megabooks.megabooks.global.exception.user.UserEmailDuplicationException;
import megabooks.megabooks.global.exception.user.UserInvalidPasswordException;
import megabooks.megabooks.global.exception.user.UserNotFoundException;
import megabooks.megabooks.global.security.jwt.JwtDto;
import megabooks.megabooks.global.security.jwt.JwtProvider;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static megabooks.megabooks.global.exception.ErrorCode.*;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final JwtProvider jwtProvider;

    @Override
    @Transactional
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

    @Override
    @Transactional
    public JwtDto login(UserRequestDTO.UserLoginDTO userLoginDTO) {
        User findUser = getUser_Email(userLoginDTO.getUserEmail());
        checkPassword(userLoginDTO.getUserPassword(), findUser, passwordEncoder);
        return jwtProvider.createJwtDto(findUser.getUserId(), findUser.getMegaBooksRole());
    }

    @Override
    public UserResponseDTO.UserFindOneDTO findOne(Long userId) {
        return userRepository.findOneByUserId(userId);
    }

    @Override
    @Transactional
    public void updatePassword(UserRequestDTO.UserUpdatePasswordDTO userUpdatePasswordDTO, Long userId) {
        User findUser = getUser_Id(userId);
        findUser.updatePassword(userUpdatePasswordDTO, passwordEncoder);
    }

    @Override
    @Transactional
    public void updateName(UserRequestDTO.UserUpdateNameDTO userUpdateNameDTO, Long userId) {
        User findUser = getUser_Id(userId);
        findUser.updateName(userUpdateNameDTO);
    }

    /** 추가 메서드 **/
    private static void checkPassword(String password, User findUser, PasswordEncoder passwordEncoder) {
        if(!passwordEncoder.matches(password, findUser.getUserPassword())) {
            throw new UserInvalidPasswordException(INVALID_PASSWORD_USER);
        }
    }
    private User getUser_Id(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(!optionalUser.isPresent()) {
            throw new UserNotFoundException(NOT_FOUND_USER);
        }
        return optionalUser.get();
    }
    private User getUser_Email(String userEmail) {
        Optional<User> optionalUser = userRepository.findByUserEmail(userEmail);
        if(!optionalUser.isPresent()) {
            throw new UserNotFoundException(NOT_FOUND_USER);
        }
        return optionalUser.get();
    }

}
