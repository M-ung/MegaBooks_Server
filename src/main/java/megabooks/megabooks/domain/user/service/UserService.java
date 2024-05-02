package megabooks.megabooks.domain.user.service;

import megabooks.megabooks.domain.user.dto.UserResponseDTO;

public interface UserService {
    // 회원 조회
    UserResponseDTO.UserFindOneDTO findOne(String userEmail);
}
