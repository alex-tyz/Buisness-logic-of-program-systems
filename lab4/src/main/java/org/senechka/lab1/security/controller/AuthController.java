package org.senechka.lab1.security.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.senechka.lab1.security.DTO.ResponseDTO;
import org.senechka.lab1.security.DTO.SignInDTO;
import org.senechka.lab1.security.DTO.SignUpDTO;
import org.senechka.lab1.security.jwt.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthController {
    @Autowired
    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Autowired
    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseDTO signUp(@ModelAttribute SignUpDTO request) {
        ResponseDTO xyu = authenticationService.signUp(request);
        return xyu;
    }


    @PostMapping("/signin")
    public ResponseDTO signIn(@ModelAttribute SignInDTO request) {
        ResponseDTO xyu2 = authenticationService.signIn(request);
        System.out.println("____________________________________________________"+xyu2.toString()+"__________________\n\n");
        return xyu2;
    }
}
