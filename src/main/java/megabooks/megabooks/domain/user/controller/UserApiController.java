package megabooks.megabooks.domain.user.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import megabooks.megabooks.domain.user.dto.UserRequestDTO;
import megabooks.megabooks.domain.user.dto.UserResponseDTO;
import megabooks.megabooks.domain.user.service.UserService;
import megabooks.megabooks.global.reponse.CustomResponse;
import megabooks.megabooks.global.security.jwt.JwtDto;
import megabooks.megabooks.global.security.util.SecurityUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/member/user")
@Tag(name = "User", description = "회원 관련 API")
@RequiredArgsConstructor
@Slf4j
public class UserApiController {
    private final UserService userService;

    @PostMapping("/join")
    @Operation(summary = "회원 가입", description = "회원 가입합니다.")
    public CustomResponse<UserResponseDTO.UserFindDetailDTO> join(@Parameter(description = "회원 가입 정보를 담는 DTO")
                                                   @RequestBody  UserRequestDTO.UserJoinDTO userJoinDTO) {
        return CustomResponse.SUCCESS(HttpStatus.OK.value(), userService.join(userJoinDTO));
    }

    /** 회원 로그인 API **/
    @PostMapping("/login")
    @Operation(summary = "로그인 API", description = "로그인 API 입니다.")
    public CustomResponse<JwtDto> login(@Parameter(description = "로그인 정보를 담고 있는 DTO")
                                   @RequestBody UserRequestDTO.UserLoginDTO userLoginDTO) {
        return CustomResponse.SUCCESS(HttpStatus.OK.value(), userService.login(userLoginDTO));
    }
    @GetMapping("/findOne")
    @Operation(summary = "회원 조회", description = "회원을 조회합니다.")
    public CustomResponse<UserResponseDTO.UserFindDetailDTO> findOneByUserId() {
        return CustomResponse.SUCCESS(HttpStatus.OK.value(), userService.findOne(SecurityUtil.getCurrentId()));
    }

    @PostMapping("/updatePassword")
    @Operation(summary = "회원 비밀번호 수정", description = "회원 비밀번호 수정합니다.")
    public CustomResponse<?> updatePassword(@Parameter(description = "회원 수정 정보를 담는 DTO")
                                  @RequestBody UserRequestDTO.UserUpdatePasswordDTO userUpdatePasswordDTO) {
        userService.updatePassword(userUpdatePasswordDTO, SecurityUtil.getCurrentId()); 
        return CustomResponse.SUCCESS(HttpStatus.OK.value());
    }

    @PostMapping("/updateName")
    @Operation(summary = "회원 이름 수정", description = "회원 이름 수정합니다.")
    public CustomResponse<?> updateName(@Parameter(description = "회원 수정 정보를 담는 DTO")
                                  @RequestBody UserRequestDTO.UserUpdateNameDTO userUpdateNameDTO) {
        userService.updateName(userUpdateNameDTO, SecurityUtil.getCurrentId());
        return CustomResponse.SUCCESS(HttpStatus.OK.value());
    }

}
