package alfa.homework17.com.lesson.homework.models;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    private String nome;
    private String email;
    private String password;
    private String administrador;
}
