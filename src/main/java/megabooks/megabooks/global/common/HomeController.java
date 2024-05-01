package megabooks.megabooks.global.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    //
    @GetMapping("/login/oauth2/code/kakao")
    public String home(){
        return "success";
    }
}
