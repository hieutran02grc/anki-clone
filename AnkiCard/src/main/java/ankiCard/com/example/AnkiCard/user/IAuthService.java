package ankiCard.com.example.AnkiCard.user;

import ankiCard.com.example.AnkiCard.model.dto.LoginDto;
import ankiCard.com.example.AnkiCard.model.dto.RegisterDto;
import org.springframework.http.ResponseEntity;

public interface IAuthService {

    ResponseEntity<?> register(RegisterDto registerDto);
    ResponseEntity<?> login(LoginDto LoginDto);
}
