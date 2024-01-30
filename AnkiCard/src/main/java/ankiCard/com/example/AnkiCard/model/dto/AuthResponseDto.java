package ankiCard.com.example.AnkiCard.model.dto;

import lombok.Data;

@Data
public class AuthResponseDto {
    private String accessToken;
    private String refreshToken;
    private String tokenType = "Bearer ";
    private String username;

    public AuthResponseDto(String accessToken, String username) {
        this.accessToken = accessToken;
        this.username = username;
    }

}
