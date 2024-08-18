package Financial.example.User_management.Controllers;

import Financial.example.User_management.Entities.User;
import Financial.example.User_management.Services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private AuthService authService;
    @GetMapping("/tokenGenerator")
    public String getToken(@RequestBody User user){
        return authService.getToken(user);
    }
    @GetMapping("/Hello")
    public String hello(){
        return "Hello, Welcome to the app";
    }
}
