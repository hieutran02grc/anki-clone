package ankiCard.com.example.AnkiCard.user;

import ankiCard.com.example.AnkiCard.model.Role;
import ankiCard.com.example.AnkiCard.model.User;
import ankiCard.com.example.AnkiCard.model.dto.AuthResponseDto;
import ankiCard.com.example.AnkiCard.security.AnkiUserDetail;
import ankiCard.com.example.AnkiCard.model.dto.LoginDto;
import ankiCard.com.example.AnkiCard.model.dto.RegisterDto;
import ankiCard.com.example.AnkiCard.security.jwt.JwtTokenProvider;
import ankiCard.com.example.AnkiCard.security.response.MessageResponse;
import ankiCard.com.example.AnkiCard.user.role.IRoleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AuthService implements IAuthService{

    AuthenticationManager authenticationManager;

    IUserRepository userRepository;

    IRoleRepository roleRepository;

    PasswordEncoder passwordEncoder;

    JwtTokenProvider jwtTokenProvider;


    public AuthService(IUserRepository userRepository, JwtTokenProvider jwtTokenProvider, IRoleRepository roleRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public ResponseEntity<?> register(RegisterDto registerDto) {
        if (userRepository.existsByEmail(registerDto.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already taken!"));
        }

        // set value for user
        User user = new User(registerDto.getUsername(),
                passwordEncoder.encode(registerDto.getPassword()));
        user.setCreatedTime(new Date(System.currentTimeMillis()));
        user.setEnabled(true);
        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findbyName("USER");
        roles.add(userRole);
        user.setRoles(roles);
        userRepository.save(user);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @Transactional
    @Override
    public ResponseEntity<?> login(LoginDto LoginDto ) {
        Authentication authentication = null;

        authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(LoginDto.getUsername(),
                            LoginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        AnkiUserDetail userDetails = (AnkiUserDetail) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        String jwt = jwtTokenProvider.createToken(authentication, roles);

        return ResponseEntity.ok(new AuthResponseDto(jwt, userDetails.getUsername()));

    }
}
