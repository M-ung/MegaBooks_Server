package megabooks.megabooks.domain.user.repository;

import megabooks.megabooks.domain.user.dto.UserResponseDTO;

public interface UserRepositoryCustom {
    UserResponseDTO.UserFindOneDTO findOneByUserId(Long userId);
}
