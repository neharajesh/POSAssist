package posassist.dao.response;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Data;
import posassist.entities.Role;
import posassist.entities.User;


@Data
@Builder
public class UserResponse {
	private Long id;
    private String name;
    private String emailId;
    private List<Role> roles;

    public static UserResponse createFromUser(User user) {
        List<Role> roles = new ArrayList<>(user.getRole());
        return UserResponse.builder()
                .id(user.getId())
                .emailId(user.getEmailId())
                .name(user.getName())
                .roles(roles)
                .build();
    }
}
