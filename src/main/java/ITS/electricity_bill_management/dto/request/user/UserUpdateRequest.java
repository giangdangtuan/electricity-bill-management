package ITS.electricity_bill_management.dto.request.user;

import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateRequest {
    @Size(min = 3, message = "EMAIL_VALID")
    String email;
    @Size(min = 8, message = "USERNAME_VALID")
    String username;
    @Size(min = 8, message = "PASSWORD_VALID")
    String password;

    List<String> roles;
}
