package megabooks.megabooks.domain.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import megabooks.megabooks.domain.user.dto.UserRequestDTO;
import megabooks.megabooks.domain.user.dto.UserResponseDTO;
import megabooks.megabooks.domain.user.entity.User;
import megabooks.megabooks.domain.user.repository.UserRepository;
import megabooks.megabooks.global.common.CommonMethod;
import megabooks.megabooks.global.common.exception.CustomException;
import megabooks.megabooks.global.common.reponse.ErrorCode;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final CommonMethod commonMethod;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional
    public UserResponseDTO.UserJoinDTO join(UserRequestDTO.UserJoinDTO userJoinDTO) {
        try {
            log.info("[UserServiceImpl] join");
            if (userRepository.existsByUserEmail(userJoinDTO.getUserEmail())) {
                throw new CustomException(ErrorCode.USER_EXIST);
            }

            userJoinDTO.setUserPassword(bCryptPasswordEncoder.encode(userJoinDTO.getUserPassword()));

            User user = userJoinDTO.toEntity();
            userRepository.save(user);
            return new UserResponseDTO.UserJoinDTO(user);
        } catch (CustomException ce){
            log.info("[CustomException] UserServiceImpl join");
            throw ce;
        } catch (Exception e){
            log.info("[Exception500] UserServiceImpl join");
            throw new CustomException(ErrorCode.SERVER_ERROR, "[Exception500] UserServiceImpl join : " + e.getMessage());
        }
    }

    @Override
    public UserResponseDTO.UserFindOneDTO findOne(String userEmail) {
        try {
            log.info("[UserServiceImpl] findOne");;
            return userRepository.findOne(userEmail);
        } catch (CustomException ce){
            log.info("[CustomException] UserServiceImpl findOne");
            throw ce;
        } catch (Exception e) {
            log.info("[Exception500] UserServiceImpl findOne");
            throw new CustomException(ErrorCode.SERVER_ERROR, "[Exception500] UserServiceImpl findOne : " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public UserResponseDTO.UserDeleteDTO delete(String userEmail) {
        try {
            log.info("[UserServiceImpl] delete");
            User findUser = commonMethod.getUser("email", userEmail);
            userRepository.delete(findUser);
            return new UserResponseDTO.UserDeleteDTO(findUser);
        } catch (CustomException ce){
            log.info("[CustomException] UserServiceImpl delete");
            throw ce;
        } catch (Exception e) {
            log.info("[Exception500] UserServiceImpl delete");
            throw new CustomException(ErrorCode.SERVER_ERROR, "[Exception500] UserServiceImpl delete : " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public UserResponseDTO.UserUpdateDTO update(UserRequestDTO.UserUpdateDTO userUpdateDTO, String userEmail) {
        try {
            log.info("[UserServiceImpl] update");
            User findUser = commonMethod.getUser("email", userEmail);
            findUser.userUpdate(userUpdateDTO);
            return new UserResponseDTO.UserUpdateDTO(findUser);
        } catch (CustomException ce){
            log.info("[CustomException] UserServiceImpl update");
            throw ce;
        } catch (Exception e) {
            log.info("[Exception500] UserServiceImpl update");
            throw new CustomException(ErrorCode.SERVER_ERROR, "[Exception500] UserServiceImpl update : " + e.getMessage());
        }
    }
}
