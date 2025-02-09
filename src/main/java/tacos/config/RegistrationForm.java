package tacos.config;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import tacos.entity.User;

@Data
public class RegistrationForm {

    private String username;
    private String password;
    private String fullName;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(username,
                passwordEncoder.encode(password),
                fullName,
                street,
                city,
                state,
                zip,
                phoneNumber);
    }
}
