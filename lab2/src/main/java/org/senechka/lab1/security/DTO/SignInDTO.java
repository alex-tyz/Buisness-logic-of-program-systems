package org.senechka.lab1.security.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class SignInDTO {
    private String username;
    private String pass;
}
