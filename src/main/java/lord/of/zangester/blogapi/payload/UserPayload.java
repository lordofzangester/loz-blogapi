package lord.of.zangester.blogapi.payload;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class UserPayload {

    private Long id;

    @NotBlank(message = "name cannot be empty")
    private String name;

    @NotBlank(message = "username cannot be empty")
    @Pattern(regexp = "^[A-Za-z]\\w{5,29}$", message = "username not valid")
    private String username;

    @NotBlank(message = "email cannot be empty")
    @Email(message = "email not valid")
    private String email;

    @NotBlank(message = "password cannot be empty")
    @Size(min = 8, max = 20, message = "minimum length is 6 and maximum length is 20")
    private String password;

    public UserPayload(String name, String username, String email, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
