package runrun.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }


    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return service.login(user);
    }

    @GetMapping("/me")
    public User getMe(@RequestHeader("Authorization") String token) {
        return service.getUserByToken(token);
    }

    @PostMapping("/logout")
    public String logout(@RequestHeader("Authorization") String token) {
        service.logout(token);
        return "로그아웃 성공";
    }
}
