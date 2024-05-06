package megabooks.megabooks.domain.user.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import megabooks.megabooks.domain.user.dto.UserRequestDTO;
import megabooks.megabooks.domain.user.dto.UserResponseDTO;
import megabooks.megabooks.domain.user.entity.User;
import megabooks.megabooks.domain.user.service.UserServiceImpl;
import megabooks.megabooks.global.auth.service.AuthenticationService;
import megabooks.megabooks.global.common.exception.Exception500;
import megabooks.megabooks.global.common.reponse.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/member/user")
@RequiredArgsConstructor
@Slf4j
public class UserApiController {
    private final UserServiceImpl userService;
    private final AuthenticationService authenticationService;

    // login
    // http://localhost:8080/oauth2/authorization/kakao

    // 회원 가입
    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody UserRequestDTO.UserJoinDTO userJoinDTO) {
        try {
            log.info("[UserApiController] join");
            UserResponseDTO.UserJoinDTO result = userService.join(userJoinDTO);
            return ResponseEntity.ok().body(ApiResponse.SUCCESS(HttpStatus.CREATED.value(), "[SUCCESS] UserApiController join", result));
        }  catch (Exception500 e) {
            log.info("[Exception500] UserApiController join");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.ERROR(e.status().value(), e.getMessage()));
        }
    }
    @GetMapping("/findOne")
    public ResponseEntity<?> findOne() {
        try {
            log.info("[UserApiController] findOne");
            String userEmail = getUserEmail();
            UserResponseDTO.UserFindOneDTO result = userService.findOne(userEmail);
            return ResponseEntity.ok().body(ApiResponse.SUCCESS(HttpStatus.CREATED.value(), "[SUCCESS] UserApiController findOne", result));
        }  catch (Exception500 e) {
            log.info("[Exception500] UserApiController findOne");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.ERROR(e.status().value(), e.getMessage()));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete() {
        try {
            log.info("[UserApiController] delete");
            String userEmail = getUserEmail();
            UserResponseDTO.UserDeleteDTO result = userService.delete(userEmail);
            return ResponseEntity.ok().body(ApiResponse.SUCCESS(HttpStatus.CREATED.value(), "[SUCCESS] UserApiController delete", result));
        }  catch (Exception500 e) {
            log.info("[Exception500] UserApiController delete");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.ERROR(e.status().value(), e.getMessage()));
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody UserRequestDTO.UserUpdateDTO userUpdateDTO) {
        try {
            log.info("[UserApiController] update");
            String userEmail = getUserEmail();
            UserResponseDTO.UserUpdateDTO result = userService.update(userUpdateDTO, userEmail);
            return ResponseEntity.ok().body(ApiResponse.SUCCESS(HttpStatus.CREATED.value(), "[SUCCESS] UserApiController update", result));
        }  catch (Exception500 e) {
            log.info("[Exception500] UserApiController update");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.ERROR(e.status().value(), e.getMessage()));
        }
    }

    private String getUserEmail() {
        User user = authenticationService.getCurrentAuthenticatedUser();
        String userEmail = user.getUserEmail();
        return userEmail;
    }
}
