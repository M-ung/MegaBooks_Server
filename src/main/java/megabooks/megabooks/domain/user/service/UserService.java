package megabooks.megabooks.domain.user.service;

import megabooks.megabooks.domain.user.dto.UserRequestDTO;
import megabooks.megabooks.domain.user.dto.UserResponseDTO;
import megabooks.megabooks.domain.user.entity.User;
import megabooks.megabooks.global.security.jwt.JwtDto;

public interface UserService {
    // 회원 가입
    UserResponseDTO.UserFindDetailDTO join(UserRequestDTO.UserJoinDTO userJoinDTO);
    // 로그인
    JwtDto login(UserRequestDTO.UserLoginDTO userLoginDTO);
    // 회원 조회
    UserResponseDTO.UserFindDetailDTO findOne(Long userId);
    // 회원 비밀번호 수정
    void updatePassword(UserRequestDTO.UserUpdatePasswordDTO userUpdatePasswordDTO, Long userId);
    // 회원 이름 수정
    void updateName(UserRequestDTO.UserUpdateNameDTO userUpdateNameDTO, Long userId);
    //    // 회원 탈퇴
//    UserResponseDTO.UserDeleteDTO delete(String userEmail);
//    // 로그아웃

    User getUser_Id(Long userId);
    User getUser_Email(String userEmail);
}
