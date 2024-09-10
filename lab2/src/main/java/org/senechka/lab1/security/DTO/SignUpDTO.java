package org.senechka.lab1.security.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class SignUpDTO {
    private String username;
    private String pass;
    private String email;
}
