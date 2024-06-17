package bg.softuni.phatfinder.model.DTOs;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRegisterDTO {

    @NotEmpty
    @NotNull
    private String username;

    @NotEmpty
    @Size(min = 5)
    private String fullName;

    @Email
    private String email;

    @Min(18)
    @Max(110)
    private String age;

    @Size(min = 5)
    private String password;
    @Size(min = 5)
    private String confirmPassword;
}
