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
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "SUCCESS", content = @Content(schema = @Schema(implementation = UserResponseDTO.UserJoinDTO.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = CustomResponse.class))),
            @ApiResponse(responseCode = "404", description = "Data Not Found", content = @Content(schema = @Schema(implementation = CustomResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = CustomResponse.class)))
    })
    public ResponseEntity<?> join(@Parameter(description = "회원 가입 정보를 담는 DTO")
                                                   UserRequestDTO.UserJoinDTO userJoinDTO) {
        return ResponseEntity.ok().body(CustomResponse.SUCCESS(HttpStatus.CREATED.value(), userService.join(userJoinDTO)));
    }

    /** 회원 로그인 API **/
    @PostMapping("/login")
    @Operation(summary = "로그인 API", description = "로그인 API 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "SUCCESS", content = @Content(schema = @Schema(implementation = JwtDto.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = CustomResponse.class))),
            @ApiResponse(responseCode = "404", description = "Data Not Found", content = @Content(schema = @Schema(implementation = CustomResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = CustomResponse.class)))
    })
    public ResponseEntity<?> login(@Parameter(description = "로그인 정보를 담고 있는 DTO")
                                   @RequestBody UserRequestDTO.UserLoginDTO userLoginDTO) {
        return ResponseEntity.ok().body(CustomResponse.SUCCESS(HttpStatus.CREATED.value(), userService.login(userLoginDTO)));
    }
    @GetMapping("/findOne/{userId}")
    @Operation(summary = "회원 조회", description = "회원을 조회합니다.")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "SUCCESS", content = @Content(schema = @Schema(implementation = UserResponseDTO.UserFindOneDTO.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = CustomResponse.class))),
            @ApiResponse(responseCode = "404", description = "Data Not Found", content = @Content(schema = @Schema(implementation = CustomResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = CustomResponse.class)))
    })
    public ResponseEntity<?> findOneByUserId(@Parameter(description = "회원 고유 식별자")
                                                   @PathVariable("userId") Long userId) {
        return ResponseEntity.ok().body(CustomResponse.SUCCESS(HttpStatus.CREATED.value(), userService.findOne(userId)));
    }

    @PostMapping("/updatePassword")
    @Operation(summary = "회원 비밀번호 수정", description = "회원 비밀번호 수정합니다.")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "SUCCESS"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = CustomResponse.class))),
            @ApiResponse(responseCode = "404", description = "Data Not Found", content = @Content(schema = @Schema(implementation = CustomResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = CustomResponse.class)))
    })
    public ResponseEntity<?> updatePassword(@Parameter(description = "회원 수정 정보를 담는 DTO")
                                  UserRequestDTO.UserUpdatePasswordDTO userUpdatePasswordDTO) {
        userService.updatePassword(userUpdatePasswordDTO, SecurityUtil.getCurrentId());
        return ResponseEntity.ok().body(CustomResponse.SUCCESS(HttpStatus.CREATED.value()));
    }

    @PostMapping("/updateName")
    @Operation(summary = "회원 이름 수정", description = "회원 이름 수정합니다.")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "SUCCESS"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = CustomResponse.class))),
            @ApiResponse(responseCode = "404", description = "Data Not Found", content = @Content(schema = @Schema(implementation = CustomResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = CustomResponse.class)))
    })
    public ResponseEntity<?> updateName(@Parameter(description = "회원 수정 정보를 담는 DTO")
                                  UserRequestDTO.UserUpdateNameDTO userUpdateNameDTO) {
        userService.updateName(userUpdateNameDTO, SecurityUtil.getCurrentId());
        return ResponseEntity.ok().body(CustomResponse.SUCCESS(HttpStatus.CREATED.value()));
    }

}
