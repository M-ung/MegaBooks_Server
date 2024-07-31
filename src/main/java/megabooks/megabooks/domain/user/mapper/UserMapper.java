package megabooks.megabooks.domain.user.mapper;

import megabooks.megabooks.domain.user.dto.UserRequestDTO;
import megabooks.megabooks.domain.user.dto.UserResponseDTO;
import megabooks.megabooks.domain.user.entity.User;
import org.modelmapper.ModelMapper;

public class UserMapper {
    private static final ModelMapper modelMapper = new ModelMapper();
    public static User toEntity(UserRequestDTO.UserJoinDTO userJoinDTO) {
        return modelMapper.map(userJoinDTO, User.class);
    }

    public static UserResponseDTO.UserJoinDTO toDto(User user) {
        return modelMapper.map(user, UserResponseDTO.UserJoinDTO.class);
    }
}
