package org.senechka.lab1.security.jwt;

import lombok.RequiredArgsConstructor;

import org.senechka.lab1.models.Roles;
import org.senechka.lab1.models.User;
import org.senechka.lab1.security.DTO.ResponseDTO;
import org.senechka.lab1.security.DTO.SignInDTO;
import org.senechka.lab1.security.DTO.SignUpDTO;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserService userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    /**
     * Регистрация пользователя
     *
     * @param request данные пользователя
     * @return токен
     */
    public ResponseDTO signUp(SignUpDTO request) {

        var user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPass()))
                .role(Roles.USER)
                .build();

        userService.create(user);

        var jwt = jwtService.generateToken(user);
        return new ResponseDTO(jwt);
    }

    /**
     * Аутентификация пользователя
     *
     * @param request данные пользователя
     * @return токен
     */
    public ResponseDTO signIn(SignInDTO request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPass()
        ));

        var user = userService
                .userDetailsService()
                .loadUserByUsername(request.getUsername());

        var jwt = jwtService.generateToken(user);
        return new ResponseDTO(jwt);
    }
}