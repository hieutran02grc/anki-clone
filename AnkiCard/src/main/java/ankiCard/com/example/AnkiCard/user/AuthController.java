package ankiCard.com.example.AnkiCard.user;

import ankiCard.com.example.AnkiCard.model.dto.LoginDto;
import ankiCard.com.example.AnkiCard.model.dto.RegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    IAuthService authService;


    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody(required = false) LoginDto loginRequest) {
        return  authService.login(loginRequest);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody RegisterDto signUpRequest) {
        return authService.register(signUpRequest);
    }


}
