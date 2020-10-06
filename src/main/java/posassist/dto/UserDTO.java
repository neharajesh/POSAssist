package posassist.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import posassist.enums.UserType;

@Data
public class UserDTO {
	@NotBlank
	@Size(min = 3, max = 50, message = "Name must be 3 To 50 characters long")
	private String name;
	
	@NotBlank
	@Size(min = 3, max = 50, message = "Name must be 3 To 50 characters long")
	private String userName;
	
	@NotBlank
    @Size(min = 6, max = 40, message = "Password should be 6 to 40 characters long")
	private String password;
	
    @Size(max = 60)
    @Email(message = "Invalid Email Address")
	private String emailId;
	
	@NotBlank
	@Size(max = 10)
	private String phoneNo;
	
    @Size(max = 60)
	private String address;
	
	private UserType userType;
	
}
