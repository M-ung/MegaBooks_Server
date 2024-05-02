package megabooks.megabooks.domain.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import megabooks.megabooks.domain.user.dto.UserResponseDTO;
import megabooks.megabooks.domain.user.repository.UserRepository;
import megabooks.megabooks.global.common.CommonMethod;
import megabooks.megabooks.global.common.exception.CustomException;
import megabooks.megabooks.global.common.reponse.ErrorCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final CommonMethod commonMethod;
    @Override
    public UserResponseDTO.UserFindOneDTO findOne(String userEmail) {
        try {
            log.info("[UserServiceImpl] findOne");
            log.info(userEmail);
            UserResponseDTO.UserFindOneDTO result = userRepository.findOne(userEmail);
            return result;
        } catch (CustomException ce){
            log.info("[CustomException] UserServiceImpl findOne");
            throw ce;
        } catch (Exception e) {
            log.info("[Exception500] UserServiceImpl findOne");
            throw new CustomException(ErrorCode.SERVER_ERROR, "UserServiceImpl findOne : " + e.getMessage());
        }
    }
}
