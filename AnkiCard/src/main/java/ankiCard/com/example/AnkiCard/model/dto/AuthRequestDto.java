package ankiCard.com.example.AnkiCard.model.dto;

public class AuthRequestDto {
    private String accessToken;
    private String tokenType = "Bearer ";

    private AuthRequestDto(String accessToken){
        this.accessToken = accessToken;
    }
}
