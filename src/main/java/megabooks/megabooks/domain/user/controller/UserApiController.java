package megabooks.megabooks.domain.user.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import megabooks.megabooks.domain.user.dto.UserResponseDTO;
import megabooks.megabooks.domain.user.entity.User;
import megabooks.megabooks.domain.user.service.UserServiceImpl;
import megabooks.megabooks.global.auth.service.AuthenticationService;
import megabooks.megabooks.global.common.exception.Exception500;
import megabooks.megabooks.global.common.reponse.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@Slf4j
public class UserApiController {
    private final UserServiceImpl userService;
    private final AuthenticationService authenticationService;

    @GetMapping("/findOne")
    public ResponseEntity<?> findOne() {
        try {
            log.info("[UserApiController] findOne");
            String userEmail = getUserEmail();
            log.info("[UserApiController] userEmail" + userEmail);
            UserResponseDTO.UserFindOneDTO result = userService.findOne(userEmail);
            return ResponseEntity.ok().body(ApiResponse.SUCCESS(HttpStatus.CREATED.value(), "user findOne success", result));
        }  catch (Exception500 e) {
            log.info("[Exception500] UserApiController findOne");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.ERROR(e.status().value(), e.getMessage()));
        }
    }

    private String getUserEmail() {
        User user = authenticationService.getCurrentAuthenticatedUser();
        String userEmail = user.getUserEmail();
        return userEmail;
    }
}
