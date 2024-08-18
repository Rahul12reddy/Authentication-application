package Financial.example.User_management.Services;

import Financial.example.User_management.Entities.User;
import Financial.example.User_management.Repos.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository repo;
    private final PasswordEncoder passwordencoder;
    private final JwtService jwtService;

    private final AuthenticationManager authenticationmanager;

    public AuthService(UserRepository repo, PasswordEncoder passwordencoder, JwtService jwtService, AuthenticationManager authenticationmanager) {
        this.repo = repo;
        this.passwordencoder = passwordencoder;
        this.jwtService = jwtService;
        this.authenticationmanager = authenticationmanager;
    }
    public String getToken(User user){
        User obj=repo.findByEmail(user.getEmail()).orElseThrow();
        String token= jwtService.generateToken(user);
        return token;
    }
}
