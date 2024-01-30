package ankiCard.com.example.AnkiCard.security.jwt;

import java.util.Date;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.List;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;


@Component
public class JwtTokenProvider {

    public String createToken(Authentication authentication, List<String> roles) {

        String username = authentication.getName();
        Date timeActual = new Date();
        Date expiractionToken = new Date(timeActual.getTime() + ConstantSecureJwt.JWT_EXPIRATION_TOKEN);

        String token = null;
        try {
            token = Jwts.builder()
                    .setSubject(username)
                    .claim("role",roles)
                    .setIssuedAt(new Date())
                    .setExpiration(expiractionToken)
                    .signWith(key(),SignatureAlgorithm.HS256)
                    .compact();
            
        }catch (Exception e){
            e.printStackTrace();
        }
        
        return token;
    }

    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(ConstantSecureJwt.ANKI_KEY));
    }

    public String obtainUsernameByJwt(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(ConstantSecureJwt.ANKI_KEY)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    public Boolean validateToken(String token){
        try {
            Jwts.parser().setSigningKey(ConstantSecureJwt.ANKI_KEY).parseClaimsJws(token);
            return true;
        }catch (Exception e){
            throw new AuthenticationCredentialsNotFoundException("Jwt incorrect");
        }
    }

}
